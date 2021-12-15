package es.brunomendoza.dsw.controller;

import es.brunomendoza.dsw.dao.CountryDao;
import es.brunomendoza.dsw.dao.CustomerDao;
import es.brunomendoza.dsw.dto.CustomerDto;
import es.brunomendoza.dsw.model.Customer;
import es.brunomendoza.dsw.util.LoginFormValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

// https://tomcat.apache.org/tomcat-9.0-doc/default-servlet.html

@WebServlet(urlPatterns = {""}, name = "home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        Cookie cookie;
        Cookie[] cookies = req.getCookies();
        String target = "home.jsp";

        if (cookies != null) {
            cookie = Arrays.stream(cookies)
                    .filter(c -> c.getName().equals("dsw"))
                    .findFirst()
                    .orElse(null);

            if (cookie != null && cookie.getMaxAge() != 0) {
                target = "/customer";
                cookie.setMaxAge(3600 * 24 * 7);
            }
        }

        req.getRequestDispatcher(target).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        CustomerDao customerDao = new CustomerDao();
        CountryDao countryDao = new CountryDao();
        Customer customer;
        Cookie cookie;
        List<String> errors = LoginFormValidator.validate(req.getParameterMap());
        String target = "home.jsp";
        CustomerDto customerDto;

        if (errors.size() > 0) {
            req.setAttribute("es.brunomendoza.dsw.att.errors", errors);
        } else {
            try {
                customer = customerDao.authenticate(req.getParameter("username"), req.getParameter("password"));

                if (customer == null) {
                    errors.add("authentication");
                    req.setAttribute("es.brunomendoza.dsw.att.errors", errors);
                } else {
                    customerDto = new CustomerDto(
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getBirthdate(),
                            customer.getAddress(),
                            customer.getPhoneNumber1(),
                            customer.getPhoneNumber2(),
                            customer.getEmail(),
                            countryDao.getById(customer.getCountryId()).getName()
                    );
                    cookie = new Cookie("dsw", String.valueOf(customer.getId()));
                    cookie.setMaxAge(3600 * 7 * 24);
                    resp.addCookie(cookie);
                    // https://jakarta.ee/specifications/platform/9/apidocs/
                    req.setAttribute("es.brunomendoza.dsw.att.customer", customerDto);
                    target = "customer.jsp";
                }
            } catch (SQLException | ClassNotFoundException e) {
                errors.add("system");
                req.setAttribute("es.brunomendoza.dsw.att.errors", errors);
            }
        }

        req.getRequestDispatcher(target).forward(req, resp);
    }
}

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
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
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

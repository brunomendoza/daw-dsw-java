package es.brunomendoza.dsw.controller;

import es.brunomendoza.dsw.dao.CountryDao;
import es.brunomendoza.dsw.dao.CustomerDao;
import es.brunomendoza.dsw.dto.CustomerDto;
import es.brunomendoza.dsw.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = {"/customer/*"}, name = "customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer;
        CustomerDao customerDao = new CustomerDao();
        CountryDao countryDao = new CountryDao();
        CustomerDto customerDto;
        Cookie[] cookies = req.getCookies();
        Cookie cookie;
        Object obj;
        List<String> errors;
        String target = "/";

        if (cookies != null) {
            cookie = Arrays.stream(cookies)
                    .filter(c -> c.getName().equals("dsw"))
                    .findFirst()
                    .orElse(null);

            obj = req.getAttribute("es.brunomendoza.dsw.att.customer");

            if (cookie != null) {
                if (obj == null) {
                    try {
                        customer = customerDao.getById(Long.valueOf(cookie.getValue()));

                        if (customer != null) {
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

                            req.setAttribute("es.brunomendoza.dsw.att.customer", customerDto);
                            target = "customer.jsp";
                        } else {
                            // Cookie dsw doesn't contain a valid customer identifier
                            cookie.setMaxAge(0);
                            resp.addCookie(cookie);
                            errors = new ArrayList<>();
                            errors.add("not_found");
                            req.setAttribute("es.brunomendoza.dsw.att.errors", errors);
                        }
                    } catch (Exception e) {
                        errors = new ArrayList<>();
                        errors.add("system");
                        req.setAttribute("es.brunomendoza.dsw.att.errors", errors);
                    }
                }
            }
        }

        req.getRequestDispatcher(target).forward(req, resp);
    }

    private void print() {

    }

    private void save() {

    }

    private void edit() {

    }
}

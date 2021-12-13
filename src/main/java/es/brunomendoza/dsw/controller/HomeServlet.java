package es.brunomendoza.dsw.controller;

import es.brunomendoza.dsw.dao.CustomerDao;
import es.brunomendoza.dsw.model.Customer;
import es.brunomendoza.dsw.util.LoginFormValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// https://tomcat.apache.org/tomcat-9.0-doc/default-servlet.html

@WebServlet(urlPatterns = {""}, name = "home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        Cookie cookie;

        if (req.getCookies() == null) {
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            List<Cookie> cookies = Arrays.asList(req.getCookies());
            cookie = cookies
                    .stream()
                    .filter(c -> c.getName().equals("dsw"))
                    .findFirst()
                    .orElse(null);
            resp.getWriter().append("Yeah");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        CustomerDao customerDao = new CustomerDao();
        Customer customer;
        Cookie cookie;
        List<String> errors = LoginFormValidator.validate(req.getParameterMap());

        if (errors.size() > 0) {
            req.setAttribute("es.brunomendoza.dsw.att.errors", errors);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            customer = customerDao.authenticate(req.getParameter("username"), req.getParameter("password"));

            if (customer == null) {
                errors.add("authentication");
                req.setAttribute("es.brunomendoza.dsw.att.errors", errors);
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            } else {
                cookie = new Cookie("dsw", "wsd");
                resp.addCookie(cookie);
                req.setAttribute("customer", customer);
                req.getRequestDispatcher("customer").forward(req, resp);
            }
        }
    }
}

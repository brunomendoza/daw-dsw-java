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
//        resp.getOutputStream().print("Fuck");
        req.getRequestDispatcher(target).forward(req, resp);
    }
}

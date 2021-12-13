package es.brunomendoza.dsw.controller;
import es.brunomendoza.dsw.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(value = {"/customer"}, name = "customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer)req.getAttribute("es.brunomendoza.att.customer");
        if (customer != null) {
            req.getRequestDispatcher("customer.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.getRequestDispatcher("customer.jsp").forward(req, resp);
    }
}

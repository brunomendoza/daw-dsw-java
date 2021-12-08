package es.brunomendoza.dsw.controller;

import es.brunomendoza.dsw.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        CustomerDao customerDao = new CustomerDao();
        System.out.println(customerDao.getById(1L));
        resp.getWriter().append("Served at: ").append(req.getContextPath());
    }
}
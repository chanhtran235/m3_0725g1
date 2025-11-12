package org.example.demo_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SumServerlet", value = {"/sum","/tinh-tong"})
public class SumServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy dữ liệu
        int num1 = Integer.parseInt(req.getParameter("n1"));
        int num2 = Integer.parseInt(req.getParameter("n2"));
        int sum = num2+num1;
        req.setAttribute("num1",num1);
        req.setAttribute("num2",num2);
        req.setAttribute("sum",sum);
        req.getRequestDispatcher("/form.jsp").forward(req,resp);

    }
}

package org.example.demo_transaction_bank.controller;

import org.example.demo_transaction_bank.model.AccountBank;
import org.example.demo_transaction_bank.service.AccountBankService;
import org.example.demo_transaction_bank.service.IAccountBankService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {
    private IAccountBankService accountBankService = new AccountBankService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password= req.getParameter("password");
        AccountBank accountBank = accountBankService.findByUsernameAndPassword(username,password);
        if (accountBank!=null){
            HttpSession session = req.getSession();
            session.setAttribute("accountBank",accountBank);
            req.setAttribute("loginSuccess",true);
            req.getRequestDispatcher("home.jsp").forward(req,resp);
        }else {
            req.setAttribute("loginSuccess",false);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }
}

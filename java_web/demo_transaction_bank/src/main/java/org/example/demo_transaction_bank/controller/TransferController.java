package org.example.demo_transaction_bank.controller;

import org.example.demo_transaction_bank.model.AccountBank;
import org.example.demo_transaction_bank.model.TransferInfo;
import org.example.demo_transaction_bank.service.AccountBankService;
import org.example.demo_transaction_bank.service.IAccountBankService;
import org.example.demo_transaction_bank.service.ITransferService;
import org.example.demo_transaction_bank.service.TransferService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;


@WebServlet(name = "transferController", value = "/transfer")
public class TransferController extends HttpServlet {
    private ITransferService transferService = new TransferService();
    private IAccountBankService accountBankService = new AccountBankService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("transfer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long accountTarget = Long.parseLong(req.getParameter("accountTarget"));
        long accountSource = Long.parseLong(req.getParameter("accountSource"));
        double moneyTransfer = Double.parseDouble(req.getParameter("moneyTransfer"));
        String content = req.getParameter("content");
        LocalTime time = LocalTime.from(LocalDateTime.now());
        TransferInfo transferInfo = new TransferInfo(accountSource, accountTarget, time, moneyTransfer, content);
        String message = transferService.transfer(transferInfo);

        // chuyển khoản xong cần update lại thông tin tiền trong session
        HttpSession session = req.getSession();
        AccountBank accountBankOld = (AccountBank) session.getAttribute("accountBank");
        AccountBank accountBankUpdate = accountBankService.findByUsernameAndPassword(accountBankOld.getUsername(), accountBankOld.getPassword());
        session.setAttribute("accountBank", accountBankUpdate);
        req.setAttribute("message", message);
        req.getRequestDispatcher("transfer.jsp").forward(req, resp);
    }
}

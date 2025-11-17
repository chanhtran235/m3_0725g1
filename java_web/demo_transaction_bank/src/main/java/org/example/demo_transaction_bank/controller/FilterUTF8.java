package org.example.demo_transaction_bank.controller;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter(filterName = "FilterUTF-8", value = "/*")
public class FilterUTF8 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        Object account = (session != null) ? session.getAttribute("accountBank") : null;

        String uri = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath();

        boolean isAllowedWithoutLogin = uri.equals(contextPath + "/login") ||
                uri.equals(contextPath + "/login.jsp") ||
                uri.equals(contextPath + "/home") ||
                uri.equals(contextPath + "/home.jsp") ||
                uri.contains("/css/") ||
                uri.contains("/js/") ||
                uri.contains("/img/");

        if (account == null && !isAllowedWithoutLogin) {
            httpResponse.sendRedirect(contextPath + "/login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }

}

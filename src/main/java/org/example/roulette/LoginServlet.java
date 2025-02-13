package org.example.roulette;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        double balance = Double.parseDouble(request.getParameter("balance"));

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("balance", balance);
        session.setMaxInactiveInterval(30 * 60); // 30 Minuten Session

        response.sendRedirect("welcome.jsp");
    }
}
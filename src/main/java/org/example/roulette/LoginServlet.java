package org.example.roulette;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
@MultipartConfig
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        double balance = Double.parseDouble(request.getParameter("balance"));
        Part filePart = request.getPart("file");

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("balance", balance);

        response.sendRedirect("welcome.jsp");
    }
}
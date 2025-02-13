package org.example.roulette;

import java.io.IOException;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userNumber = Integer.parseInt(request.getParameter("number"));
        double betAmount = Double.parseDouble(request.getParameter("bet"));
        Double balance = (Double) session.getAttribute("balance");

        if (balance < betAmount) {
            response.sendRedirect("game.jsp?error=Insufficient Funds");
            return;
        }

        Random random = new Random();
        int rouletteNumber = random.nextInt(33);

        String resultMessage;
        if (userNumber == rouletteNumber) {
            double winnings = betAmount * 10;
            balance += winnings;
            resultMessage = "Gewonnen! Die Zahl war " + rouletteNumber + ". Du hast " + winnings + "CHF gewonnen!";
        } else {
            balance -= betAmount;
            resultMessage = "Verloren! Die Zahl war " + rouletteNumber + ". Du hast " + betAmount + "CHF verloren.";
        }

        session.setAttribute("balance", balance);
        session.setAttribute("gameResult", resultMessage);

        response.sendRedirect("game.jsp");
    }
}
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Roulette</title>
</head>
<body>
<%
    HttpSession currentSession = request.getSession(false);
    if (currentSession == null || currentSession.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String username = (String) currentSession.getAttribute("username");
    Double balance = (Double) currentSession.getAttribute("balance");
%>
<h1>Roulette Spiel</h1>
<p>Willkommen, <%= username %>!</p>
<p>Dein Guthaben: $<%= balance %></p>

<form action="GameServlet" method="post">
    Zahl (0-32) eingeben: <input type="number" name="number" min="0" max="32" required><br>
    Einsatz: <input type="number" name="bet" required step="0.01"><br>
    <input type="submit" value="Play">
</form>

<form action="welcome.jsp">
    <input type="submit" value="Zurück">
</form>

</body>
</html>
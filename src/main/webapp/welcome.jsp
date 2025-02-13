<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Willkommen</title>
</head>
<body>
<%
  String username = (String) session.getAttribute("username");
  Double balance = (Double) session.getAttribute("balance");
  if (username == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>
<h1>Willkommen zu Roulette, <%= username %>!</h1>
<p>Dein Guthaben: $<%= balance %></p>

<form action="game.jsp">
  <input type="submit" value="Play Roulette">
</form>
<form action="login.jsp">
  <input type="submit" value="Logout" onclick="<% session.invalidate(); %>">
</form>

</body>
</html>
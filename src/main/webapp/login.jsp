<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post" enctype="multipart/form-data">
  Benutzername: <input type="text" name="username" required><br>
  Guthaben: <input type="number" name="balance" required step="0.01"><br>
  <input type="submit" value="Login">
</form>
</body>
</html>
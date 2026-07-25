<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 21-07-2026
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">

    <h2>User Login</h2>

    <form action="LoginServlet" method="post">

        <label>Username</label><br>
        <input type="text" name="username" required><br><br>

        <label>Password</label><br>
        <input type="password" name="password" required><br><br>

        <input type="submit" value="Login">

    </form>

    <br>

    <a href="register.jsp">New User? Register Here</a>

</div>

</body>
</html>
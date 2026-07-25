<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 21-07-2026
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>User Registration</h2>

<form action="RegisterServlet" method="post">

    Full Name:<br>
    <input type="text" name="fullname"><br><br>

    Username:<br>
    <input type="text" name="username"><br><br>

    Email:<br>
    <input type="email" name="email"><br><br>

    Password:<br>
    <input type="password" name="password"><br><br>

    Mobile Number:<br>
    <input type="text" name="mobile"><br><br>

    <input type="submit" value="Register">

</form>

<br>

<a href="login.jsp">Already have an account? Login</a>

</body>
</html>
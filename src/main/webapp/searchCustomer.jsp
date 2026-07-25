<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 24-07-2026
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Search Customer</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

<h2>Search Customer</h2>

<form action="SearchCustomerServlet" method="post">

    Account Number:
    <input type="text" name="account" required>
    <br><br>

    <input type="submit" value="Search">

</form>

<br>
<a href="AdminDashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>

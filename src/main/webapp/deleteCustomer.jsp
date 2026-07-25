<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 22-07-2026
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Delete Customer</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

<h2>Delete Customer</h2>

<form action="DeleteCustomerServlet" method="post">

    Account Number:<br>
    <input type="text" name="account"><br><br>

    <input type="submit" value="Delete Customer">

</form>

<br>
<a href="AdminDashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>
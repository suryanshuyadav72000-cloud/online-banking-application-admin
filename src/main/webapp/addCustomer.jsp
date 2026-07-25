<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 22-07-2026
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Customer</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

<h2>Add New Customer</h2>

<form action="AddCustomerServlet" method="post">

    Customer Name:<br>
    <input type="text" name="name"><br><br>

    Account Number:<br>
    <input type="text" name="account"><br><br>

    Mobile Number:<br>
    <input type="text" name="mobile"><br><br>

    Balance:<br>
    <input type="number" name="balance"><br><br>

    <input type="submit" value="Add Customer">

</form>
</div>

</body>
</html>

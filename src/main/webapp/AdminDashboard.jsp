<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 21-07-2026
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">

    <h2>Admin Dashboard</h2>

    <p align="center">Welcome Admin</p>

    <hr>

    <a href="index.jsp">Home</a>
    <br><br>

    <a href="addCustomer.jsp">Add Customer</a>
    <br><br>

    <a href="ViewCustomerServlet">View Customers</a>
    <br><br>

    <a href="updateCustomer.jsp">Update Customer</a>
    <br><br>

    <a href="deleteCustomer.jsp">Delete Customer</a>
    <br><br>

    <a href="searchCustomer.jsp">Search Customer</a>
    <br><br>

    <a href="deposit.jsp">Deposit Money</a>
    <br><br>

    <a href="withdraw.jsp">Withdraw Money</a>
    <br><br>

    <a href="balance.jsp">Check Balance</a>
    <br><br>

    <input type="button" value="Logout"
           onclick="window.location.href='LogoutServlet'">

</div>

</body>
</html>
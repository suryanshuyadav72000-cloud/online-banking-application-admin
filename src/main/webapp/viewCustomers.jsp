<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 22-07-2026
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bank.Customer" %>

<html>
<head>
    <title>View Customers</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<div class="container">

<h2>Customer List</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Account</th>
        <th>Mobile</th>
        <th>Balance</th>
    </tr>

    <%
        ArrayList<Customer> customerList =
                (ArrayList<Customer>) request.getAttribute("customerList");

        if(customerList != null) {
            for(Customer c : customerList) {
    %>

    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getName() %></td>
        <td><%= c.getAccount() %></td>
        <td><%= c.getMobile() %></td>
        <td><%= c.getBalance() %></td>
    </tr>

    <%
            }
        }
    %>

</table>
</div>

</body>
</html>
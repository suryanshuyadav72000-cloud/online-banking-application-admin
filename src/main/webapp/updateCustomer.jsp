<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 24-07-2026
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Customer</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

<h2>Update Customer</h2>

<form action="UpdateCustomerServlet" method="post">

    Account Number:<br>
    <input type="text" name="account" required><br><br>

    New Name:<br>
    <input type="text" name="name" required><br><br>

    New Mobile:<br>
    <input type="text" name="mobile" required><br><br>

    New Balance:<br>
    <input type="number" step="0.01" name="balance" required><br><br>

    <input type="submit" value="Update Customer">

</form>

<br>
<a href="AdminDashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>
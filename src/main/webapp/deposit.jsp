<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 24-07-2026
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Deposit Money</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

<h2>Deposit Money</h2>

<form action="DepositServlet" method="post">

    Account Number:<br>
    <input type="text" name="account" required><br><br>

    Deposit Amount:<br>
    <input type="number" name="amount" step="0.01" required><br><br>

    <input type="submit" value="Deposit">

</form>

<br>
<a href="AdminDashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>
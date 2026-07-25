<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 24-07-2026
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Check Balance</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

<h2>Check Balance</h2>

<form action="BalanceServlet" method="post">

    Account Number:<br>
    <input type="text" name="account" required><br><br>

    <input type="submit" value="Check Balance">

</form>

<br>
<a href="AdminDashboard.jsp">Back to Dashboard</a>
</div>

</body>
</html>

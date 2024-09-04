<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/admin-welcome.css">
</head>
<body>
	<h1>
		Welcome Admin,
	</h1>
	<div class="info" align="right">
		<label class="hlabel">INFO</label><br><br>
        <label>Total Number of Books : ${totalBooks}</label><br><br>
        <label>Total Number of Members : ${totalMembers}</label>
    </div>
	<div class="center">
        <img class="admin" src="images/lib.jpg">
        <h2 class="adm">ADMIN ZONE</h2>
    </div>
</body>
</html>
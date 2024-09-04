<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Details</title>
<link rel="stylesheet" href="css/admin-books.css">
</head>
<body>
	<div class="services-container">
		<h1 class="services">ISSUE AND RETURN DETAILS</h1>
	</div>
	<table border="1">
		<tr>
			<th>SERIAL NO.</th>
			<th>ISSUE ID</th>
			<th>BOOK TITLE</th>			
			<th>ISSUED TO</th>
			<th>ISSUED ON</th>
			<th>DUE DATE</th>
			<th>RETURN DATE</th>
			<th>FINE</th>
		</tr>

        <c:forEach var="issue" items="${issueDetails}" varStatus="status">
            <tr>
            	<td>${status.index + 1}</td>
                <td>${issue[0]}</td>
                <td>${issue[1]}</td>
                <td>${issue[2]}</td>
                <td>${issue[3]}</td>
                <td>${issue[4]}</td>
                <td>${issue[5]}</td>
                <td>${issue[6]}</td>
            </tr>
        </c:forEach>	
     </table>
</body>
</html>
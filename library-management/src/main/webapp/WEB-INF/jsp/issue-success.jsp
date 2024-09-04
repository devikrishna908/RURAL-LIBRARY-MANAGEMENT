<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Success</title>
<link rel="stylesheet" href="css/success-style.css">
<script type="text/javascript">
	function cancelAction(){
		//		window.history.back();
		window.location.href = document.referrer;
	}
</script>
</head>
<body>
 <div class="container">
	<form action="/" class="info">
		<h2>BOOK ISSUED SUCCESSFULLY</h2><br>
	    <label>Book Title : <c:out value="${bookTitle}" /></label><br><br>
        <label>Member Name : <c:out value="${memberName}" /></label><br><br>
        <label>Issue Date : <c:out value="${issueDate}" /></label><br><br>
        <label>Due Date : <c:out value="${dueDate}" /></label><br>
	   	<input type="button" value="CLOSE" class="close" onclick="cancelAction()"> <br>
	</form> 
	</div>   
</body>
</html>
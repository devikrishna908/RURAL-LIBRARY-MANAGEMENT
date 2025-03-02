<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book</title>
<link rel="stylesheet" href="css/return-style.css">
<script src="js/issue-book.js" type="text/javascript"></script>

</head>
<body>
 <div class="container">
	<form action="/return" class="info">
		<h2>BOOK RETURN DETAILS</h2><br>
		<input type="hidden" name="issueId" value="${issueId}" />
        <label>Title of The Book</label><input type="text" name="title" value="${bookTitle}" readonly /><br><br>
        <label>Name of Member</label><input type="text" name="member" value="${memberName}" readonly /><br><br>
        <label>Book Issued Date</label><input type="text" name="Issue" value="${issueDate}" readonly /><br><br>
        <label>Due Date of Return</label><input type="text" name="dueDate" value="${dueDate}" readonly /><br><br>
        <label>Return Date</label><input type="text" name="returnDate" value="${returnDate}" readonly /><br><br>
    	<label>Fine Amount</label><input type="text" name="fine" value="${fine}" readonly /><br>
	    
        <div class="input-button">
             <input type="submit" value="RETURN" class="insert"> 
             <input type="button" value="CANCEL" class="cancel" onclick="cancel()"> <br>
        </div>
        
	</form> 
	</div>   

</body>
</html>
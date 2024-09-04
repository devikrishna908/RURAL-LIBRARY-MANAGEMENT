<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ISSUE A BOOK</title>
<link rel="stylesheet" href="css/issue-style.css">
<script src="js/issue-book.js" type="text/javascript"></script>
</head>
<body onload="cancelAction()">
	<div class="container">
		<h2>ISSUE BOOK</h2>
		<div class="form-container">
            <form name="create" method="post" action="/issue-book" onsubmit="return validateForm()">

	    	    <label for="bookId">ENTER BOOK ID</label>
    	    	<input type="text" id="bookId" name="bookId"><br>
        		
		        <label for="mem_regno">ENTER MEMBER REGISTRATION NUMBER</label>
    		    <input type="text" id="mem_regno" name="mem_regno"><br>

    		    <input type="button" value="VIEW DETAILS" class="view" onclick="viewAction()"><br>
    		    
		        <label for="title">BOOK TITLE</label>
    		    <input type="text" id="title" name="title" readonly><br>
		        <label for="member">ISSUED TO</label>
    		    <input type="text" id="member" name="member" readonly><br>
		        <label for="issueDate">ISSUED DATE</label>
    		    <input type="text" id="issueDate" name="issueDate" readonly><br>
		        <label for="dueDate">DUE DATE</label>
    		    <input type="text" id="dueDate" name="dueDate"  readonly><br>

				<div class="input-button">
					<input type="submit" value="ISSUE" class="issue"> 
					<input type="button" value="CANCEL" class="cancel" onclick="cancelAction()"> <br>
				</div>
			</form>
		</div>

	</div>

</body>
</html>
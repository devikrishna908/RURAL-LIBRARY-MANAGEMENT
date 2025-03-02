<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Member</title>
<link rel="stylesheet" href="css/member-style.css">
<script src="js/add-member.js" type="text/javascript"></script>

</head>
<body>
	<div class="container">
		<h2>ADD NEW MEMBER</h2>
		<div class="form-container">
			<form name="create" method="post" action="/save-member" onsubmit="return validateForm()">

	    	    <label for="name">ENTER MEMBER NAME</label>
    	    	<input type="text" id="name" name="name"><br>
        
		        <label for="address">ENTER ADDRESS</label>
				<textarea name="address" id="address"></textarea>
		
		        <label for="phone">ENTER PHONE NUMBER</label>
    		    <input type="text" id="phone" name="phone"><br>

		        <label for="email">ENTER EMAIL ID</label>
    		    <input type="text" id="email" name="email"><br>
				
				<div class="input-button">
					<input type="submit" value="SAVE" class="insert"> 
					<input type="button" value="CANCEL" class="cancel" onclick="cancelAction()"> <br>
				</div>
			</form>
		</div>

	</div>

</body>
</html>
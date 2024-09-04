<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT MEMBERs</title>
<link rel="stylesheet" href="css/member-style.css">
<script src="js/add-member.js" type="text/javascript"></script>

</head>
<body>
	<div class="container">
		<h2>UPDATE MEMBER DETAILS</h2>
		<div class="form-container">
            <form name="create" method="post" action="/update-member/${member.reg_no}" onsubmit="return validateForm()">

	    	    <label for="name">MEMBER NAME</label>
    	    	<input type="text" id="name" name="name" value="${member.name}"><br>
        
		        <label for="address">ADDRESS</label>
				<textarea name="address" id="address">${member.address}</textarea>
		
		        <label for="phone">PHONE NUMBER</label>
    		    <input type="text" id="phone" name="phone" value="${member.phone}"><br>

		        <label for="email">EMAIL ID</label>
    		    <input type="text" id="email" name="email" value="${member.email}"><br>

		        <label for="reg-date">MEMBERSHIP TAKEN ON</label>
    		    <input type="text" id="membership_taken_on" name="membership_taken_on" value="${member.membership_taken_on}" readonly><br>
		        <label for="due-date">MEMBERSHIP DUE DATE</label>
    		    <input type="text" id="membership_due_on" name="membership_due_on" value="${member.membership_due_on}" readonly>

    		    <input type="button" value="RENEW MEMBERSHIP" class="renew" onclick="renewAction()"><br>
    		    
		        <label for="status">STATUS</label>
    		    <input type="text" id="status" name="status" value="${member.status}" readonly><br>

				<div class="input-button">
					<input type="submit" value="UPDATE" class="insert"> 
					<input type="button" value="CANCEL" class="cancel" onclick="cancelAction()"> <br>
				</div>
			</form>
		</div>

	</div>

</body>
</html>
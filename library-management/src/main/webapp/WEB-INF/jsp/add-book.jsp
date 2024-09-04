<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link rel="stylesheet" href="css/new-book.css">
<script src="js/add-book.js" type="text/javascript"></script>

</head>
<body>
	<div class="container">
		<h2>ADD NEW BOOK DETAILS</h2>
		<div class="form-container">
			<form name="create" method="post" action="/save-book" onsubmit="return validateForm()">

	    	    <label for="bookTitle">ENTER BOOK TITLE</label>
    	    	<input type="text" id="bookTitle" name="bookTitle"><br>
        
		        <label for="author">ENTER AUTHOR NAME</label>
    		    <input type="text" id="author" name="author"><br>
		
				<label for="category">CHOOSE CATEGORY</label> 
				<select id="category" name="category">
					<option value="nil">Select Category</option>
					<option value="NOVEL">NOVEL</option>
					<option value="ARTICLES">ARTICLES</option>
					<option value="BIOGRAPHY">BIOGRAPHY</option>
					<option value="SHORT STORIES">SHORT STORIES</option>
					<option value="TRAVELOGUE">TRAVELOGUE</option>
					<option value="CLASSICS">CLASSICS</option>
					<option value="COMICS">COMICS</option>
					<option value="EDUCATION AND STUDY AID">EDUCATION AND STUDY AID</option>
					<option value="HEALTH AND FITNESS">HEALTH AND FITNESS</option>
					<option value="DRAMA">DRAMA</option>
					<option value="SCIENCE FICTION">SCIENCE FICTION</option>
					<option value="NON FICTION">NON FICTION</option>
					<option value="CHILDREN'S LITERATURE">CHILDREN'S LITERATURE</option>
					<option value="FANTASY">FANTASY</option>
					<option value="HISTORY">HISTORY</option>
					<option value="SCIENCE">SCIENCE</option>					
				</select> 

				<label for="language">CHOOSE LANGUAGE</label> 
				<select id="language" name="language">
					<option value="nil">Select Language</option>
					<option value="ENGLISH">ENGLISH</option>
					<option value="MALAYALAM">MALAYALAM</option>
					<option value="HINDI">HINDI</option>
				</select> 

		        <label for="publication">ENTER PUBLICATION</label>
    		    <input type="text" id="publication" name="publication"><br>

		        <label for="price">ENTER BOOK PRICE</label>
    		    <input type="text" id="price" name="price"><br>

		        <label for="total">ENTER TOTAL NUMBER OF COPIES</label>
    		    <input type="text" id="total" name="totalCopies" ><br>
				
				<div class="input-button">
					<input type="submit" value="SAVE DETAILS" class="insert"> 
					<input type="button" value="CANCEL" class="cancel" onclick="cancelAction()"> <br>
				</div>
			</form>
		</div>

	</div>

</body>
</html>
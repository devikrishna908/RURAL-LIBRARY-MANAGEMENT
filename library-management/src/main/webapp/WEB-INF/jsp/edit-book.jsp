<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<link rel="stylesheet" href="css/new-book.css">
<script src="js/add-book.js" type="text/javascript"></script>
</head>
<body>
    <div class="container">
        <h2>UPDATE BOOK DETAILS</h2>
        <div class="form-container">
            <form name="create" method="post" action="/update/${book.book_id}" onsubmit="return validateForm()">

                <label for="bookTitle">BOOK TITLE</label>
                <input type="text" id="bookTitle" name="bookTitle" value="${book.bookTitle}"><br>
        
                <label for="author">AUTHOR NAME</label>
                <input type="text" id="author" name="author" value="${book.author}"><br>
        
                <label for="category">CATEGORY</label> 
                <select id="category" name="category">
                    <option value="nil">Select Category</option>
                    <option value="NOVEL" ${book.category == 'NOVEL' ? 'selected' : ''}>NOVEL</option>
                    <option value="ARTICLES" ${book.category == 'ARTICLES' ? 'selected' : ''}>ARTICLES</option>
                    <option value="BIOGRAPHY" ${book.category == 'BIOGRAPHY' ? 'selected' : ''}>BIOGRAPHY</option>
                    <option value="SHORT STORIES" ${book.category == 'SHORT STORIES' ? 'selected' : ''}>SHORT STORIES</option>
                    <option value="TRAVELOGUE" ${book.category == 'TRAVELOGUE' ? 'selected' : ''}>TRAVELOGUE</option>
                    <option value="CLASSICS" ${book.category == 'CLASSICS' ? 'selected' : ''}>CLASSICS</option>
                    <option value="COMICS" ${book.category == 'COMICS' ? 'selected' : ''}>COMICS</option>
                    <option value="EDUCATION AND STUDY AID" ${book.category == 'EDUCATION AND STUDY AID' ? 'selected' : ''}>EDUCATION AND STUDY AID</option>
                    <option value="HEALTH AND FITNESS" ${book.category == 'HEALTH AND FITNESS' ? 'selected' : ''}>HEALTH AND FITNESS</option>
                    <option value="DRAMA" ${book.category == 'DRAMA' ? 'selected' : ''}>DRAMA</option>
                    <option value="SCIENCE FICTION" ${book.category == 'SCIENCE FICTION' ? 'selected' : ''}>SCIENCE FICTION</option>
                    <option value="NON FICTION" ${book.category == 'NON FICTION' ? 'selected' : ''}>NON FICTION</option>
                    <option value="CHILDREN'S LITERATURE" ${book.category == 'CHILDREN\'S LITERATURE' ? 'selected' : ''}>CHILDREN'S LITERATURE</option>
                    <option value="FANTASY" ${book.category == 'FANTASY' ? 'selected' : ''}>FANTASY</option>
                    <option value="HISTORY" ${book.category == 'HISTORY' ? 'selected' : ''}>HISTORY</option>
                    <option value="SCIENCE" ${book.category == 'SCIENCE' ? 'selected' : ''}>SCIENCE</option>                    
                </select> 

                <label for="language">LANGUAGE</label> 
                <select id="language" name="language">
                    <option value="nil">Select Language</option>
                    <option value="ENGLISH" ${book.language == 'ENGLISH' ? 'selected' : ''}>ENGLISH</option>
                    <option value="MALAYALAM" ${book.language == 'MALAYALAM' ? 'selected' : ''}>MALAYALAM</option>
                    <option value="HINDI" ${book.language == 'HINDI' ? 'selected' : ''}>HINDI</option>
                </select> 

                <label for="publication">PUBLICATION</label>
                <input type="text" id="publication" name="publication" value="${book.publication}"><br>

                <label for="price">BOOK PRICE</label>
                <input type="text" id="price" name="price" value="${book.price}"><br>

                <label for="total">TOTAL NUMBER OF COPIES</label>
                <input type="text" id="total" name="totalCopies" value="${book.totalCopies}"><br>
                
                <div class="input-button">
                    <input type="submit" value="UPDATE" class="insert"> 
                    <input type="button" value="CANCEL" class="cancel" onclick="cancelAction()"> <br>
                </div>
            </form>
        </div>
    </div>
</body>
</html>

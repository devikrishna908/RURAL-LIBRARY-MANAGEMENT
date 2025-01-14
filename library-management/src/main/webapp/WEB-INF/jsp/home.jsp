<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/admin-home-style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		// Load default content
		$("#mainContent").load("/welcome");

		// Handle menu item clicks
		$(".sidenav a").click(function() {
			// Remove active class from all links
			$(".sidenav a").removeClass("active");
			// Add active class to the clicked link
			$(this).addClass("active");

			var page = $(this).attr("href");
			if (page === "/") {
				window.location.href = page; // Redirect to the logout page
			} else {
				$("#mainContent").load(page); // Load content for other links
			}
			return false;
		});

		// Set initial active link
		$(".sidenav a[href='/welcome']").addClass("active");
	});
</script>
</head>
<body>
	<div class="navbar">
		<div class="logo">
			<h1>Grameena Vayanashala</h1>
		</div>
	</div>

	<div class="sidenav">
	
		<img class="sidenav-image" alt="logo" src="images/logo.png">	
		<a href="/welcome">ADMIN HOME</a> 
		<a href="/books">BOOK DETAILS</a>
		<a href="/members">MEMBER DETAILS</a> 
		<a href="/book-issue">BOOK ISSUE</a>
		<a href="/book-return">BOOK RETURN</a>
		<a href="/statistics">STATISTICS</a>
		<a href="/">LOGOUT</a>

	</div>

	<div class="main" id="mainContent"></div>
</body>
</html>
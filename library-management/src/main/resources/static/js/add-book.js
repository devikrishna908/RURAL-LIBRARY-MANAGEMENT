

    function validateForm() {
        var bookTitle = document.getElementById("bookTitle").value;
        var author = document.getElementById("author").value;
        var category = document.getElementById("category").value;
        var language = document.getElementById("language").value;
        var publication = document.getElementById("publication").value;
        var price = document.getElementById("price").value;
        var total = document.getElementById("total").value;

        // Check if all fields are filled and not just spaces
        if (bookTitle.trim() === "" || author.trim() === "" || category === "nil" || language === "nil" || publication.trim() === "" || price.trim() === "" || total.trim() === "") {
            alert("Please fill out all fields.");
            return false;
        }

        // Check if total copies is an integer
        if (!Number.isInteger(parseFloat(total)) || parseInt(total) <= 0) {
            alert("Total Copies must be a positive integer value.");
            return false;
        }

        // Check if price is a float or integer
        if (isNaN(price) || parseFloat(price) <= 0) {
            alert("Price must be a positive number.");
            return false;
        }

        return true;
        
    }
    

    function cancelAction() {
	    window.history.back();
    }
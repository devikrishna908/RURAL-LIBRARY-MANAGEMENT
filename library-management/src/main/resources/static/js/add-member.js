
    function validateForm() {
        var name = document.getElementById("name").value;
        var address = document.getElementById("address").value;
        var phone = document.getElementById("phone").value;
        var email = document.getElementById("email").value;

        // Check if all fields are filled and not just spaces
        if (name.trim() === "" || address.trim() === "" || phone === "nil" || email === "nil") {
            alert("Please fill out all fields.");
            return false;
        }

		if (!/^\d{10}$/.test(phone)) {
			alert("Please enter a valid 10-digit contact number.");
			return false;
		}

		if (!/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/.test(email)) {
			alert("Please enter a valid email address.");
			return false;
		}
        return true;
        
    }
    

    function cancelAction() {
	    window.history.back();
	//		window.location.href = '/home';
    }
    
     function renewAction() {

        const currentDate = new Date();
        const newDueDate = new Date(currentDate);
        newDueDate.setDate(currentDate.getDate() + 90);

        const formattedDueDate = newDueDate.toISOString().split('T')[0];

        document.getElementById('membership_due_on').value = formattedDueDate;
        document.getElementById('status').value = 'ACTIVE';
    }
    
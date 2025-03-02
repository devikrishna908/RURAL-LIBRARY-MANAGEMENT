function validateForm() {
    // Example validation logic
    var bookId = document.getElementById('bookId').value;
    var memRegno = document.getElementById('mem_regno').value;
    var bookTitle = document.getElementById('title').value;
    var memberName = document.getElementById('member').value;

    if (bookId === "" || memRegno === "" || bookTitle === "" || memberName === "") {
        alert("Details Missing, Cannot Issue The Book!");
        return false;
    }
    return true;
}

function cancel() {
	    window.history.back();
}

window.onload = function() {
            cancelAction(); 
        }
        
function cancelAction(){
	document.getElementById("bookId").value="";
    document.getElementById("mem_regno").value="";
	document.getElementById("title").value = "";
    document.getElementById("member").value = "";
    document.getElementById("issueDate").value = "";
    document.getElementById("dueDate").value = "";
	
}
function viewAction() {
   var bookId = document.getElementById("bookId").value;
   var memRegno = document.getElementById("mem_regno").value;
	
	document.getElementById("title").value = "";
    document.getElementById("member").value = "";
    document.getElementById("issueDate").value = "";
    document.getElementById("dueDate").value = "";
    
    if (bookId && memRegno) {
        $.ajax({
            url: "/view-details",
            type: "GET",
            data: { bookId: bookId, memRegno: memRegno },
            success: function(response) {
                if (response.success) {
                    document.getElementById("title").value = response.bookTitle;
                    document.getElementById("member").value = response.memberName;
                    document.getElementById("issueDate").value = response.issueDate;
                    document.getElementById("dueDate").value = response.dueDate;

                } else {
                    alert(response.message);
                }
            },
            error: function() {
                alert("Error fetching details");
            }
        });
        
    } else {
        alert("Please enter both Book ID and Member Registration Number.");
    }
}

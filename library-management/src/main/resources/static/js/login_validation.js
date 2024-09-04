
function validate() {
    var username = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    
    if (username.trim()=="") {
        alert("Please enter your email id.");
        return false;
    }
    
    if (!emailPattern.test(username)) {
        alert("Please enter a valid email address.");
        return false;
    }

    if (password.trim()=="") {
        alert("Please enter your password.");
        return false;
    }

    return true;
}

window.onload = function() {
    if (window.history && window.history.pushState) {
        window.history.pushState('forward', null, './#');
        window.onpopstate = function(event) {
            if (event.state === 'forward') {
                window.history.pushState('forward', null, './#');
            } else {
                window.location.href = 'index.html'; 
            }
        };
    }
};

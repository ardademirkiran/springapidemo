const cyrb53 = function(str, seed = 0) {
    let h1 = 0xdeadbeef ^ seed, h2 = 0x41c6ce57 ^ seed;
    for(let i = 0, ch; i < str.length; i++) {
      ch = str.charCodeAt(i);
      h1 = Math.imul(h1 ^ ch, 2654435761);
      h2 = Math.imul(h2 ^ ch, 1597334677);
    }
    h1  = Math.imul(h1 ^ (h1 >>> 16), 2246822507);
    h1 ^= Math.imul(h2 ^ (h2 >>> 13), 3266489909);
    h2  = Math.imul(h2 ^ (h2 >>> 16), 2246822507);
    h2 ^= Math.imul(h1 ^ (h1 >>> 13), 3266489909);
    return 4294967296 * (2097151 & h2) + (h1 >>> 0);
  };

document.getElementById('signupForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission behavior
    
    // Original password input from the user
    const originalPassword = document.getElementById('signupPassword').value;
    
    // Hash the password using cyrb53
    const hashedPassword = cyrb53(originalPassword).toString();

    const uname = document.getElementById('signupUname').value;
    const email = document.getElementById('email').value;
    
    // Create the request body using the hashed password
    var data = JSON.stringify({
        "uname": uname,
        "email": email,
        "password": hashedPassword // Use the hashed password here
    });

    // Create a new XMLHttpRequest
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://10.100.112.35:8080/usermanagement/signup", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    // Handle the request response
    xhr.onload = function () {
        if (xhr.status >= 200 && xhr.status < 300) {
            // Parse the JSON response
            var response = JSON.parse(xhr.responseText);
            if(response.signupResult.resultCode === "S1") {
                // Redirect on successful signup
                window.location.href = 'login.html';
            } else if(response.signupResult.resultCode === "S0") {
                alert("Username is already in use, new user is NOT created.");
            }
        } else {
            // Handle request error
            console.log('Something went wrong!', xhr.responseText);
        }
    };

    // Send the request with the hashed password
    xhr.send(data);
});


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

document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    // Collect the form data
    var uname = document.getElementById('uname').value;
    var password = cyrb53(document.getElementById('password').value).toString();

    // Create the request body
    var data = JSON.stringify({
        "uname": uname,
        "password": password
    });

    // Create a new XMLHttpRequest
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/usermanagement/login", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    // Handle the request response
    xhr.onload = function () {
        if (xhr.status >= 200 && xhr.status < 300) {
            // Parse the JSON response
            var response = JSON.parse(xhr.responseText);
            if(response.loginResult.resultCode === "L1") {
                window.location.href = 'mainpagetemplate/layout.html';
            } else if(response.loginResult.resultCode === "L0") {
                alert("Invalid username or password.");
            }
        } else {
            // Handle request error
            console.log('Something went wrong!', xhr.responseText);
        }
    };

    // Send the request
    xhr.send(data);
});
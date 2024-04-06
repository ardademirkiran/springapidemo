document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('signupPassword').addEventListener('input', function() {
        var password = this.value;
        var submitButton = document.getElementById('signupButton');
        
        // Define the regex pattern for the password
        var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;
        
        // Check if the password matches the pattern
        if(passwordPattern.test(password)) {
            // Password meets the regex constraints
            submitButton.disabled = false; // Enable the submit button
        } else {
            // Password does not meet the regex constraints
            submitButton.disabled = true; // Disable the submit button
        }
    });
});

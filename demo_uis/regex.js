document.getElementById('signupPassword').addEventListener('input', function() {
var uname = document.getElementById('signupPassword').value;
const cap = /(?=.*[A-Z])/; const letter = /(?=.*[a-z])/; const dig = /(?=.*\d)/;
const spec = /(?=.*[!@#*$%^&()_+=\-:'.<>?[\]{}|])/; const len = /.{8,20}/; const whtspc = /(?!.*\s)./;

let capT = cap.test(uname); let letterT = letter.test(uname); let digT = dig.test(uname);
let specT = spec.test(uname); let lenT = len.test(uname); let whtspcT = whtspc.test(uname);

let result = capT && letterT && digT && specT && lenT && whtspcT;

document.getElementById("signupButton").disabled = !result;
});
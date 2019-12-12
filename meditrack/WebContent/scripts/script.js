function validateLoginAdmin() {
	aidLogin = document.af1.aid.value;
	if (aidLogin.length > 10) {
		alert("Login Id cannot be greater than 10");
		return false;
	}

}
function validateRegAdmin() {
	fname = document.af2.fname.value;
	lname = document.af2.lname.value;
	uname = document.af2.uname.value
	password = document.af2.password.value;
	repassword = document.af2.repassword.value;
	var letters = /^[A-Za-z]+$/;
	if ((!fname.match(letters)) || (!lname.match(letters))) {
		alert("Name cannot contain numbers and special characters");
		return false;
	}
	if (fname.length > 30 || lname.length > 30) {
		alert("Name cannot contain more than 30 characters");
		return false;
	}
	if (uname.length > 20) {
		alert("username cannot contain more than 20 charecters");
		return false;
	}

	if (password.length > 20 || repassword.length > 20) {
		alert("Password cannot be greater than 20charaters!");
		return false;
	}
	if (password.localeComparere(password)) {
		alert("Different passwords entered");
		return false;
	}

}

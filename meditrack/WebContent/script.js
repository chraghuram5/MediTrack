function validateLoginAdmin() {
	aidLogin = document.af1.aid.value;
	if (aidLogin.length > 10) {
		alert("Login Id cannot be greater than 10");
		return false;
	}
}
function validateRegAdmin() {
	afname = document.af2.fname.value;
	alname = document.af2.lname.value;
	age = document.af2.age.value;
	password = document.af2.password.value;
	repassword = document.af2.repassword.value;
	var letters = /^[A-Za-z]+$/;
	if ((!afname.match(letters)) || (!alname.match(letters))) {
		alert("Name cannot contain numbers and special characters");
		return false;
	}
	if (afname.length > 50 || alname.length > 50) {
		alert("Name cannot contain more than 50 characters");
		return false;
	}

	if (age.length > 2) {
		alert("Please Enter valid Age!");
		return false;
	}

	if ((document.af2.num.value.length) != 10) {
		alert("Please enter valid contact number!");
		return false;
	}
	if (document.af2.password.value.length > 10) {
		alert("Password cannot be greater than 15 charaters!");
		return false;
	}
	if (password != repassword) {
		alert("Different passwords entered");
		return false;
	}

}

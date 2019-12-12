<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="script.js"></script>
<title>Registration</title>
<head>
<body>
	<div class="calendar">
		<div class="header">
			<span style="font-size: 30px; cursor: pointer"></span>
			<h1>
				<a href="Welcome" title="home"><img class="logo"
					src="images/pills.png" align="top"></a>
				MediTrack
			</h1>
		</div>

		<div class="split left">
			<div class="centered">
				<img src="images\images (1).jpg" alt="name"
					style="height: 300px; width: 500px">
			</div>
		</div>
		<%
			try {
				String status = (String) request.getAttribute("RegistrationStatus");
				if (status != null) {
		%>
		<p style="text-align: center">Error in registration</p>
		<%
			}
			} catch (Exception e) {
			}
		%>
		<div class="split right">
			<div class="centered" style="width: 70%">
				<form method="post" action="UserServlet?action=register" name="af2"
					onsubmit="return validateRegAdmin()">
					<table style="font-size: 20px;">
						<caption>
							<h2>
								Sign Up/ <a href="Login.jsp" style="color:white">Login</a>
							</h2>
						</caption>

						<tr>
							<td>First Name</td>
							<td><input type="text" name="fname" required></td>
						</tr>
						<tr>
							<p id="demo"></p>
							<td>Last Name</td>
							<td><input type="text" name="lname" required></td>
						</tr>
						<tr>
							<td>E-mail</td>
							<td><input type="email" name="email" required></td>
						</tr>
						<tr>
							<td>Gender</td>
							<td><input type="radio" value="Male" name="gender">Male
								<input type="radio" value="Female" name="gender">Female</td>
						</tr>
						<tr>
							<td>UserName</td>
							<td><input type="text" name="uname" required></td>
						</tr>
						<tr>
							<td>Contact Number</td>
							<td><input type="tel" name="mobile" pattern=[0-9]{10}
								required></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password" required></td>
						</tr>
						<tr>
							<td>Role</td>
							<td><input type="radio" value="User" name="role">User
								<input type="radio" value="CareTaker" name="role">CareTaker</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="SUBMIT"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>



		<div class="footer">Copyright &copy; 2019</div>
	</div>
</body>

</html>
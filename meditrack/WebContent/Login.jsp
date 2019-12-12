<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="script.js"></script>
<title>Login</title>
</head>
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

				<img src="images/images (1).jpg" alt="name"
					style="height: 300px; width: 500px">
			</div>
		</div>
		<%
		
			try {
				String status = (String) request.getAttribute("LoginStatus");
				if (status != null) {
		%>
		<p style="text-align: center">Incorrect credentials entered</p>
		<%
			}
			} catch (Exception e) {
			}
		%>

		<div class="split right">
			<div class="centered" style="width: 70%">
				<form method="post" action="UserServlet?action=authenticate" name="af1"
					onsubmit=" return validateLoginAdmin()">
					<table style="font-size: 20px;">
						<caption>
							<h1>Login</h1>
						</caption>
						<tr>
							<td>UserName</td>
							<td><input type="text" name="uname" required></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password" required></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="LOGIN"></td>
						</tr>
						<tr>
							<td>No account?</td>
							<td><a href="Registration.jsp" style="color:white">Sign Up</a></td>
						</tr>
					</table>
					<input type="hidden" name="actionName" value="login">
				</form>
			</div>
		</div>
		<div class="footer">Copyright &copy; 2019</div>
	</div>
</body>
</html>
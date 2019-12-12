<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.Calendar" import="model.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Home</title>
</head>
<body>
	<%
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int monthNumber = cal.get(Calendar.MONTH) + 1;
		User user = (User) session.getAttribute("User");
	%>
	<div class="home">
		<div class="header">
			<span style="font-size: 30px; cursor: pointer"></span>
			<h1>
				<img class="logo" src="images/pills.png" align="top"></img>
				MediTrack
				<div style="float: right; padding-right: 20px;">
					<a href="LogOut" title="logout"><img class="logo"
						src="images/logout (2).png" align="top"></a>
				</div>
			</h1>
			<h3>
				<marquee style="color: white">
					Welcome
					<%=user.getFname() + " " + user.getLname()%></marquee>
			</h3>
		</div>
		<div style="padding-top: 80px; align: center">
			<div class="row">
				<div class="column">
					<h2 style="text-align: center">Profile</h2>
					<div class="card">
						<a href="ProfileServlet" title="profile"><img
							src="images\user (2).png"></a><br>
					</div>
				</div>
				<div class="column">
					<h2 style="text-align: center">Events</h2>
					<div class="card">
						<a href="MedicationServlet?action=GET" title="events"><img
							src="images\clipboard.png"></a><br>
					</div>
				</div>
				<div class="column">
					<h2 style="text-align: center">Calendar</h2>
					<div class="card">
						<a
							href="CalendarServlet?month=present&monthNumber=<%=monthNumber%>&year=<%=year%>"
							title="calendar"><img src="images\calendar (1).png"></a><br>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">Copyright &copy; 2019</div>
	</div>
</body>
</html>
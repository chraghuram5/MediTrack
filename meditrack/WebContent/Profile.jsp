<%@ page language="java" import="java.util.Calendar"
	import="model.CustomCalendar" import="model.User"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Profile</title>
</head>
<body>
	<div class="home">
		<div class="header">
			<span style="font-size: 30px; cursor: pointer"></span>
			<h1>
				<a href="Home.jsp" title="home"><img class="logo"
					src="images/pills.png" align="top"></a> MediTrack
			</h1>
		</div>
		<%
			User user = (User) session.getAttribute("User");
			User user1 = (User) session.getAttribute("asUser");
		%>

		<table>
			<tr>
				<th>First Name</th>
				<td><%=user.getFname()%></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><%=user.getLname()%></td>
			</tr>
			<tr>
				<th>E-mail</th>
				<td><%=user.getEmail()%></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><%=user.getGender()%></td>
			</tr>
			<tr>
				<th>UserName</th>
				<td><%=user.getUname()%></td>
			</tr>
			<tr>
				<th>Contact Number</th>
				<td><%=user.getMobile()%></td>
			</tr>
			<tr>
				<th>UserId</th>
				<td><%=user.getUserId()%></td>
			</tr>
			<tr>
				<th>Role</th>
				<td><%=user.getRole()%></td>
			</tr>
			<tr>
				<th style="text-align: right">Associated User</th>
				<td></td>
			</tr>
		</table>
		<%if(user.getAssId()==0){ %>
		<form method="get" action="UserServlet?a=edit" name="af1"
			onsubmit=" return validateLoginAdmin()">
			<table>
				<tr>
					<th>Add/Edit AssociatedUser</th>
					<td><input type="number" name="asId"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="add"></input></td>
				</tr>
			</table>
			</form>
			<%}else{ %>
			<table>
				<tr>
					<th>Associated UserId</th>
					<td><%=user.getAssId() %></td>
				</tr>
			</table>
			<%} %>
		<div class="footer">Copyright &copy; 2019</div>
	</div>

</body>
</html>
<%@ page language="java" import="java.util.*" import="model.*"
	import="model.User" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
	<div class="medication">
		<div class="header">
			<span style="font-size: 30px; cursor: pointer"></span>
			<h1>
				<a href="Home.jsp" title="home"><img class="logo"
					src="images/pills.png" align="top"></a> MediTrack
			</h1>
		</div>

		<br>
		<%
			ArrayList<String> medicineList = (ArrayList<String>) session.getAttribute("medicineList");
			ArrayList<Medication> medicationList = (ArrayList<Medication>) session.getAttribute("medicationData");
			User user = (User) session.getAttribute("User");
		%>
			<table>
				<tr>
					<th>Medication</th>
					<th>Morning</th>
					<th>Afternoon</th>
					<th>Evening</th>
					<th>Night</th>
					<th></th>
				</tr>
				<%
					for (Medication medication : medicationList) {
				%>
				<tr>
					<td><%=medication.getMedicine()%>
					<td>
						<%
							if (medication.getMorning() != 0)
						%>&#128138;
					</td>
					<td>
						<%
							if (medication.getAfternoon() != 0)
						%>&#128138;
					</td>
					<td>
						<%
							if (medication.getEvening() != 0)
						%>&#128138;
					</td>
					<td>
						<%
							if (medication.getNight() != 0)
						%>&#128138;
					</td>
					<%
						if (user.getRole().equals("CareTaker")) {
					%>
					<td><a
						href="MedicationServlet?action=EDIT&medicationId=<%=medication.getMedicationId()%>">Edit</a>
					</td>
					<td><a
						href="MedicationServlet?action=DELETE&Id=<%=medication.getMedicationId()%>">Delete</a>
					</td>
				</tr>
				<%
					}
				%>
				<%
					}
				%>
			</table>
		<div align="center">
			<%
				if (user.getRole().equals("CareTaker")) {
			%>
			<a href="AddMedication.jsp">Add Event</a>
			<%
				}
			%>
		</div>
	</div>
	<div class="footer">Copyright &copy; 2019</div>
</body>
</html>
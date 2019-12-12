<%@ page language="java" import="java.util.*"
	import="model.CustomCalendar" import="model.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
			Medication medication = (Medication) request.getAttribute("medication");
		%>
		<%
			try {
				String status = (String) request.getAttribute("MedicationStatus");
				if (status != null) {
		%>
		<p style="text-align: center">Medication edited successfully</p>
		<%
			}
			} catch (Exception e) {
			}
		%>
			<form method="post"
				action="MedicationServlet?action=EDIT&Id=<%=medication.getMedicationId()%>">
				<table>
					<tr>
						<th style="text-align: right">Event</th>
						<td style="text-align: left"><select name="medication">
								<%
									for (String s : medicineList) {
								%>
								<option value=<%=s%>
									<%if (medication.getMedicine().equals(s)) {%> selected <%}%>><%=s%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<th style="text-align: right">Session</th>
						<td style="text-align: left"><input type="checkbox"
							name="morning" value=1 <%if (medication.getMorning() != 0) {%>
							checked <%}%>>Morning<br> <input type="hidden"
							name="morning" value="0"> <input type="checkbox"
							name="afternoon" value=1
							<%if (medication.getAfternoon() != 0) {%> checked <%}%>>Afternoon<br>
							<input type="hidden" name="afternoon" value="0"> <input
							type="checkbox" name="evening" value=1
							<%if (medication.getEvening() != 0) {%> checked <%}%>>Evening<br>
							<input type="hidden" name="evening" value="0"> <input
							type="checkbox" name="night" value=1
							<%if (medication.getNight() != 0) {%> checked <%}%>>Night<br></td>
						<input type="hidden" name="night" value="0">
					</tr>
					<tr>
						<th></th>
						<td style="text-align: left"><input type="submit" value="Edit">

							<a style="padding-left: 60px" href="MedicationServlet?action=GET"><img
								height=40px; width=40px; src="images\clipboard.png"></a></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="footer">Copyright &copy; 2019</div>
</body>
</html>
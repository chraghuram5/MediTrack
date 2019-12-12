<%@ page language="java" import="java.util.*"
	import="model.CustomCalendar" import="model.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="calendar">
		<%
			ArrayList<String> medicineList = (ArrayList<String>) session.getAttribute("medicineList");
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int monthNumber = cal.get(Calendar.MONTH) + 1;
			Reminder reminder = (Reminder) request.getAttribute("editReminder");
		%>
		<div class="header">
			<span style="font-size: 30px; cursor: pointer"></span>
			<h1>
				<a href="Home.jsp" title="home"><img class="logo"
					src="images/pills.png" align="top"></a> MediTrack
			</h1>
		</div>

		<br>
		<%
			try {
				String status = (String) request.getAttribute("ReminderStatus");
				String count = (String) session.getAttribute("Count");
				if (status.equals("deleted")) {
		%>
		<p style="text-align: center">Reminder deleted successfully</p>
		<%
			} else if (status != null) {
		%>
		<p style="text-align: center">Reminder Edited successfully</p>
		<%
			} else if (count.equals("Exceeded")) {
		%>
		<p style="text-align: center">Maximum reminders exceeded</p>
		<%
			}
			} catch (Exception e) {

			}
		%>
		<div>
			<table style="table-layout: auto">
				<form method="post"
					action="ReminderServlet?action=EDIT&Id=<%=reminder.getId()%>">
					<tr>
						<th style="text-align: right">Event</th>
						<td style="text-align: left"><select name="event">
								<%
									for (String s : medicineList) {
								%>
								<option value=<%=s%> <%if (reminder.getEvent().equals(s)) {%>
									selected <%}%>><%=s%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<th style="text-align: right">Date</th>
						<td style="text-align: left"><select name="day">
								<%
									for (int i = 1; i <= 31; i++) {
								%>
								<option value=<%=i%> <%if (reminder.getDay() == i) {%> selected
									<%}%>>
									<%
										if (i <= 9) {
									%>
									<%="0" + i%></option>
								<%
									} else {
								%>
								<%=i%></option>
								<%
									}
								%>
								<%
									}
								%>
						</select> <%="/"%> <select name="month">
								<%
									for (int i = 1; i <= 12; i++) {
								%>
								<option value=<%=i%> <%if (reminder.getMonth() == i) {%>
									selected <%}%>>
									<%
										if (i <= 9) {
									%>
									<%="0" + i%></option>
								<%
									} else {
								%>
								<%=i%></option>
								<%
									}
								%>
								<%
									}
								%>
						</select> <%="/"%> <select name="year">
								<%
									for (int i = 2019; i <= 2199; i++) {
								%>
								<option value=<%=i%> <%if (reminder.getYear() == i) {%> selected
									<%}%>><%=i%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<th style="text-align: right">Time</th>
						<td style="text-align: left"><select name="hours">
								<%
									for (int i = 9; i <= 21; i++) {
								%>
								<option value=<%=i%> <%if (reminder.getHours() == i) {%>
									selected <%}%>>
									<%
										if (i <= 9) {
									%>
									<%="0" + i%></option>
								<%
									} else {
								%>
								<%=i%></option>
								<%
									}
								%>
								<%
									}
								%>
						</select> <%=":"%> <select name="minutes">
								<%
									for (int i = 00; i <= 59; i++) {
								%>
								<option value=<%=i%> <%if (reminder.getMinutes() == i) {%>
									selected <%}%>>
									<%
										if (i <= 9) {
									%>
									<%="0" + i%></option>
								<%
									} else {
								%>
								<%=i%></option>
								<%
									}
								%>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<th style="text-align: right">Reminder</th>
						<td style="text-align: left"><input type="text"
							name="reminder">
					</tr>
					<tr>
						<th style="text-align: right">Repeat</th>
						<td style="text-align: left"><select name="repeat">
								<option value="Never">Never</option>
								<option value="Every Month">Every Month</option>
								<option value="Every Year">Every Year</option>
						</select></td>
					</tr>
					<tr>
						<th style="text-align: right">Type</th>
						<td style="text-align: left"><select name="type">
								<option value="sms">sms</option>
								<option value="IVR">IVR</option>
						</select></td>
					</tr>
					<tr>
						<th style="text-align: right">When to remind</th>
						<td style="text-align: left"><select name="when">
								<option value="15">before 15minutes</option>
								<option value="10">before 10 minutes</option>
								<option value="5">before 5 minutes</option>
						</select></td>
					</tr>
					<tr>
						<th></th>
						<td style="text-align: left"><input type="submit"
							value="Edit">
				</form>
				<button style="border-radius: 20px;"
					onclick="window.location.href = 'ReminderServlet?action=DELETE&reminderId=<%=reminder.getId()%>';">Delete</button>
				<button style="border-radius: 20px;"
					onclick="window.location.href = 'CalendarServlet?month=present&monthNumber=<%=monthNumber%>&year=<%=year%>';">Calendar</button>
				</tr>
			</table>
		</div>
		<div class="footer">Copyright &copy; 2019</div>
	</div>
</body>
</html>
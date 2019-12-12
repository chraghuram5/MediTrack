<%@ page language="java" import="java.util.*" import="model.*"
	import="java.util.List" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="calendarstyle.css">
<title>Calendar</title>
</head>
<body>
	<div class="calendar">
		<div class="header">
			<span style="font-size: 30px; cursor: pointer"></span>
			<h1>
				<a href="Home.jsp" title="home"><img class="logo"
					src="images/pills.png" align="top"></a> MediTrack
			</h1>
		</div>
		<%
			int year = (int) request.getAttribute("year");
			int month = (int) request.getAttribute("month");
			int d = CustomCalendar.day(month, 1, year);
			int j = 1;
			ArrayList<Reminder> list = (ArrayList<Reminder>) request.getAttribute("list");
			User user = (User) session.getAttribute("User");
		%>
		<h3 align="center" style="color: white">
			<a
				href="CalendarServlet?month=previous&monthNumber=<%=month%>&year=<%=year%>"
				class="previous">&laquo;</a><%=" " + CustomCalendar.months[month]%><%=" " + year%>
			<a
				href="CalendarServlet?month=next&monthNumber=<%=month%>&year=<%=year%>"
				class="next">&raquo;</a>
		</h3>
		<div style="margin-left: 10px; margin-right: 10px">
			<div class="card-group">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title" style="text-align: center">Sunday</h5>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title" style="text-align: center">Monday</h5>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title" style="text-align: center">Tuesday</h5>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title" style="text-align: center">Wednesday</h5>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title" style="text-align: center">Thursday</h5>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title" style="text-align: center">Friday</h5>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title" style="text-align: center">Saturday</h5>
					</div>
				</div>
			</div>
			<div class="card-group">
				<%
					for (int i = 0; i < d; i++) {
				%>
				<div class="card">
					<div class="card-body">
						<div class="card-title"></div>

					</div>
				</div>
				<%
					}
					for (int i = 1; i + d <= 7; i++) {
				%>

				<div class="card">
					<div class="card-body">
						<div class="card-title" style="font-size: 20px">
							<a title="Add Reminder"
								href="ReminderServlet?action=ADD&day1=<%=i%>&month1=<%=month%>&year1=<%=year%>"
								style="color: white"><%=i%></a>
						</div>
						<div class="card-text">
							<%
								for (Reminder reminder : list) {
										if (reminder.getDay() == i) {
							%>
							<%
								if (reminder.getHours() <= 9) {
							%>
							<%="0" + reminder.getHours() + ":"%>
							<%
								} else {
							%>
							<%=reminder.getHours() + ":"%>
							<%
								}
							%>
							<%
								if (reminder.getMinutes() <= 9) {
							%>
							<%="0" + reminder.getMinutes()%>
							<%
								} else {
							%>
							<%=reminder.getMinutes()%>
							<%
								}
							%>
							<%=" " + reminder.getEvent()%>
							<%=" " + reminder.getReminder()%>
							<%
								if (user.getRole().equals("CareTaker")) {
							%><a title="edit"
								href="ReminderServlet?action=EDIT&reminderId=<%=reminder.getId()%>">
								&#9997</a>
							<%
								}
							%>
							<br>
							<%
								}
									}
							%>
						</div>
					</div>
				</div>
				<%
					j++;
					}
				%>
			</div>
			<div class="card-group">
				<%
					int k = 1;
					for (int i = j; k <= 28; i++, k++) {
				%>
				<div class="card">
					<div class="card-body">
						<%
							if (i <= CustomCalendar.days[month]) {
						%>
						<div class="card-title" style="font-size: 20px">
							<a title="Add Reminder"
								href="ReminderServlet?action=ADD&day1=<%=i%>&month1=<%=month%>&year1=<%=year%>"
								style="color: white"><%=i%></a>
						</div>
						<%
							} else {
						%>
						<div class="card-title"></div>
						<%
							}
						%>
						<div class="card-text">
							<%
								for (Reminder reminder : list) {
										if (reminder.getDay() == i) {
							%>
							<%
								if (reminder.getHours() <= 9) {
							%>
							<%="0" + reminder.getHours() + ":"%>
							<%
								} else {
							%>
							<%=reminder.getHours() + ":"%>
							<%
								}
							%>
							<%
								if (reminder.getMinutes() <= 9) {
							%>
							<%="0" + reminder.getMinutes()%>
							<%
								} else {
							%>
							<%=reminder.getMinutes()%>
							<%
								}
							%>
							<%=" " + reminder.getEvent()%>
							<%=" " + reminder.getReminder()%>
							<%
								if (user.getRole().equals("CareTaker")) {
							%>
							<a title="edit" 
								href="ReminderServlet?action=EDIT&reminderId=<%=reminder.getId()%>">
								&#9997</a>
							<%
								}
							%>
							<br>
							<%
								}
									}
							%>
						</div>
					</div>
				</div>
				<%
					if ((k % 7 == 0)) {
				%>
			</div>
			<div class="card-group">
				<%
					}
				%>
				<%
					}
				%>
			</div>
		</div>
		<div class="footer" style="position: sticky">Copyright &copy;
			2019</div>
	</div>
</body>
</html>
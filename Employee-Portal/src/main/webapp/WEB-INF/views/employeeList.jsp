<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1 style="font color: 'green'">Employee Details</h1>
<body>
	<p style="color: green;">${message}</p>
	<form id="searchdata" action="searchEmployee" method="get">
		<table>
			<tr>
				<td>Search :</td>
				<td><input type="text" name="name" autocomplete="off"
					placeholder="Search Data" /></td>
				<td><input type="submit" value="Search" onClick="searchPage()"></td>
			</tr>
		</table>
	</form>
	<table style="width: 40%; border: 1px solid black;">
		<tr>
			<td>Name</td>
			<td>ProjectDetails</td>
			<td>EmailId</td>
			<td>PhoneNo</td>
		</tr>

		<c:forEach items="${employeeList}" var="emp">
			<tr>
				<td>${emp.name}</td>
				<td>${emp.projectDetails}</td>
				<td>${emp.emailId}</td>
				<td>${emp.phoneNo}</td>
				<td><a
					href="/portal/updateEmplyeeDetails?employeeId=${emp.employeeId}">Edit</a>
				</td>
				<td><a href="/portal/deleteEmployee/${emp.employeeId}">Delete</a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty employeeList}">
			<td style="color: red; " >Data not found</td>
		</c:if>
	</table>
</body>
</html>

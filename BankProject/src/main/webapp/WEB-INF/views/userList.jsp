<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1 style="font color: 'green'">User Details</h1>
<body>
	<c:if test="${userdata}">
	<a href="userForm"><h4>Add New User</h4></a>
	</c:if>
	
	<p style="color: green;">${message}</p>
	<table style="width: 40%; border: 1px solid black;">
		<tr>
			<td>UserName</td>
			<td>EmailId</td>
			<td>PhoneNo</td>
		</tr>
		<c:forEach items="${userList}" var="userlist">
			<tr>
				<td>${userlist.userName}</td>
				<td>${userlist.emailId}</td>
				<td>${userlist.phoneNo}</td>
				<td><a
					href="/project/editUserDetails?userId=${userlist.userId}">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

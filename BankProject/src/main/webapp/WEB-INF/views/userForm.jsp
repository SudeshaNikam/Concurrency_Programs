<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style>
.error {
	color: #ff5757 !important;
}
</style>
<body>
	<h1>Add Users</h1>
<body>
	<form:form action="saveUser" method="post" modelAttribute="user">
		<p style="color: red;">${message}</p>
		<table style="with: 80%">
			<c:if test="${empty userList}">
				<form:hidden path="userId"></form:hidden>
				<tr>
					<td>Name :</td>
					<td><form:input path="userName" autocomplete="off"
							placeholder="Enter the user name" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:input path="password" autocomplete="off"
							placeholder="Enter the password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="emailId" autocomplete="off"
							placeholder="Enter the emailId" /></td>
					<td><form:errors path="emailId" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Phone NO :</td>
					<td><form:input path="phoneNo" autocomplete="off"
							placeholder="Enter the phoneNo" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit"
						name="action" value="${btnValue}" /></td>
				</tr>
			</c:if>
		</table>
	</form:form>
</body>

<body>

	<form:form action="saveUser" method="post" modelAttribute="user">
		<table style="with: 80%">
			<c:if test="${not empty userList}">
				<c:forEach items="${userList}" var="use">
					<form:hidden path="userId"></form:hidden>
					<tr>
						<td>Name :</td>
						<td><form:input path="userName" value="${use.userName}"
								autocomplete="off" placeholder="Enter the user name" /></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><form:input path="password" value="${use.password}"
								autocomplete="off" placeholder="Enter the password" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><form:input path="emailId" value="${use.emailId}"
								autocomplete="off" placeholder="Enter the emailId" /></td>
					</tr>
					<tr>
						<td>Phone NO :</td>
						<td><form:input path="phoneNo" value="${use.phoneNo}"
								autocomplete="off" placeholder="Enter the phoneNo" /></td>
					</tr>

					<tr>
						<td colspan="8" align="center"><input type="submit"
							name="action" value="Save" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form:form>
</body>

</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>New /Edit Employee</h1>

	<%-- 		<P>The time on the server is ${serverTime}.</P>  --%>
<body>
	<form:form action="saveEmployee" method="post"
		modelAttribute="employee">
		<table style="with: 80%">
			<c:if test="${empty employeeList}">
				<form:hidden path="employeeId"></form:hidden>
				<tr>
					<td>Name :</td>
					<td><form:input path="name" value="${emp.name}"
							autocomplete="off" placeholder="Enter the name" /></td>
				</tr>
				<tr>
					<td>Project Details :</td>
					<td><form:input path="projectDetails"
							value="${emp.projectDetails}" autocomplete="off"
							placeholder="Enter the projectDetails" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="emailId" value="${emp.emailId}"
							autocomplete="off" placeholder="Enter the emailId" /></td>
				</tr>
				<tr>
					<td>Phone NO :</td>
					<td><form:input path="phoneNo" value="${emp.phoneNo}"
							autocomplete="off" placeholder="Enter the phoneNo" /></td>
				</tr>

				<tr>
					<td colspan="8" align="center"><input type="submit"
						name="action" value="${btnValue}" /></td>
				</tr>
			</c:if>
		</table>
	</form:form>
</body>
<body>
	<form:form action="saveEmployee" method="post"
		modelAttribute="employee">
		<table style="with: 80%">
			<c:if test="${not empty employeeList}">
				<c:forEach items="${employeeList}" var="emp">
					<form:hidden path="employeeId"></form:hidden>
					<tr>
						<td>Name :</td>
						<td><form:input path="name" value="${emp.name}"
								autocomplete="off" placeholder="Enter the name" /></td>
					</tr>
					<tr>
						<td>Project Details :</td>
						<td><form:input path="projectDetails"
								value="${emp.projectDetails}" autocomplete="off"
								placeholder="Enter the projectDetails" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><form:input path="emailId" value="${emp.emailId}"
								autocomplete="off" placeholder="Enter the emailId" /></td>
					</tr>
					<tr>
						<td>Phone NO :</td>
						<td><form:input path="phoneNo" value="${emp.phoneNo}"
								autocomplete="off" placeholder="Enter the phoneNo" /></td>
					</tr>

					<tr>
						<td colspan="8" align="center"><input type="submit"
							name="action" value="${btnValue}" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form:form>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<style>
.error {
	color: #ff5757 !important;
}
</style>
<body>
	<h1>Enter Account Information</h1>
<body>
<p style="color: red;">${message}</p>
	<form:form action="saveAccount/?userId=${userId}" method="post"
		modelAttribute="account">
		<table style="with: 80%">
			<form:hidden path="accountId"></form:hidden>
			<tr>
				<td>Account No :</td>
				<td><form:input path="accountNo" autocomplete="off"
						placeholder="Enter the accountNo" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Balance :</td>
				<td><form:input path="balance" autocomplete="off"
						placeholder="Enter the balance" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="8" align="center"><input type="submit"
					name="action" value="Add new account" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>

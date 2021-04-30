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
	<h1>Transfer Amount</h1>
<body>
<body>
	<form:form action="saveTransferAmount/?userId=${userId}" method="post"
		modelAttribute="transaction">
		<table style="with: 80%">
			<form:hidden path="userId"></form:hidden>
			<tr>
				<td>Your AccountNumber :</td>
				<td>
					<%-- <form:input path="fromAccountNumber" value=""
						autocomplete="off" placeholder="Enter the user name" />  --%> <form:select
						path="fromAccountNumber"
						cssClass="form-control chosen-select disablesearch"
						style="width: 100%;" id="idfromAccountNumber"
						data-validation="required">
						<form:options items="${accountList}" itemValue="accountNo"
							itemLabel="accountNo" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>ToAccountNumber :</td>
				<td><form:input path="toAccountNumber" value=""
						autocomplete="off" placeholder="Enter the AccountNumber" /></td>
				<td><form:errors path="toAccountNumber" cssClass="error" /></td>
			</tr>
			<tr>
				<td>amount :</td>
				<td><form:input path="amount" value="" autocomplete="off"
						placeholder="Enter the amount" /></td>
				<td><p style="color: red;">${message}</p></td>
			</tr>
			<tr>
				<td>description :</td>
				<td><form:input path="description" value="" autocomplete="off"
						placeholder="Enter the description" /></td>
			</tr>
			<tr>
				<td colspan="8" align="center"><input type="submit"
					name="action" value="Transfer Amount" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>

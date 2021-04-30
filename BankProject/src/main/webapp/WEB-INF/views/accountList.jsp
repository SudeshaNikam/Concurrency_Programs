<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<%@ include file="header.jsp" %> 
<body>
	<h1 style="font color: 'green'">Account Summary</h1>
<body>
	<%-- <a href="accountForm/${userId}"><h4>Add Account</h4></a> --%>
	<p style="color: green;">${message}</p>
	<table style="width: 40%; border: 1px solid black;">
		<tr>
			<td>AccountNo</td>
			<td>Balance</td>
			<td>Creation Date</td>
		</tr>

		<c:forEach items="${accountList}" var="acc">
			<tr>
				<td>${acc.accountNo}</td>
				<td>${acc.balance}</td>
				<td>${acc.openingDate}</td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>

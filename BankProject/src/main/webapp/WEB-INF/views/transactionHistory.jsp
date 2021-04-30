<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1 style="font color: 'green'">Transaction History</h1>
<body>
	<table style="width: 80%; border: 1px solid black;">
		<tr>
			<td>Account No.</td>
			<td>Beneficiary Account No.</td>
			<td>Amount</td>
			<td>Date</td>
			<td>Description</td>
		</tr>

		<c:forEach items="${transaction}" var="tran">
			<tr>
				<td>${tran.fromAccountNumber}</td>
				<td>${tran.toAccountNumber}</td>
				<td>${tran.amount}</td>
				<td>${tran.date}</td>
				<td>${tran.description}</td>
			</tr>
		</c:forEach>
		<c:if test="${empty transaction}">
			<td style="color: red;">Record Not Found</td>
		</c:if>
	</table>
</body>
</html>

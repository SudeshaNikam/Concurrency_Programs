<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>${message}</h2>
	<table style="with: 80%">
		<tr>
			<td>rideId</td>
			<td>userId</td>
			<td>routeId</td>
			<td>dateTime</td>
		</tr>

		<c:forEach items="${rideList}" var="ride">
			<tr>
				<td>${ride.rideId}</td>
				<td>${ride.userId}</td>
				<td>${ride.routeId}</td>
				<td>${ride.dateTime}</td>
			</tr>

		</c:forEach>
	</table>
</body>
<!-- <script>
if ( window.history.replaceState ) {
  window.history.replaceState( null, null, window.location.href );
}
</script> -->
</html>
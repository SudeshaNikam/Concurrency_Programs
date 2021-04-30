<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style>

</style>
<body>
	<h1></h1>
<body>
<body>

	<h3>Welcome to Online Banking Application</h3>
	<div class="form">
		<form action="login" modelAttribute="user" method="get">
			<h4>Banking Application Login</h4>
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" autocomplete="off" required=""
						name="userName" placeholder="Please enter your user name"></td>
					<td></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required=""
						autocomplete="off" placeholder="Your password"></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="8" align="center"><input type="submit"
						name="action" class="btn btn-primary" value="Sign in" /></td>

				</tr>
			</table>

			<a href="userList"><h4>Register for Online Banking</h4></a>
			<p style="color: red;">${message}</p>
		</form>
	</div>

</body>
</html>


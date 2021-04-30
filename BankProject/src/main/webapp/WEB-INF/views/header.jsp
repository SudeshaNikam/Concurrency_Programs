<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Online Banking Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-light" style="background-color: black;">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#" style="color: white">Online
				Banking Application</a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li class="home"><a href="" style="color: blue">Home</a></li>
				<li><a href="userListdata/${userId}" style="color: white">User
						Details</a></li>
				<li><a href="accountForm/${userId}" style="color: white">
						Create A New Account</a></li>
				<li><a href="trasactiondata/${userId}" style="color: white">Transaction
				</a></li>
				<li><a href="transactionHistory/?userId=${userId}"
					style="color: white">Transaction History</a></li>
			</ul>
		</div>
		<form class="navbar-form navbar-left ">

			<a href="loginOut" class="btn btn-default btn-md"><span
				class="glyphicon glyphicon-log-out"></span> Log out </a>

		</form>
	</div>
	</nav>
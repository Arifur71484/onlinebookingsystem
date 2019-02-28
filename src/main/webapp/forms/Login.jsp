<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>SignIn Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="./css/NewFile.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<!-- //web font -->
</head>
<body>
	<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>SignIn Form</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
			<p><font color="red">
			<%
			if (request.getAttribute("message") != null)
out.println(request.getAttribute("message"));
%>
</font>
</p>
				<form action="Login" method="post">
					<input class="text email" type="email" name="email" placeholder="Email" required="">
					<input class="text" type="password" name="password" placeholder="Password" required="">
					<p><a href="http://localhost:8080/SPM_project/PasswordRecovery.jsp">Forgot Password?</a></p>
					<div class="wthree-text">
						<label class="anim">
						</label>
						<div class="clear"> </div>
					</div>
					<input type="submit" value="LOGIN">
				</form>
				 
			</div>
		</div>
		<!-- copyright -->
		
		<!-- //copyright -->
		 
	</div>
	<!-- //main -->
</body>
</html>
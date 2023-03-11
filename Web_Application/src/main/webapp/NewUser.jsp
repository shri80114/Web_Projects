

<style>
body {
	background-color: slategrey;
}

h1 {
	text-align: center;
}

#id {
	padding-right: 20;
}
</style>
<html lang="en">


<body>
	<form method="post" action="NewReg.jsp">
		<h1>New user registration page</h1>
		<div class="lab">
			<label>First Name :</label> <input type="text" name="fname" size="10"
				required><br> <br> <label>Last Name :</label> <input
				type="text" name="lname" size="10" required><br> <input
				type="checkbox" name="male" value="male">Male <input type="checkbox"
				name="female" value="female"> Female <br>
			<br> <br> <label>Email-Id </label> <input type="text"
				name="email" size=25px; required><br> <br> <label>Mobile
				No : </label><input type="number" name="mobile" required><br> <br>
			<label>Address :</label> <input type="text" name="add" size="30"
				width="20"><br> <br> <label>User Name :</label> <input
				type="text" name="uname" required><br> <br> <label>Password
				:</label> <input type="password" name="pass"><br> <br> <input
				type="submit" value="SignUp"> <input type="reset"
				value="Clear">
		</div>
	</form>
</body>
</html>
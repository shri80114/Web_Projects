<html lang="en">
<style>
.ids {
	text-align: center;
	border-radius: 30px;
	background-color: tan;
}

form {
	border: 2px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 12%;
	margin: 1px 0;
	display: inline-block;
	border: 1px solid green;
	box-sizing: border-box;
}

</style>
<body class="ids">
	<h1>Let's get you into your account</h1>
	<div>
		<form method="post" action="NewPassword">
			<label>Username : </label> <input type="text" name="username" required><br>
			<br>
			 <label>New Password : </label>  
			<input type="password" name="password" required><br>
			<br>
			<label>Re-Enter Password : </label> 
			  <input type="password" name="pass" required><br>
			<br> <input type="submit"> <input type="reset">
		</form>
	</div>
</body>
</html>
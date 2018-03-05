<html>
<head>
<title>LoginPage</title>
</head>
<body><div align="center">
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form action="login" method="POST">
		<table border="0">
			<tr>
				
				<td>Name :</td>
				<td><input name="name" type="text" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input name="password" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
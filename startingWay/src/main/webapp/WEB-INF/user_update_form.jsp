<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Update Form</title>
</head>
<body>
<form action="UpdateUserServlet" method="POST">

<label for="password">Password</label>
<input type="password" name="password" />

<label for="email">Email</label>
<input type="email" name="email" />

<input type="hidden" name="id" value="${data.id}" />

<input type="submit" value="Modifier" />

</form>
</body>
</html>
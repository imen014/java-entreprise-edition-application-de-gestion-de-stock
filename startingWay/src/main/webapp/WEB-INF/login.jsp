<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Page</title>
</head>
<body>
<form action="LoginUserServlet" method="POST">

<label for="email">Email</label>
<input type="email" name="email" required>

<label for="password">Password</label>
<input type="password" name="password" required>

<label for="username">Username</label>
<input type="text" name="username" required>

<input type="submit" value="Valider">

</form>
</body>
</html>
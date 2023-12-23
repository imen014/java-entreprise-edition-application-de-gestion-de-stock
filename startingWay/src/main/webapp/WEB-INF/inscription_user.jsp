<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
</head>
<body>
<form method="POST" action="CreateAccountUserServlet">

<label for="username">Username  </label>
<input type="text" name="username" required>

<label for="username">Password </label>
<input type="password" name="password" required>

<label for="email">email  </label>
<input type="email" name="email" required>

<label for="poste">Poste  </label>
<input type="text" name="poste" required>

<label for="status">Status  </label>
<input type="text" name="status" required>


<label for="role">Choisissez un rôle :</label>
<select id="role" name="role" required>
 <option value="" disabled selected>Sélectionner un role</option>
    <option value="ADMIN">Administrateur</option>
    <option value="Consultant">Consultant</option>
    <option value="Dirigeant">Dirigeant</option>
</select>


<input type="submit" name="Valider">




</form>
</body>
</html>
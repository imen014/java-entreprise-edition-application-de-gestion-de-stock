<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page de bienvenue</title>
</head>
<body>
<div name="menu">
<menu></menu>

<button value="Se connecter">
<c:url var="LoginUserServlet" value="/LoginUserServlet" />
<a href="${LoginUserServlet}">Se connecter</a> <br/>
</button>

<button value="Créer un compte utilisateur">
<c:url var="CreateAccountUserServlet" value="/CreateAccountUserServlet" />
<a href="${CreateAccountUserServlet}">Créer un compte utilisateur</a> <br/>
</button>
 
</form>
</div>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Created</title>
</head>
<body>
<h2>${message}</h2>


<c:url var="CreateUserLink" value="/CreateAccountUserServlet" />
<a href="${CreateUserLink}">Create User</a> <br/>

<c:url var="ConsulterListeUser" value="/StartingWayServlet" />
<a href="${ConsulterListeUser}">Consulter Liste Utilisateurs</a>  <br/>

<c:url var="LoginUserLink" value="/LoginUserServlet" />
<a href="${LoginUserLink}">Login </a>  <br/>

</body>
</html>
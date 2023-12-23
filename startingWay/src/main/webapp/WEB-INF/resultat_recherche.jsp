<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultat Recherche Utilisateur</title>
</head>
<body>
<h1>Résultat Recherche Utilisateur</h1>
<table>
<tr>
<th>ID</th>
<th>Username</th>
<th>Status</th>
</tr>
<c:forEach items="${dataListRecherche}" var="data">
<tr>
<td>${data.id}</td>
<td>${data.username}</td>
<td>${data.status}</td>
</tr>
</c:forEach>
</table>

<c:url var="ListerUserAfterCreation" value="/StartingWayServlet" />
<a href="${ListerUserAfterCreation}">Consulter liste Utilisateur</a> <br/>

<c:url var="CreateUserIfNotExist" value="/CreateAccountUserServlet" />
<a href="${CreateUserIfNotExist}">Create User if not exist</a>
</body>
</html>

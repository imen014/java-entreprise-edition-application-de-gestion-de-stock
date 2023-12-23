<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage de données</title>
</head>
<body>
<h1>Données Recupéres de la base de données</h1>
<c:url var="deleteUserUrl" value="/DeleteUserServlet">
    <c:param name="id" value="${user.id}" />
</c:url>

<table>
<tr>
<th>ID</th>
<th>Username</th>
<th>Email</th>
<th>Role</th>
</tr>
<c:forEach items="${dataList}" var="data">
<tr>
<td>${data.id}</td>
<td>${data.username}</td>
<td>${data.email}</td>
<td>${data.Role}</td>
<td>
<form action="DeleteUserServlet" method="post">
<input type="hidden" name="UserId" value="${data.id}" />
<input type="submit" value="Supprimer Utilisateur" />
</form>
</td>



</tr>
</c:forEach>
</table>

<c:url var="rechercheUrl" value="/RechercheUserNameServlet" />
<a href="${rechercheUrl}?id=${data.id}">Recherche utilisateur</a>



</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Products Result</title>
</head>
<body>
<h1>Résultat Recherche Produits</h1>
<table>
<tr>
<th>ID</th>
<th>Nom Produit</th>
<th>Quantite En Stock</th>
</tr>
<c:forEach items="${productListRecherche}" var="data">
<tr>
<td>${data.id}</td>
<td>${data.nom_produit}</td>
<td>${data.quantite_stock}</td>
</tr>
</c:forEach>
</table>

<c:url var="ModifyProduct" value="/UpdateProductServlet" />
<a href="${ModifyProduct}">Modifier produits</a> <br/>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>liste products selection</title>
</head>
<body>
<h1>Produits existants dans la base de données</h1>
<c:url var="deleteProductUrl" value="/DeleteProductServlet">
    <c:param name="id" value="${product.id}" />
</c:url>

<c:url var="searchProductUrl" value="/SearchProductServlet">
    <c:param name="id" value="${product.nom_produit}" />
</c:url>

<table>
<tr>
<th>ID</th>
<th>Nom produits</th>
<th>Quantité dans le stock</th>
<th>Prix</th>

</tr>
<c:forEach items="${productList}" var="product">
<tr>
<td>${product.id}</td>
<td>${product.nom_produit}</td>
<td>${product.quantite_stock}</td>
<td>${product.prix}</td>

 <td>
<form action="DeleteProductServlet" method="post">
<input type="hidden" name="productId" value="${product.id}" />
<input type="submit" value="Supprimer le produit" />
</form>
</td>
<td>


</td>
</tr>
</c:forEach>
</table>


<a href="${searchProductUrl}">Recherche Produit</a> <br/>

<c:url var="addQuantityProduct" value="/AddQuantityServlet" />
<a href="${addQuantityProduct}">Ajouter quantité produit</a> <br/>

<c:url var="reduceQuantityProduct" value="/ReduceQuantityServlet" />
<a href="${reduceQuantityProduct}">Retirer produit en besoin</a> <br/>

</body>
</html>
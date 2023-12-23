<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show liste products on reserve</title>
</head>
<body>
<c:forEach var="product" items="${maliste_produits_lt}">
<p>product name : ${product.nom_produit}</p>
<p>product quantity : ${product.quantite_stock}</p>
<hr>
</c:forEach>

</body>
</html>
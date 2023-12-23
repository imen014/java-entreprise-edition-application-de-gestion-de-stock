<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>products should be bayed</title>
</head>
<body>
<c:forEach var="product" items="${maliste_produits_gt}">
<p>product name : ${product.nom_produit}</p>
<p>product quantity : ${product.quantite_stock}</p>
<hr>
</c:forEach>

</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="UpdateProductServlet" method="post">
<input type="hidden" name="productId" value="${product.id}" />

<label for="ancien_nom_produit">Ancien Nom Produit</label>
<input type="text" name="ancien_nom_produit"  />

<label for="nouveau_nom_produit">Nouveau Nom Produit</label>
<input type="text" name="nouveau_nom_produit"  />

<label for="NouvelleQuantite_stock">Nouvelle Quantite stock</label>
<input type="text" name="NouvelleQuantite_stock"  />

<input type="submit" value="Modifier le produit" />
</form>


</body>
</html>
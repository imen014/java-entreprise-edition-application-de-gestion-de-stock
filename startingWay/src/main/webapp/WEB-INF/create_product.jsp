<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product Form</title>
</head>
<body>
<form action="CreateProductServlet" method="POST">

<label for="nom_produit"> Nom Produit </label>
<input type="text" name="nom_produit" required /> <br/>

<label for="quantite_stock"> Quantite Stock </label>
<input type="text" name="quantite_stock" required /> <br/>

<label for="price_product"> Prix </label>
<input type="text" name="price_product" required /> <br/>

<input type="submit" name="Valider" />

</form>

<c:url var="ConsulterListeUser" value="/StartingWayServlet" />
<a href="${ConsulterListeUser}">Consulter Liste Utilisateurs</a>


</body>
</html>

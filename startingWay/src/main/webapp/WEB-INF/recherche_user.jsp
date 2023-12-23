<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page de recherche utilisateur</title>
</head>
<body>
<form action="RechercheUserNameServlet" method="POST">

<label for="nom_produit">username</label>
<input type="text" name="username" id="username" />


<input type="submit" name="quantite_produit" value="Valider La Recherhe" />
</form>

<c:url var="listeProduct" value="/ListerProductsServlet" />
<a href="${listeProduct}">Consulter la liste de produits</a> <br/>
</body>
</html>
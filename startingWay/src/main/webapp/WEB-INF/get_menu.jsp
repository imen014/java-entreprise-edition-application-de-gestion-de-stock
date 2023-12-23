<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get the menu of app</title>
</head>
<body>

<c:url var="CreateAccountUrl" value="/CreateAccountUserServlet" />
<a href="${CreateAccountUrl}">Créer compte utilisateur</a> <br/>

<c:url var="DeleteUserServlet" value="/DeleteUserServlet" />
<a href="${DeleteUserServlet}">Supprimer compte utilisateur</a> <br/>

<c:url var="UpdateUserServlet" value="/UpdateUserServlet" />
<a href="${UpdateUserServlet}">Modifer utilisateur</a> <br/>

<c:url var="RechercheUserNameServlet" value="/RechercheUserNameServlet" />
<a href="${RechercheUserNameServlet}">Rercherche utilisateur par nom</a> <br/>


<c:url var="LoginUserServlet" value="/LoginUserServlet" />
<a href="${LoginUserServlet}">Connecter</a> <br/>

<c:url var="DeconnectUserServlet" value="/DeconnectUserServlet" />
<a href="${DeconnectUserServlet}">Se déconnecter</a> <br/>

<c:url var="StartingWayServlet" value="/StartingWayServlet" />
<a href="${StartingWayServlet}">Découvrir ça</a> <br/>

<c:url var="CreateProductUrl" value="/CreateProductServlet" />
<a href="${CreateProductUrl}">Créer un nouveau produit</a> <br/>



<c:url var="DeleteProductServlet" value="/DeleteProductServlet" />
<a href="${DeleteProductServlet}">Supprimer produit</a> <br/>



<c:url var="ListerProductsServlet" value="/ListerProductsServlet" />
<a href="${ListerProductsServlett}">Lister produit</a> <br/>

<c:url var="addQuantityUrl" value="/AddQuantityServlet" />
<a href="${addQuantityUrl}">Ajouter quantité produits</a> <br/>


<c:url var="ProductsShoudBeBayed" value="/ProductsShoudBeBayed" />
<a href="${ProductsShoudBeBayed}">Produits avec quantité maximale</a> <br/>



<c:url var="ReduceQuantityServlet" value="/ReduceQuantityServlet" />
<a href="${ReduceQuantityServlet}">Retirer des produits</a> <br/>

<c:url var="SearchProductServlet" value="/SearchProductServlet" />
<a href="${SearchProductServlet}">Rechercher produits</a> <br/>

<c:url var="ShowProductsLtSeuil" value="/ShowProductsLtSeuil" />
<a href="${ShowProductsLtSeuil}">Produits avec quantité minimale</a> <br/>



<c:url var="UpdateProductServlet" value="/UpdateProductServlet" />
<a href="${UpdateProductServlet}">Modifier produits</a> <br/>




</body>
</html>
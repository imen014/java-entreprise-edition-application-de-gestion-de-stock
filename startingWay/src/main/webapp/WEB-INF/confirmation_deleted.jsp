<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product deleted</title>
</head>
<body>
<p>product  with id ${productIdSupp} - was deleted succeffully</p>
<p> ${message}</p>
<c:url var="listeProduct" value="/ListerProductsServlet" />
<a href="${listeProduct}">Consulter la liste de produits</a> <br/>

</body>
</html>
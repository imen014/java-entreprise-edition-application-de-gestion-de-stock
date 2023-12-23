<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Creation Product</title>
</head>
<body>
<h1>${message}</h1>

<c:url var="listeProduct" value="/ListerProductsServlet" />
<a href="${listeProduct}">Consulter la liste de produits</a> <br/>
</body>
</html>
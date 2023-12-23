<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login succeffuly</title>
</head>
<body>
<h1>${message}</h1>

<c:url var="DeconnectUserServlet" value="/DeconnectUserServlet" />
<a href="${DeconnectUserServlet}">Se déconnecter</a>

<c:url var="GetMenuServlet" value="/GetMenuServlet" />
<a href="${GetMenuServlet}">Menu</a>
</body>
</html>
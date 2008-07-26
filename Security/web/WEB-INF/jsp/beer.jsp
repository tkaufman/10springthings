<%@ include file="/WEB-INF/jsp/header.jsp"%>

<html>
<head>
<title>Beer Selector</title>
</head>
<body>
<h1>The Beer you should drink is:</h1>
<p><c:out value="${beer}" /></p>
<security:authorize ifAllGranted="ROLE_ADMIN">
	<p><a href="<c:url value="/addBeer.do"/>" />Add a New Beer</a></p>
</security:authorize>
</body>
</html>
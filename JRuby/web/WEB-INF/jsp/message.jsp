<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<head><title>JRuby + Spring == Annoying Messages</title></head>
<body>
<h1>JRuby + Spring == Annoying Messages</h1>
<p>The message is: <c:out value="${msg}" /></p>
<p>Delivered at: <c:out value="${now}" /></p>
</body>
</html>
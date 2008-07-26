<%@ include file="/WEB-INF/jsp/header.jsp"%>


<html>
<head>
<title>Add a Brewski</title>
</head>
<body>
<h1>Please add to the fridge</h1>
<form:form modelAttribute="beer">
	<table>
		<tr>
			<th>Beer:
			<br />
			<form:input path="name" size="30" maxlength="80" /></th>
		</tr>
		<tr>
			<th>Quantity:
			<br />
			<form:input path="quantity" size="3" maxlength="3" /></th>
		</tr>
		<tr>
			<td><input type="submit" value="Stock it!" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>
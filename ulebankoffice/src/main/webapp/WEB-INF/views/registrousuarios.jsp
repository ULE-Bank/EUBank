<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title><fmt:message key="title" /></title>
<meta charset="UTF-8">
</head>
<body>
	<h1>
		Registro de usuario
	</h1>
	<p>
		<c:out value="${mensaje}" /><br>
	</p>
	<br>
	<p><a href="/inicio">Volver a Login</a></p>
</html>
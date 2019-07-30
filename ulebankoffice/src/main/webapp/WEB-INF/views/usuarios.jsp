<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><spring:message code="label.title" /></title>
<meta charset="UTF-8">
</head>
<body>
	<h1>
		<spring:message code="label.title" /><br/>
	</h1>
	<p>
	<h1>
		<spring:message code="label.welcome" /><br/>
		<spring:message code="label.language" />: <a href="?language=es">Español</a> | <a href="?language=en">English</a>
		<br>
	</h1>
	<c:out value="${model.mensajeEnFuncionDeMetodo}" />
	<br>
	<h1>Estos son todos los usuarios. Sólo los puede ver el admin.</h1>
	<c:forEach items="${model.todosLosUsuarios}" var="userAdmin">
		<table>
			<tr>
				<th><spring:message code="label.name" /></th>
				<th><spring:message code="label.lastname" /></th>
				<th><spring:message code="label.email" /></th>
				<th><spring:message code="label.password" /></th>
			</tr>
			<tr>
				<td><c:out value="${userAdmin.name}" /></td>
				<td><c:out value="${userAdmin.lastname}" /></td>
				<td><c:out value="${userAdmin.email}" /></td>
				<td><c:out value="${userAdmin.password}" /></td>
			</tr>
		</table>
		<br>
		<br>
	</c:forEach>
	<p>
		<fmt:message key="loginUserPermission" />
		<c:out value="${model.userPermits}" />
	</p>
	<br>
	<p>
		<a href="/inicio">Volver a Login</a>
	</p>
</html>
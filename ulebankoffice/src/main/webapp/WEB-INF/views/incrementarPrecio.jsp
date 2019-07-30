<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>
		<fmt:message key="priceincrease.heading" />
	</h1>
	<!-- Se llama a la clase incrementoPrecio que es la que controla los valores de entrada y puede manejar los errores -->
	<form:form method="post" modelAttribute="incrementoPrecio">
		<table>
			<tr>
				<td align="right" width="20%">Increase (%):</td>
				<td width="20%">
					<!-- Aqui se hace referencia al atributo percentage de la clase mencionada -->
					<form:input path="percentage" />
				</td>
				<td width="60%"><form:errors path="percentage" cssClass="error" />
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Execute">
	</form:form>
	<a href="<c:url value="inicio"/>">Home</a>
</body>
</html>
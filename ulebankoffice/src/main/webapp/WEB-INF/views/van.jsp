<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
</head>
<body>
<h1><fmt:message key="van.heading"/></h1>
<form:form method="post" modelAttribute="van">
  n:
  <form:input path="n"/>
  <br>
  Flujos de caja (Separados por ;):
  <form:input path="Qj"/>
  <br>
  K (Tipo de interes):
  <form:input path="k"/>
  <br>
  Q0 (Capital inicial en negativo):
  <form:input path="Q0"/>
  <br>
  <input type="submit" align="center" value="Calcular">
</form:form>
<c:out value="${model.result}"/>
</body>
</html>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="Créditos">
<meta name="keywords" content="ULe-Bank, creditos">
<meta name="author"
	content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu">
<meta name="robots" content="index,follow">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
<meta property="og:determiner" content="the" />
<meta property="og:title"
	content="<spring:message code='label.siteservice7' />" />
<meta property="og:url"
	content="http://ulebank.unileon.es/creditaccount" />
<meta property="og:description"
	content="<spring:message code='label.siteservice7description'/>" />
<link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
<link rel="stylesheet"
	href="/resources/services/css/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/resources/services/css/styles-responsive.css">
<script src="/resources/services/js/jquery.min.js"></script>
<!-- <script src="/resources/services/js/bootstrap.min.js"></script> -->
<script src="/resources/services/js/jquery-cookie.js"></script>
<script src="/resources/services/js/script.js"></script>
<script src="/resources/services/js/Chart.js"></script>
<!-- Favicon -->
<link rel="shortcut icon" href="../favicon.ico" type="image/gif" />
<!-- bootstrap -->
<link href="/resources/template/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- plugins -->
<link href="/resources/template/css/plugins-css.css" rel="stylesheet"
	type="text/css" />
<!-- mega menu -->
<link href="/resources/template/css/mega-menu/mega_menu.css"
	rel="stylesheet" type="text/css" />
<!-- default -->
<link href="/resources/template/css/default.css" rel="stylesheet"
	type="text/css" />
<!-- main style -->
<link href="/resources/template/css/style.css" rel="stylesheet"
	type="text/css" />
<!-- responsive -->
<link href="/resources/template/css/responsive.css" rel="stylesheet"
	type="text/css" />
<!-- custom style -->
<link href="/resources/template/css/custom.css" rel="stylesheet"
	type="text/css" />
<title><spring:message code="label.siteservice7" /></title>
<!-- GOOGLE ANALYTICS TRACKER -->
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-72492123-1', 'auto');
	ga('send', 'pageview');
</script>
</head>
<body>
	<div class="page-wrapper">
		<!--=================================
         preloader -->
		<div id="preloader">
			<div class="clear-loading loading-effect">
				<span></span>
			</div>
		</div>
		<!--=================================
         preloader -->
		<!--=================================
         header -->
		<jsp:include page="/WEB-INF/views/header.jsp" />
		<!--=================================
         header -->
		<!--=================================
         inner-intro-->
		<section
			class="inner-intro grayscale bg-services-creditaccount bg-opacity-black-70">
			<div class="container">
				<div class="row text-center intro-title">
					<h1 class="text-blue">
						<spring:message code="label.siteservice7" />
					</h1>
					<p class="text-white">
						<spring:message code="label.siteservice7description" />
					</p>
					<ul class="page-breadcrumb">
						<li><a href="./"> <i class="fa fa-home"></i> <spring:message
									code="label.sitehome" />
						</a> <i class="fa fa-angle-double-right"></i></li>
						<li><a href="./#services"> <spring:message
									code="label.siteservices" />
						</a> <i class="fa fa-angle-double-right"></i></li>
						<li><span> <spring:message code="label.siteservice7" />
						</span></li>
					</ul>
				</div>
			</div>
		</section>
		<!--=================================
         inner-intro-->
		<section class="white-bg page-section-ptb">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<form:form role="form" method="post" modelAttribute="credits"
							id="servicesform">
							<div class="col-md-12">
								<div class="col-md-6 col-md-offset-2">
									<div id="register-form" class="register-form">
										<!-- --------- -->
										<div class="row">
											<div class="section-field col-md-8">
												<label for="name"> <spring:message code="label.s7c4" />
													:
												</label>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<div class="field-widget">
													<i class="fa fa-eur"></i>
													<form:input type="text" value="" path="creditLimit" />
												</div>
											</div>
											<div class="section-field col-md-1">
												<span class="tooltip-content text-blue"
													data-original-title="<spring:message code="label.s7i1"/>"
													data-toggle="tooltip" data-placement="top"><i
													class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<form:errors style="color: red;" path="creditLimit"></form:errors>
											</div>
										</div>
										<!-- --------- -->
										<div class="row">
											<div class="section-field col-md-8">
												<label for="name"> <spring:message code="label.s7c5" />
													:
												</label>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<div class="field-widget">
													<i class="fa fa-clock-o"></i> <input type="date"
														id="openingDate" name="openingDate"
														required="required" />
												</div>
											</div>
											<div class="section-field col-md-1">
												<span class="tooltip-content text-blue"
													data-original-title="<spring:message code="label.s7i2"/>"
													data-toggle="tooltip" data-placement="top"><i
													class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<form:errors style="color: red;" path="openingDate"></form:errors>
											</div>
										</div>
										<!-- --------- -->
										<div class="row">
											<div class="section-field col-md-8">
												<label for="name"> <spring:message code="label.s7c6" />
													:
												</label>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<div class="field-widget">
													<i class="fa fa-clock-o"></i> <input type="date"
														id="expirationDate" name="expirationDate"
														required="required" />
												</div>
											</div>
											<div class="section-field col-md-1">
												<span class="tooltip-content text-blue"
													data-original-title="<spring:message code="label.s7i3"/>"
													data-toggle="tooltip" data-placement="top"><i
													class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<form:errors style="color: red;" path="expirationDate"></form:errors>
											</div>
										</div>
										<!-- --------- -->
										<div class="row">
											<div class="section-field col-md-8">
												<label for="name"> <spring:message code="label.s7c7" />
												</label>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<div class="field-widget">
													<i class="fa fa-percent"></i>
													<form:input type="text" path="openingComission" />
												</div>
											</div>
											<div class="section-field col-md-1">
												<span class="tooltip-content text-blue"
													data-original-title="<spring:message code="label.s7i4"/>"
													data-toggle="tooltip" data-placement="top"><i
													class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<form:errors style="color: red;" path="openingComission"></form:errors>
											</div>
										</div>
										<!-- --------- -->
										<!-- --------- -->
										<div class="row">
											<div class="section-field col-md-8">
												<label for="name"> <spring:message code="label.s7c8" />
												</label>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<div class="field-widget">
													<i>&#8240;</i>
													<form:input type="text" path="brokerage" />
												</div>
											</div>
											<div class="section-field col-md-1">
												<span class="tooltip-content text-blue"
													data-original-title="<spring:message code="label.s7i5"/>"
													data-toggle="tooltip" data-placement="top"><i
													class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<form:errors style="color: red;" path="brokerage"></form:errors>
											</div>
										</div>
										<!-- --------- -->
										<!-- --------- -->
										<div class="row">
											<div class="section-field col-md-8">
												<label for="name"> <spring:message code="label.s7c9" />
												</label>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<div class="field-widget">
													<i class="fa fa-percent"></i>
													<form:input type="text" path="debtorInterest" />
												</div>
											</div>
											<div class="section-field col-md-1">
												<span class="tooltip-content text-blue"
													data-original-title="<spring:message code="label.s7i6"/>"
													data-toggle="tooltip" data-placement="top"><i
													class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<form:errors style="color: red;" path="debtorInterest"></form:errors>
											</div>
										</div>
										<!-- --------- -->
										<!-- --------- -->
										<div class="row">
											<div class="section-field col-md-8">
												<label for="name"> <spring:message
														code="label.s7c10" />
												</label>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<div class="field-widget">
													<i class="fa fa-percent"></i>
													<form:input type="text" path="exceededInterest" />
												</div>
											</div>
											<div class="section-field col-md-1">
												<span class="tooltip-content text-blue"
													data-original-title="<spring:message code="label.s7i7"/>"
													data-toggle="tooltip" data-placement="top"><i
													class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<form:errors style="color: red;" path="exceededInterest"></form:errors>
											</div>
										</div>
										<!-- --------- -->
										<!-- --------- -->
										<div class="row">
											<div class="section-field col-md-8">
												<label for="name"> <spring:message
														code="label.s7c11" />
												</label>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<div class="field-widget">
													<i class="fa fa-percent"></i>
													<form:input type="text" path="creditorInterest" />
												</div>
											</div>
											<div class="section-field col-md-1">
												<span class="tooltip-content text-blue"
													data-original-title="<spring:message code="label.s7i8"/>"
													data-toggle="tooltip" data-placement="top"><i
													class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<form:errors style="color: red;" path="creditorInterest"></form:errors>
											</div>
										</div>
										<!-- --------- -->
										<!-- --------- -->
										<div class="row">
											<div class="section-field col-md-8">
												<label for="name"> <spring:message
														code="label.s7c12" />
												</label>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<div class="field-widget">
													<i class="fa fa-percent"></i>
													<form:input type="text" path="comissionSMND" />
												</div>
											</div>
											<div class="section-field col-md-1">
												<span class="tooltip-content text-blue"
													data-original-title="<spring:message code="label.s7i9"/>"
													data-toggle="tooltip" data-placement="top"><i
													class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
											</div>
										</div>
										<div class="row">
											<div class="section-field col-md-8">
												<form:errors style="color: red;" path="comissionSMND"></form:errors>
											</div>
										</div>
										<!-- --------- -->
									</div>
								</div>
								<div class="col-md-4">
									<spring:message code="label.s7lateral" />
								</div>
							</div>
							<div class="section-field col-md-12 register-form">
								<div class="row">
									<div class="section-field col-md-4">
										<label for="name"> <spring:message code="label.s7c1" />
										</label>
										<div class="field-widget">
											<i class="fa fa-pencil"></i> <input type="text"
												id="descripcion-cero"
												value="<spring:message code='label.s7c7'/>"
												disabled="disabled" />
										</div>
									</div>
									<div class="section-field col-md-4">
										<label for="name"> <spring:message code="label.s7c2" />
										</label>
										<div class="field-widget">
											<i class="fa fa-eur"></i> <input type="text"
												id="importe-cero" value="0" disabled="disabled" />
										</div>
									</div>
									<div class="section-field col-md-4">
										<label for="name"> <spring:message code="label.s7c3" />
										</label>
										<div class="field-widget">
											<i class="fa fa-calendar"></i> <input type="date"
												id="fecha-cero" disabled="disabled" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-4">
										<label for="name"> <spring:message code="label.s7c1" />
										</label>
										<div class="field-widget">
											<i class="fa fa-pencil"></i> <input type="text"
												id="descripcion-uno"
												value="<spring:message code='label.s7c8'/>"
												disabled="disabled" />
										</div>
									</div>
									<div class="section-field col-md-4">
										<label for="name"> <spring:message code="label.s7c2" />
										</label>
										<div class="field-widget">
											<i class="fa fa-eur"></i> <input type="text" id="importe-uno"
												value="0" disabled="disabled" />
										</div>
									</div>
									<div class="section-field col-md-4">
										<label for="name"> <spring:message code="label.s7c3" />
										</label>
										<div class="field-widget">
											<i class="fa fa-calendar"></i> <input type="date"
												id="fecha-uno" disabled="disabled" />
										</div>
									</div>
								</div>
								<div id="moves-container">
									<spring:message code="label.disposicion" var="variable1" />
									<spring:message code="label.ingreso" var="variable2" />
									<div class="row"
										style="border: 1px solid red; border-radius: 5px;">
										<div class="section-field col-md-4">
											<label for="movements[0].movementDescription"> <spring:message
													code="label.s7c1" />
											</label>
											<div class="field-widget">
												<i class="fa fa-pencil"></i>
												<form:input path="movements[0].movementDescription"
													required="required" />
											</div>
										</div>
										<div class="section-field col-md-3">
											<label for="movements[0].movementValue"> <spring:message
													code="label.s7c2" />
											</label>
											<div class="field-widget">
												<i class="fa fa-eur"></i>
												<form:input path="movements[0].movementValue"
													required="required" />
											</div>
										</div>
										<div class="section-field col-md-3">
											<label for="movements[0].movementDate"> <spring:message
													code="label.s7c3" />
											</label>
											<div class="field-widget">
												<i class="fa fa-calendar"></i> <input type="date"
													id="movements0.movementDate"
													name="movements[0].movementDate" required="required" />
											</div>
										</div>
										<div class="section-field col-md-2">
											<label for="movements[0].operation"> <spring:message
													code="label.operation" />
											</label>
											<div class="field-widget">
												<form:select path="movements[0].operation"
													class="selected">
													<form:option value="D" label="${variable1}" />
													<form:option value="I" label="${variable2}" />
												</form:select>
											</div>
										</div>
									</div>
								</div>
								<p>
									<a role="button" id="add-moves"> <spring:message
											code="label.addtransaction" /> <span
										class="fa fa-plus-square"></span>
									</a>
								</p>
								<p>
									<a role="button" id="remove-moves"> <spring:message
											code="label.removetransaction" /> <span
										class="fa fa-minus-square"></span>
									</a>
								</p>
								<div class="row text-center intro-title">
									<p class="modal-link last-element">
										<a href="#" data-toggle="modal"
											data-target="#modalExplicativo"> <spring:message
												code="label.whatiscreditaccount" />
										</a>
									</p>
								</div>
								<input type="submit" class="button mt-20"
									value="<spring:message code='label.calculate' />">
								<!-- En caso de que algún usuario tenga desactivado javascript, saldrá este mensaje por defecto. -->
								<noscript>
									<input type="submit"
										value="<spring:message code="label.calculate"/>" />
								</noscript>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</section>
		<!--=================================
         Footer-->
		<jsp:include page="/WEB-INF/views/footer.jsp" />
		<!--=================================
         Footer-->
		<!-- Modal -->
		<div class="modal fade" id="modalExplicativo" tabindex="-1"
			role="dialog" aria-labelledby="modalExplicativoLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalExplicativoLabel">
							<spring:message code="label.credit" />
						</h4>
					</div>
					<div class="modal-body" style="text-align: justify;">
						<p>
							<spring:message code="label.s7i10" />
						</p>
						<p>
							<spring:message code="label.s7i11" />
						</p>
						<p>
							<spring:message code="label.s7i12" />
						</p>
						<p>
							<spring:message code="label.s7i13" />
						</p>
						<p>
							<spring:message code="label.s7i14" />
						</p>
						<p>
							<spring:message code="label.s7i15" />
						</p>
						<p>
							<spring:message code="label.s7i16" />
						</p>
						<p>
							<spring:message code="label.s7i17" />
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<spring:message code="label.close" />
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Fin Modal -->
		<!-- MODAL RESULTADOS -->
		<div class="modal fade" id="modalResultados" tabindex="-1"
			role="dialog" aria-labelledby="modalResultadosLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalResultadosLabel">
							<spring:message code="label.simulationresult" />
						</h4>
					</div>
					<div class="modal-body">
					
						<table class="table" style="background-color:white;">
							<thead>
								<tr>
									<th><spring:message code="label.fecha"/></th>
									<th><spring:message code="label.concepto"/></th>
									<th><spring:message code="label.disposicion"/></th>
									<th><spring:message code="label.ingreso"/></th>		
									<th><spring:message code="label.balance" /></th>
									<th><spring:message code="label.days" /></th>
									<th><spring:message code="label.debtornumbers" /></th>
									<th><spring:message code="label.exceedednumbers" /></th>
									<th><spring:message code="label.creditornumbers" /></th>
								</tr>
							</thead>
							<tbody  style="font-size:13px; text-align:right;">
								<c:forEach var="row" items="${table}">
									<tr>
										<c:forEach var="itemRow" items="${row}">
											<td><c:out value="${itemRow}" /></td>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div style="text-align: center;">
						<table class="table">
							<thead>
								<tr>
									<th></th>
									<th></th>
									<th></th>
								</tr>
							</thead>
						<tbody style=" text-align:right;">
									<tr>
										<td><spring:message code="label.s7c9" /></td>
										<td>${iDebtors1}</td>
										<td>${iDebtors2}</td>
									</tr>
									<tr>
										<td><spring:message code="label.s7c10" /></td>
										<td>${iExceeded1}</td>
										<td>${iExceeded2}</td>
									</tr>
									<tr>
										<td><spring:message code="label.s7c11" /></td>
										<td>${iCreditors1}</td>
										<td>${iCreditors2}</td>
									</tr>
									<tr>
										<td><spring:message code="label.s7c12" /></td>
										<td>${CSMND1}</td>
										<td>${CSMND2}</td>
									</tr>
									<tr>
										<td></td>
										<td><b>TOTAL</b></td>
										<td>${total}</td>
									</tr>
								</tbody>
						</table>
						
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<spring:message code="label.close" />
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- FIN MODAL RESULTADOS -->
	</div>
	<!-- Aplicando i18n al contenido generado dinámicamente -->
	<script type="text/javascript">
		var strings = new Array();
		strings['movimiento.descripcion'] = "<spring:message code='label.s7c1' javaScriptEscape='true' />";
		strings['movimiento.fecha'] = "<spring:message code='label.s7c3' javaScriptEscape='true' />";
		strings['movimiento.importe'] = "<spring:message code='label.s7c2' javaScriptEscape='true' />";
		strings['movimiento.operacion'] = "<spring:message code='label.operation' javaScriptEscape='true' />";
		strings['movimiento.ingreso'] = "<spring:message code='label.ingreso' javaScriptEscape='true' />";
		strings['movimiento.disposicion'] = "<spring:message code='label.disposicion' javaScriptEscape='true' />";
	</script>
	<script src="/resources/services/js/dynamic-form.js"></script>
	<script src="/resources/services/js/tooltip-script.js"></script>
	<!-- bootstrap -->
	<script type="text/javascript"
		src="/resources/template/js/bootstrap.min.js"></script>
	<!-- plugins-jquery -->
	<script type="text/javascript"
		src="/resources/template/js/plugins-jquery.js"></script>
	<!-- mega menu -->
	<script type="text/javascript"
		src="/resources/template/js/mega-menu/mega_menu.js"></script>
	<!-- custom -->
	<script type="text/javascript" src="/resources/template/js/custom.js"></script>
</body>
</html>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="description"
	content="Simulador de préstamos por el método Francés.">
<meta name="keywords"
	content="ULe-Bank, simulador, calculos, prestamo, metodo, frances">
<meta name="author"
	content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu">
<meta name="robots" content="index,follow">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        
        <jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="<spring:message code='label.siteservice2' />" />
      <meta property="og:url" content="http://ulebank.unileon.es/leasing" />
      <meta property="og:description" content="<spring:message code='label.siteservice2description'/>"/>
        
        
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
<link rel="shortcut icon" href="../favicon.ico" />

<!-- bootstrap -->
<link href="resources/template/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<!-- plugins -->
<link href="resources/template/css/plugins-css.css" rel="stylesheet"
	type="text/css" />

<!-- mega menu -->
<link href="resources/template/css/mega-menu/mega_menu.css"
	rel="stylesheet" type="text/css" />

<!-- default -->
<link href="resources/template/css/default.css" rel="stylesheet"
	type="text/css" />

<!-- main style -->
<link href="resources/template/css/style.css" rel="stylesheet"
	type="text/css" />

<!-- responsive -->
<link href="resources/template/css/responsive.css" rel="stylesheet"
	type="text/css" />

<!-- custom style -->
<link href="resources/template/css/custom.css" rel="stylesheet"
	type="text/css" />

<title><spring:message code="label.s4french" /></title>

<!-- CONSTRUCCIÓN DEL CHART DEL MÉTODO FRANCÉS -->
<script type="text/javascript">
	function drawChart() {
		var ctx = document.getElementById("myChart").getContext("2d");

		/* JQUERY - GET COLORS FROM CSS TO CHART */
		var colorHeader = "#55acee";
		var colorCorporativo = "#3b5998";

		Chart.defaults.global.responsiveAnimationDuration = 1000;
		Chart.defaults.global.legend.position = "bottom";
		Chart.defaults.global.animation.easing = "easeOutCirc";

		var data = {
			labels : [ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" ],
			datasets : [
					{
						label : '<spring:message code="label.amortization"/>',
						backgroundColor : colorCorporativo,
						borderColor : colorCorporativo,
						data : [ 6000, 7000, 8000, 9000, 10000, 11000, 12000,
								13000, 14000, 15000 ]
					},
					{
						label : '<spring:message code="label.interest"/>',
						backgroundColor : colorHeader,
						borderColor : colorHeader,
						data : [ 10000, 9000, 8000, 7000, 6000, 5000, 4000,
								3000, 2000, 1000 ]
					} ]
		};

		var myBarChart = new Chart(ctx, {
			type : 'bar',
			data : data,
			animation : {
				animateScale : true
			},
			options : {
				scales : {
					xAxes : [ {
						stacked : true
					} ],
					yAxes : [ {
						stacked : true
					} ]
				}
			}
		});
	}
</script>

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
			class="inner-intro grayscale bg-services-loans-french bg-opacity-black-70">
			<div class="container">
				<div class="row text-center intro-title">
					<h1 class="text-blue">
						<spring:message code="label.s4french" />
					</h1>
					<p class="text-white">
						<spring:message code="label.s4frenchinfo" />
					</p>
					<ul class="page-breadcrumb">
						<li><a href="./"><i class="fa fa-home"></i> <spring:message
									code="label.sitehome" /></a> <i class="fa fa-angle-double-right"></i></li>
						<li><a href="./#services"><spring:message
									code="label.siteservices" /></a> <i
							class="fa fa-angle-double-right"></i></li>
						<li><a href="/loans"><spring:message
									code="label.siteservice4" /></a> <i
							class="fa fa-angle-double-right"></i></li>
						<li><span><spring:message code="label.s4french" /></span></li>
					</ul>
				</div>
			</div>
		</section>

		<!--=================================
 inner-intro-->

		<section class="white-bg page-section-ptb">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-2">
						<form:form role="form" method="post"
							modelAttribute="frenchLoanConstantFee" id="servicesform">
							<div id="register-form" class="register-form">
								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message
												code="label.initialcapital" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<i class="fa fa-eur"></i>
											<form:input type="text" value="" path="C0" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.initialcapitalinfo"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="C0"></form:errors>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message
												code="label.typeofinterest" /></label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<i class="fa fa-percent"></i>
											<form:input type="text" path="i" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.s4typeofinterestinfo"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="i"></form:errors>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message code="label.periods" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<i class="fa fa-clock-o"></i>
											<form:input type="text" name="name" path="k" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.periodsinfo"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="k"></form:errors>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message
												code="label.typeofperiod" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<spring:message code="label.annual" var="variable1" />
											<spring:message code="label.biannual" var="variable2" />
											<spring:message code="label.cuatrimestral" var="variable3" />
											<spring:message code="label.quarterly" var="variable4" />
											<spring:message code="label.monthly" var="variable6" />
											<form:select path="p">
												<form:option value="1" label="1 - ${variable1}" />
												<form:option value="2" label="2 - ${variable2}" />
												<form:option value="3" label="3 - ${variable3}" />
												<form:option value="4" label="4 - ${variable4}" />
												<form:option value="12" label="12 - ${variable6}" />
											</form:select>
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.s4typeofperiodinfo"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="p"></form:errors>
									</div>
								</div>

								<div class="bg-info">
									<h3>
										<c:out value="${model.resultado}" />
									</h3>
								</div>

								<div class="row">
									<div class="section-field col-md-8">
										<div class="row text-center intro-title">
											<p class="modal-link last-element">
												<a href="" data-toggle="modal"
													data-target="#modalExplicativo" onclick="drawChart()"><spring:message
														code="label.whatisfrenchloan" /></a>
											</p>
										</div>
										<a class="button mt-20" id="submitservices"
											onclick="document.getElementById('servicesform').submit()">
											<span><spring:message code="label.calculate" /></span> <i
											class="fa fa-calculator"></i>
										</a>
										<!-- En caso de que algún usuario tenga desactivado javascript, saldrá este mensaje por defecto. -->
										<noscript>
											<input type="submit"
												value="<spring:message code="label.calculate"/>" />
										</noscript>
									</div>
								</div>
							</div>
						</form:form>
					</div>
					
					<!-- 					Descripción lateral  -->
					<div class="col-md-4">
						<spring:message code="label.s4frenchlateral" />
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
							<spring:message code="label.s4french" />
						</h4>
					</div>
					<div class="modal-body" style="text-align: justify;">
						<p>
							<spring:message code="label.frenchmethodloaninfo" />
						</p>
						<p>
							<spring:message code="label.fmi2" />
						</p>
						<p>
							<spring:message code="label.fmi3" />
						</p>
						<p>
							<spring:message code="label.fmi4" />
						</p>
						<p style="text-align: center;">
						<img src="resources/template/images/prestamos/formulaprestamofrances.png"/>
						</p>
						<p>
							<spring:message code="label.fmi5" />
						</p>

						<canvas id="myChart" width="600" height="300"></canvas>
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
						<table class="table">
							<thead>
								<tr>
									<th><spring:message code="label.period" /></th>
									<th><spring:message code="label.annuality" /></th>
									<th><spring:message code="label.interest" /></th>
									<th><spring:message code="label.amortization" /></th>
									<th><spring:message code="label.pendingcapital" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="fila" items="${table}">
									<tr>
										<c:forEach var="itemFila" items="${fila}">
											<td><c:out value="${itemFila}" /></td>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<table class="table">
							<thead>
								<tr>
									<th></th>
									<th>TOTAL <spring:message code="label.annuality" /></th>
									<th>TOTAL <spring:message code="label.interest" /></th>
									<th>TOTAL <spring:message code="label.amortization" /></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="fila" items="${tableTotals}">
											<td><c:out value="${fila}" /></td>
								</c:forEach>
							</tbody>
						</table>
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

	<script src="resources/services/js/tooltip-script.js"></script>

	<!-- bootstrap -->
	<script type="text/javascript"
		src="resources/template/js/bootstrap.min.js"></script>

	<!-- plugins-jquery -->
	<script type="text/javascript"
		src="resources/template/js/plugins-jquery.js"></script>

	<!-- mega menu -->
	<script type="text/javascript"
		src="resources/template/js/mega-menu/mega_menu.js"></script>

	<!-- custom -->
	<script type="text/javascript" src="resources/template/js/custom.js"></script>


</body>
</html>
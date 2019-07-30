<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="description" content="Descuentos">
<meta name="keywords" content="ULe-Bank, descuentos">
<meta name="author" content="Alexis Gutiérrez & Camino Fernández">
<meta name="robots" content="index,follow">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        
        <jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="<spring:message code='label.siteservice5' />" />
      <meta property="og:url" content="http://ulebank.unileon.es/discounts" />
      <meta property="og:description" content="<spring:message code='label.siteservice5description'/>"/>
        
        
<link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
<link rel="stylesheet"
	href="/resources/services/css/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/resources/services/css/styles-responsive.css">

<script src="/resources/services/js/jquery.min.js"></script>

<!-- <script src="/resources/services/js/bootstrap.min.js"></script> -->

<script src="/resources/services/js/jquery-cookie.js"></script>

<script src="/resources/services/js/script.js"></script>

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

<title><spring:message code="label.siteservice5" /></title>

<!-- GOOGLE ANALYTICS TRACKER -->
<script>
  			(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  			(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  			m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  			})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

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
			class="inner-intro grayscale bg-services-discounts bg-opacity-black-70">
			<div class="container">
				<div class="row text-center intro-title">
					<h1 class="text-blue">
						<spring:message code="label.siteservice5" />
					</h1>
					<p class="text-white">
						<spring:message code="label.siteservice5description" />
					</p>
					<ul class="page-breadcrumb">
						<li><a href="/"><i class="fa fa-home"></i> <spring:message
									code="label.sitehome" /></a> <i class="fa fa-angle-double-right"></i></li>
						<li><a href="/#services"><spring:message
									code="label.siteservices" /></a> <i
							class="fa fa-angle-double-right"></i></li>
						<li><span><spring:message code="label.siteservice5" /></span>
						</li>
					</ul>
				</div>
			</div>
		</section>

		<!--=================================
 inner-intro-->
		<!--=================================
 Form-->

		<section class="white-bg page-section-ptb">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
					<div class="col-md-6 col-md-offset-2">
						<form:form role="form" method="post" modelAttribute="discounts"
							id="servicesform">
							<div id="register-form" class="register-form">
								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message code="label.s5c1" /></label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<i class="fa fa-eur"></i>
											<form:input type="text" name="name" path="discountValue" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.s5i3"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="discountValue"></form:errors>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message code="label.s5c2" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<i class="fa fa-clock-o"></i>
											<form:input type="text" name="name" path="discountPeriod" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.s5i4"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="discountPeriod"></form:errors>
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
											<form:input type="text" name="name" path="interestRate" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.s5i5"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="interestRate"></form:errors>
									</div>
								</div>





								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message code="label.s5c3" /></label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<spring:message code="label.365days" var="variable1" />
											<spring:message code="label.360days" var="variable2" />
											<form:select path="base">
												<form:option value="365" label="${variable1}" />
												<form:option value="360" label="${variable2}" />
											</form:select>
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.s5i6"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message code="label.s5c4" /></label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<i class="fa fa-eur"></i>
											<form:input type="text" name="name" path="otherExpenses" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.s5i7"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="otherExpenses"></form:errors>
									</div>
								</div>



								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message code="label.s5c5" /></label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<i class="fa fa-percent"></i>
											<form:input type="text" name="name" path="comissions" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.s5i8"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="comissions"></form:errors>
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
												<a href="#" data-toggle="modal"
													data-target="#modalExplicativo"> <spring:message
														code="label.whatisdiscount" /></a>
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
						<spring:message code="label.s5lateral" />
					</div>
					</div>
				</div>
			</div>
		</section>

		<!--=================================
 Form-->

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
							<spring:message code="label.siteservice5" />
						</h4>
					</div>
					<div class="modal-body" style="text-align: justify;">
						<p>
							<spring:message code="label.s5i1" />
						</p>

						<p>
							<spring:message code="label.s5i2" />
						</p>
						
						<p>
							<spring:message code="label.s5i9" />
						</p>
						
						<p>
							<spring:message code="label.s5i10" />
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
						<table class="table">
							<thead>
								<tr>
									<th><spring:message code="label.interest" /></th>
									<th><spring:message code="label.comission" /></th>
									<th><spring:message code="label.totalspend" /></th>
									<th><spring:message code="label.cash" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="row" items="${table}">
									<tr>
										<c:forEach var="itemRow" items="${row}">
											<td><c:out value="${itemRow}" /></td>
										</c:forEach>
									</tr>
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
		<script src="/resources/services/js/tooltip-script.js"></script>

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
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="description"
	content="Simulador de préstamo método continuo">
<meta name="keywords"
	content="ULe-Bank, simulador, calculos, prestamo, metodo, continuo">
<meta name="author"
	content="David Fernandez Gonzalez">
<meta name="robots" content="index,follow">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        
      <jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="<spring:message code='label.continuousLoan' />" />
      <meta property="og:url" content="http://ulebank.unileon.es/continuousLoan" />
      <meta property="og:description" content="<spring:message code='label.continuousLoan'/>"/>
        
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

<title><spring:message code="label.continuousLoan" /></title>

<!-- CONSTRUCCIÓN DEL CHART DEL MÉTODO CONTINUO -->
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
                    labels: [ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"],
                    datasets: [
                        {
                            label: '<spring:message code="label.amortization"/>',
                            backgroundColor: colorCorporativo,
                            borderColor: colorCorporativo,
                            data: [4219.63, 5168.18, 6223.17, 7394.63, 8693.49, 10131.62, 11721.93, 13478.46, 15416.45, 17552.46]
                        },
                        {
                            label: '<spring:message code="label.interest"/>',
                            backgroundColor: colorHeader,
                            borderColor: colorHeader,
                            
                            data: [8000.00,7662.43,7248.98,6751.12,6159.55,5464.07,4653.54,3715.79,2637.51,1404.20]
                        }
                    ]
                };

                var myBarChart = new Chart(ctx, {
    				type: 'bar',
    				data: data,
    				animation:{
				        animateScale:true
				    },
    				options: {
        				scales: {
			                xAxes: [{
			                        stacked: true
			                }],
			                yAxes: [{
			                        stacked: true
			                }]
			            }
    				}
				});
            }
        </script>

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
			class="inner-intro grayscale bg-services-loans-italian bg-opacity-black-70">
			<div class="container">
				<div class="row text-center intro-title">
					<h1 class="text-blue">
						<spring:message code="label.continuousLoan" />
					</h1>
					<ul class="page-breadcrumb">
						<li><a href="./"><i class="fa fa-home"></i> <spring:message
									code="label.sitehome" /></a> <i class="fa fa-angle-double-right"></i></li>
						<li><a href="./#services"><spring:message
									code="label.siteservices" /></a> <i
							class="fa fa-angle-double-right"></i></li>
						<li><a href="/loans"><spring:message
									code="label.siteservice4" /></a> <i
							class="fa fa-angle-double-right"></i></li>
						<li><span><spring:message code="label.continuousLoan" /></span></li>
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
							modelAttribute="continuousLoan" id="servicesform">
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
											<form:input type="text" path="i" id="i"/>
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
		
								<div class="row" id="error" style="display: none; color: red">
									<spring:message code="label.ratiocontinuousloaninfo"/>
								</div>
		
										
								<div class="row">
									<div class="section-field col-md-8">
										<label for="name"><spring:message code="label.ratiocontinuousloan" />:</label>
									</div>
								</div>
								
								<div class="row">
									<div class="section-field col-md-8">
										<div class="field-widget">
											<i class="fa fa-percent"></i>
											<form:input type="text" id="t" name="t" path="t" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.ratiocontinuousloaninfo"/>"
											data-toggle="tooltip" data-placement="top" id="toggle-error"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-8">
										<form:errors style="color: red;" path="t"></form:errors>
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
														code="label.whatiscontinuousloan" /></a>
											</p>
										</div>
										<a class="button mt-20" id="submitservices"
											onclick="checkValid()">
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
						<spring:message code="label.continuousLoanLateral" />
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
							<spring:message code="label.continuousLoan" />
						</h4>
					</div>
					<div class="modal-body" style="text-align: justify;">
						<p>
							<spring:message code="label.continuousloaninfo" />
						</p>
						<p style="text-align: center">
							<img style="width: 70%"src="resources/template/images/prestamos/formulaprestamocontinuo.png"/>
						</p>
<p>
							<spring:message code="label.cmi2" />
						</p>
						<p>
							<spring:message code="label.cmi3" />
						</p>
						<p>
							<spring:message code="label.cmi4" />
						</p>
						<p>
							<spring:message code="label.cmi5" />
						</p>
						<p>
							<spring:message code="label.cmi6" />
						</p>
						<p>
							<spring:message code="label.cmi7" />
						</p>
						<p>
							<spring:message code="label.cmi8" />
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
	<script>
		function checkValid() {
			var i = parseFloat($("#i").val())
			var q = parseFloat($("#t").val())
			
			if (i != q && q <= (i+1)) {
				document.getElementById('servicesform').submit()
			}else{
				$("#error").show()
			}
				
		}
	</script>
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
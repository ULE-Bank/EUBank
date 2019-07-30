<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        
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
        
        <title><spring:message code="label.query" /> ${model.id_consulta}</title>
        
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
			class="inner-intro grayscale bg-consulting bg-opacity-black-70">
			<div class="container">
				<div class="row text-center intro-title">
					<h1 class="text-blue">
						<spring:message code="label.siteservice3" />
					</h1>
					<p class="text-white">
						<spring:message code="label.siteservice3description" />
					</p>
					<ul class="page-breadcrumb">
						<li><a href="./"><i class="fa fa-home"></i> <spring:message
									code="label.sitehome" /></a> <i class="fa fa-angle-double-right"></i></li>
						<li><span><a href="/offersconsulting"><spring:message code="label.siteservice3" /></a><i class="fa fa-angle-double-right"></i></span></li>
						<li><span><spring:message code="label.query" /> ${model.id_consulta}</span></li>		
					</ul>
				</div>
			</div>
		</section>

		<!--=================================
 inner-intro-->
        
         
        <section class="white-bg pt-40">
			<div class="container">
                
                <div class="page-header">
  					<h1><c:out value="${model.titulo}"/></h1>
				</div>
				
				<div class="col-md-8 col-md-offset-2">
						<form:form role="form" method="post"
							modelAttribute="adminAnswer" id="servicesform">
							<div id="register-form" class="register-form">
								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message code="label.querystatus" />:<c:out value="${model.state}"/></label>
									</div>
								</div>
								
								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message code="label.name" />:<c:out value="${model.nombre}"/></label>
									</div>
								</div>
								
								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message code="label.lastname" />:<c:out value="${model.apellidos}"/></label>
									</div>
								</div>
								
								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message code="label.contractlink" />:<a href="<c:out value="${model.url}"/>"><c:out value="${model.url}"/></a></label>
									</div>
								</div>
								
								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message code="label.comments" />:<c:out value="${model.comentarios}"/></label>
									</div>
								</div>
								
								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message code="label.expertanswer" />:</label>
									</div>
								</div>
								
								<div class="row">
									<div class="section-field col-md-12">
										<div class="field-widget">
											<form:textarea type="text" value="" path="answer" rows="5" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="answer"></form:errors>
									</div>
								</div>
								<form:hidden path="email" value="${model.email}"/>
  								<form:hidden path="idConsulta" value="${model.id_consulta}"/>
  								
		
								<div class="row">
									<div class="section-field col-md-6">
										<a class="button mt-20" id="submitservices"
											onclick="document.getElementById('servicesform').submit()">
											<span><spring:message code="label.submitresponse" /></span> <i
											class="fa fa-paper-plane-o"></i>
										</a>
										<!-- En caso de que algún usuario tenga desactivado javascript, saldrá este mensaje por defecto. -->
										<noscript>
											<input type="submit"
												value="<spring:message code="label.submitresponse"/>" />
										</noscript>
									</div>
								</div>
							</div>
						</form:form>
					</div>
		
				<div class="btn-group last-element pull-right" role="group">
					<a href="/logout" class="btn btn-default"><spring:message code="label.logout" /></a>
				</div>
				
			</div>
        </section>
        
        </div>

	<!--=================================
 Footer-->
	<jsp:include page="/WEB-INF/views/footer.jsp" />
	<!--=================================
 Footer-->
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
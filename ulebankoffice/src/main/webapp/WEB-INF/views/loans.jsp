<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="description"
	content="Préstamos ULe-Bank. Francés. Italiano. Alemán. Americano.">
<meta name="keywords"
	content="ULe-Bank, préstamos, frances, aleman, italiano, americano">
<meta name="author"
	content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu">
<meta name="robots" content="index,follow">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        
        <jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="<spring:message code='label.siteservice4' />" />
      <meta property="og:url" content="http://ulebank.unileon.es/loans" />
      <meta property="og:description" content="<spring:message code='label.siteservice4description'/>"/> 
        
        
<link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />

<!-- <link rel="stylesheet" href="resources/services/css/bootstrap.min.css"> -->
<link rel="stylesheet"
	href="resources/services/css/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="resources/services/css/styles-responsive.css">

<script src="resources/services/js/jquery.min.js"></script>
<!-- <script src="resources/services/js/bootstrap.min.js"></script> -->

<script src="resources/services/js/jquery-cookie.js"></script>

<script src="resources/services/js/script.js"></script>

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

<title><spring:message code="label.siteservice4" /></title>

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
			class="inner-intro grayscale bg-services-loans bg-opacity-black-70">
			<div class="container">
				<div class="row text-center intro-title">
					<h1 class="text-blue">
						<spring:message code="label.siteservice4" />
					</h1>
					<p class="text-white">
						<spring:message code="label.siteservice4description" />
					</p>
					<ul class="page-breadcrumb">
						<li><a href="./"><i class="fa fa-home"></i> <spring:message
									code="label.sitehome" /></a> <i class="fa fa-angle-double-right"></i></li>
						<li><a href="./#services"><spring:message
									code="label.siteservices" /></a> <i
							class="fa fa-angle-double-right"></i></li>
						<li><span><spring:message code="label.siteservice4" /></span>
						</li>
					</ul>
				</div>
			</div>
		</section>

		<!--=================================
 inner-intro-->

		<!--=================================
 prestamos-->

		<section class="faq white-bg page-section-ptb">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12">
						<div class="section-title-1 text-center">
							<h1 class="text-blue">
								<spring:message code="label.siteservice4" />
							</h1>
							<div class="title-line"></div>
							<p>
								<spring:message code="label.siteservice4intro" />
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12">
						<div class="accordion">
							<div class="accordion-title">
								<a href="#"><spring:message code="label.s4french" /></a>
							</div>
							<div class="accordion-content">
								<h5>
									<spring:message code="label.characteristics" />
								</h5>
								<!--                 <p>Lorem ipsum dolor sit amet of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat </p> -->
								<ul>
									<li>1. <spring:message code="label.s4c1" /></li>
									<li>2. <spring:message code="label.s4c2" /></li>
									<li>3. <spring:message code="label.s4c3" /></li>
								</ul>
								<a href="/frenchloan" target="_blank" class="button mt-20"> <span><spring:message
											code="label.startsimulation" /></span> <i
									class="fa fa-external-link"></i>
								</a>
							</div>
							<div class="accordion-title">
								<a href="#"><spring:message code="label.s4italian" /></a>
							</div>
							<div class="accordion-content">
								<h5>
									<spring:message code="label.characteristics" />
								</h5>
								<ul>
									<li>1. <spring:message code="label.s4c1" /></li>
									<li>2. <spring:message code="label.s4c4" /></li>
									<li>3. <spring:message code="label.s4c5" /></li>
								</ul>
								<a href="/italianloan" target="__blank" class="button mt-20">
									<span><spring:message code="label.startsimulation" /></span> <i
									class="fa fa-external-link"></i>
								</a>
							</div>
							
							<div class="accordion-title">
								<a href="#"><spring:message code="label.s4german" /></a>
							</div>
							<div class="accordion-content">
								<h5>
									<spring:message code="label.characteristics" />
								</h5>
								<ul>
									<li>1. <spring:message code="label.s4c1" /></li>
									<li>2. <spring:message code="label.s4c4" /></li>
									<li>3. <spring:message code="label.s4c5" /></li>
									<li>4. <spring:message code="label.s4c6" /></li>
								</ul>
								<a href="/germanloan" target="_blank" class="button mt-20"> <span><spring:message
											code="label.startsimulation" /></span> <i
									class="fa fa-external-link"></i>
								</a>

							</div>
							<div class="accordion-title">
								<a href="#"><spring:message code="label.s4american" /></a>
							</div>
							<div class="accordion-content">
								<h5>
									<spring:message code="label.characteristics" />
								</h5>
								<ul>
									<li>1. <spring:message code="label.s4c7" /></li>
									<li>2. <spring:message code="label.s4c8" /></li>
									<li>3. <spring:message code="label.s4c9" /></li>
								</ul>
								<a href="/americanloan" target="_blank" class="button mt-20">
									<span><spring:message code="label.startsimulation" /></span> <i
									class="fa fa-external-link"></i>
								</a>
							</div>
							
													
							<div class="accordion-title">
								<a href="#"><spring:message code="label.continuousLoan" /></a>
							</div>
							<div class="accordion-content">
								<h5>
									<spring:message code="label.characteristics" />
								</h5>
								<ul>
									<li>1. <spring:message code="label.s4c10" /></li>
								</ul>
								<a href="/continuousloan" target="_blank" class="button mt-20"> <span><spring:message
											code="label.startsimulation" /></span> <i
									class="fa fa-external-link"></i>
								</a>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<!--=================================
 prestamos-->

		<!--=================================
 Footer-->
		<jsp:include page="/WEB-INF/views/footer.jsp" />
		<!--=================================
 Footer-->
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
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="description"
	content="Simulador de préstamo método Italiano.">
<meta name="keywords"
	content="ULe-Bank, simulador, calculos, prestamo, metodo, italiano">
<meta name="author"
	content="Razvan Raducu, Camino Fernández">
<meta name="robots" content="index,follow">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        
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
<link rel="shortcut icon" href="/../favicon.ico" />

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
	
	<title><spring:message code="label.s4italian" /></title>
	
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
<div class="bg-httperror-404 bg-opacity-black-70">
		<!--=================================
 header -->
		<jsp:include page="/WEB-INF/views/header.jsp" />

		<!--=================================
 header -->
  
<section class="error-404-2 page-section-ptb clearfix">
  <div class="container">
    <div class="row">
       <div class="col-lg-12 col-md-12">
         <div class="error-block text-center clearfix">
            <h1>403 :(</h1>
           <p class="text-white"><spring:message code="label.403"/></p>
         </div>   
         <div class="mt-60 text-center">
            <a class="button-border" href="/">
              <span><spring:message code="label.sitehome"/></span>
            </a>
             <a class="button-border" href="/o/logout">
              <span><spring:message code="label.closesession"/></span>
            </a>
            
         </div>    
 
      </div>
    </div>
   </div>
 </section>
</div> 
 <!--=================================
 Footer-->
		<jsp:include page="/WEB-INF/views/footer.jsp" />
		<!--=================================
 Footer-->
 
 </div>
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
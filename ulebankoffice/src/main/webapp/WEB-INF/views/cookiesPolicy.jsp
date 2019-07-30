<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        
        <meta name="description" content="Política de cookies de ULe-Bank.">
        <meta name="keywords" content="ULe-Bank, politica, cookies">
		<meta name="author" content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu">
		<meta name="robots" content="index,follow">
                <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="<spring:message code='label.cookiespolicy' />" />
      <meta property="og:url" content="http://ulebank.unileon.es/cookies" />
      <meta property="og:description" content="<spring:message code='label.cookiespolicydescription'/>"/>
        
        
        
        <link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
        
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

<title><spring:message code="label.cookiespolicy" /></title>
        
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
			class="inner-intro grayscale bg-cookiespolicy bg-opacity-black-80">
			<div class="container">
				<div class="row text-center intro-title">
					<h1 class="text-blue">
						<spring:message code="label.cookiespolicy" />
					</h1>
					<p class="text-white">
						<spring:message code="label.cookiespolicydescription" />
					</p>
					<ul class="page-breadcrumb">
						<li><a href="./"><i class="fa fa-home"></i> <spring:message
									code="label.sitehome" /></a> <i class="fa fa-angle-double-right"></i></li>
						<li><span><spring:message
									code="label.cookiespolicy" /></span></li>
					</ul>
				</div>
			</div>
		</section>

		<!--=================================
 inner-intro-->
        
        
        
        
        <section class="white-bg page-section-ptb">
			<div class="container">
        
				<p class="text-justify"><spring:message code="label.cookies1"/></p>
				
				<h3><spring:message code="label.cookies2"/></h3>
				
				<p class="text-justify"><spring:message code="label.cookies3"/></p>
				
				<ul>
					<li><spring:message code="label.cookies4"/></li>
					<li><spring:message code="label.cookies5"/></li>
				</ul>
				
				<br/>
				
				<h3><spring:message code="label.cookies6"/></h3>
				
				<table class="table">
					<thead>
      					<tr>
        					<th class="col-md-3" class="text-justify"><spring:message code="label.cookies7"/></th>
        					<th class="col-md-6"><spring:message code="label.cookies8"/></th>
        					<th class="col-md-3"><spring:message code="label.cookies9"/></th>
      					</tr>
    				</thead>
    				<tbody>
      					<tr>
        					<td class="col-md-3"><spring:message code="label.cookies10"/></td>
        					<td class="col-md-6"><p class="text-justify"><spring:message code="label.cookies11"/></p></td>
        					<td class="col-md-3">
        						<a href="https://www.google.com/policies/technologies/types/">
        							Google Authentication
        						</a>
        					</td>
      					</tr>
      					<tr>
        					<td class="col-md-3"><spring:message code="label.cookies12"/></td>
        					<td class="col-md-6"><p class="text-justify"><spring:message code="label.cookies13"/></p></td>
        					<td class="col-md-3">
        						<a href="https://developers.google.com/analytics/devguides/collection/analyticsjs/cookie-usage?hl=es#overview">
        							Google Analytics
        						</a>
        					</td>
      					</tr>
      					<tr>
        					<td class="col-md-3"><spring:message code="label.cookies18"/></td>
        					<td class="col-md-6" ><p class="text-justify"><spring:message code="label.cookies19"/></p></td>
        					<td class="col-md-3">
        					<spring:message code="label.cookies20"/>
        						<a href="./">
        							<spring:message code="label.ulebank"/>
        						</a>
        					</td>
      					</tr>
      					
    				</tbody>
  				</table>
  				
  				<br/>
				
				<h3><spring:message code="label.cookies14"/></h3>
				
				<p><spring:message code="label.cookies15"/></p>
				
				<p><spring:message code="label.cookies16"/></p>
				
				<p><spring:message code="label.cookies17"/></p>
				
				<br/>
				
				<h4>Internet Explorer™:</h4>

				<p>V. 5<br/>
				<a href="http://support.microsoft.com/kb/196955/es">http://support.microsoft.com/kb/196955/es</a></p>
				<p>V. 6<br/>
				<a href="http://support.microsoft.com/kb/283185/es">http://support.microsoft.com/kb/283185/es</a></p>
				<p>V. 7 & 8<br/>
				<a href="http://windows.microsoft.com/es-ES/windows-vista/Block-or-allow-cookies">
					http://windows.microsoft.com/es-ES/windows-vista/Block-or-allow-cookies
				</a></p>
				<p>V. 9<br/>
				<a href="http://windows.microsoft.com/es-ES/windows7/How-to-manage-cookies-in-Internet-Explorer-9">
					http://windows.microsoft.com/es-ES/windows7/How-to-manage-cookies-in-Internet-Explorer-9
				</a></p>
				<p>V. 10<br/>
				<a href="http://windows.microsoft.com/es-es/internet-explorer/ie-security-privacy-settings#ie=ie-10">
					http://windows.microsoft.com/es-es/internet-explorer/ie-security-privacy-settings#ie=ie-10
				</a></p>
				<p>V. 11<br/>
				<a href="http://windows.microsoft.com/es-es/internet-explorer/ie-security-privacy-settings#ie=ie-11">
					http://windows.microsoft.com/es-es/internet-explorer/ie-security-privacy-settings#ie=ie-11
				</a></p>
				
				<br/>

				<h4>Safari™:</h4>

				<p>V. 5 & 6<br/>
				<a href="http://www.apple.com/es/support/mac-apps/safari/">http://www.apple.com/es/support/mac-apps/safari/</a></p>
				<p>V. 7<br/>
				<a href="http://support.apple.com/kb/PH17191?viewlocale=es_ES&locale=es_ES">http://support.apple.com/kb/PH17191?viewlocale=es_ES&locale=es_ES</a></p>
				<p>V. 8<br/>
				<a href="http://support.apple.com/kb/PH19214?viewlocale=es_ES&locale=es_ES">http://support.apple.com/kb/PH19214?viewlocale=es_ES&locale=es_ES</a></p>
				<p>iPhone, iPad o iPod<br/>
				<a href="http://support.apple.com/kb/HT1677?viewlocale=es_ES">http://support.apple.com/kb/HT1677?viewlocale=es_ES</a></p>
				
				<br/>
				
				<h4>Google Chrome™:</h4>
	
				<p><a href="https://support.google.com/chrome/answer/95647?hl=es&hlrm=en">https://support.google.com/chrome/answer/95647?hl=es&hlrm=en</a></p>
				
				<br/>
				
				<h4>Mozilla Firefox™:</h4>
	
				<p><a href="http://support.mozilla.org/es/kb/cookies-informacion-que-los-sitios-web-guardan-en-?redirectlocale=en-US&redirectslug=Cookies">
					http://support.mozilla.org/es/kb/cookies-informacion-que-los-sitios-web-guardan-en-?redirectlocale=en-US&redirectslug=Cookies
				</a></p>
				
				<br/>
				
				<h4>Opera™:</h4>
	
				<p><a href="http://help.opera.com/Windows/11.50/es-ES/cookies.html">
					http://help.opera.com/Windows/11.50/es-ES/cookies.html
				</a></p>
				
				<br/>
				
				<h4>Android:</h4>
	
				<p><a href="http://support.google.com/android/?hl=es">
					http://support.google.com/android/?hl=es
				</a></p>
				
				<br/>
				
				<h4>Windows Phone:</h4>
	
				<p><a href="http://www.windowsphone.com/es-ES/how-to/wp7/web/changing-privacy-and-other-browser-settings">
					http://www.windowsphone.com/es-ES/how-to/wp7/web/changing-privacy-and-other-browser-settings
				</a></p>
				
				<br/>
				
				<h4>Blackberry:</h4>
	
				<p class="last-element"><a href="http://docs.blackberry.com/en/smartphone_users/deliverables/18578/Turn_off_cookies_in_the_browser_60_1072866_11.jsp">
					http://docs.blackberry.com/en/smartphone_users/deliverables/18578/Turn_off_cookies_in_the_browser_60_1072866_11.jsp
				</a></p>
				
			
        
        </div>
	</section>
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
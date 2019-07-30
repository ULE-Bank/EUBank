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

<title><spring:message code="label.allqueries" /></title>
        
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
						<li><span><spring:message code="label.siteservice3" /><i class="fa fa-angle-double-right"></i></span></li>
						<li><span><spring:message code="label.allqueries" /></span></li>		
					</ul>
				</div>
			</div>
		</section>

		<!--=================================
 inner-intro-->
        
        
        <section class="white-bg pt-40">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<h1>
							<spring:message code="label.welcomeadmin" /> ${adminName}
						</h1>
					</div>
				</div>
        
        	
        
       <div class="page-header"></div>
				<div class="row">
					<div class="col-md-4">
						<h3>
							<spring:message code="label.querieslist" />
						</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<table class="table">
							<thead>
								<tr>
									<th><spring:message code="label.querys1" /></th>
									<th><spring:message code="label.querys2" /></th>
									<th><spring:message code="label.querys3" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="listValue" items="${lists}">
									<tr>
										<td><a
											href="/adminquerypage?id=<c:out value="${listValue.id}"/>"><c:out
													value="${listValue.id}" /></a></td>
										<td><c:out value="${listValue.title}" /></td>
										<td><c:out value="${listValue.state}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="btn-group pull-right last-element" role="group">
						<a href="/newadminquery" class="button mt-20" >
											<span><spring:message
									code="label.newquery" /> Admin </span> <i
											class="fa fa-plus"></i>
										</a>
							
							<a href="/newquery" class="button mt-20" >
											<span><spring:message
									code="label.newquery" /></span> <i
											class="fa fa-plus"></i>
										</a>
							<a href="/questions-list" class="button mt-20" >
											<span><spring:message
									code="label.allqueries" /></span> <i
											class="fa fa-list-ol"></i>
										</a>
							
							<a href="/logout" class="button mt-20" >
											<span><spring:message
									code="label.closesession" /></span> <i
											class="fa fa-sign-out"></i>
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
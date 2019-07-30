<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8"%>

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

<title><spring:message code="label.siteservice3" /></title>

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
						<li><span><spring:message code="label.siteservice3" /></span></li>
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
							<spring:message code="label.welcome" />
							<c:out value="${name}" />
						</h1>
					</div>
				</div>
				
				<div class="page-header">
				<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_EMPLEADO','ROLE_SUPERVISOR')">
					<div class="col-md-12" style="margin-bottom: 5vh" >
				       <a class="button mt-20 col-md-3" style="display: flex; flex-direction: row" id="addOptionSimple" href="offersconsulting/editsurvey">
                          <span style="width: 75%">
                             <spring:message code="label.editSurvey"/>
                          </span>
                          <i class="fa fa-send-o" style="width: 25%; position: unset"></i>
                       </a>

                        <a class="button mt-20 col-md-3" id="addOptionCompound" style="display: flex; flex-direction: row" href="offersconsulting/createquestion">
                           <span style="width: 75%">
                              <spring:message code="label.createQuestionTitle"/>
                           </span>
                           <i class="fa fa-send-o" style="width: 25%; position: unset"></i>
                        </a>
                        
                        <a class="button mt-20 col-md-3" id="editinvestorprofile" style="display: flex; flex-direction: row" href="offersconsulting/investorprofile">
                           <span style="width: 75%">
                              <spring:message code="label.investorProfile"/>
                           </span>
                           <i class="fa fa-send-o" style="width: 25%; position: unset"></i>
                        </a>
				   </div>
				</sec:authorize>
				
				</div>
				<div class="row">
					<div class="col-md-4 mt-20">
						<h3>
							<spring:message code="label.yourqueries" />
						</h3>
					</div>
					<div class="col-md-8">
						<div class="btn-group pull-right last-element" role="group">
						<a href="/offersconsulting/newquery" class="button mt-20" >
											<span><spring:message
									code="label.newquery" /></span> <i
											class="fa fa-plus"></i>
										</a>
							
							<a href="/o/logout" class="button mt-20" >
											<span><spring:message
									code="label.closesession" /></span> <i
											class="fa fa-sign-out"></i>
										</a>
						
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<table class="table">
							<thead>
								<tr>
									<th><spring:message code="label.querys1" /></th>
									 <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_EMPLEADO','ROLE_SUPERVISOR')"> <th>Email</th> </sec:authorize>
									<th><spring:message code="label.topic" /></th>
									<th><spring:message code="label.creationDate" /></th>
									<th><spring:message code="label.querys3" /></th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="listValue" items="${lists}">
								<c:choose>
								<c:when test="${listValue.status == 'Contestada' }">
									<tr style="background-color:#bec4ce">
								</c:when>
								<c:otherwise>
								<tr>
								</c:otherwise>
								</c:choose>
									
										<td><a
											href="/offersconsulting/querypage?id=<c:out value="${listValue.id}"/>"><c:out
													value="${listValue.id}" /></a></td>
													 <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_EMPLEADO','ROLE_SUPERVISOR')"> <td>${listValue.email}</td> </sec:authorize>
													<td><c:out value="${listValue.offerMatter}" /></td>
										<td><c:out value="${listValue.creationDate}" /></td>
										<td><c:out value="${listValue.status}" /></td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
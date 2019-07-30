<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="description"
         content="Buscador de ULe-Bank. Busca contenido en ULe-Bank.">
      <meta name="keywords" content="ULe-Bank, buscador, contenidos">
      <meta name="author"
         content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu, Diego Ordóñez, David Fernandez">
      <meta name="robots" content="index,follow">
      <meta name="google-signin-client_id"
         content="412665771229-fiplfjnpg26j63hut5bdc3vnd7s5spah.apps.googleusercontent.com">
      <meta name="viewport"
         content="width=device-width, initial-scale=1, maximum-scale=1" />
      <link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
      <link rel="stylesheet"
         href="<c:url value="/resources/services/css/font-awesome/css/font-awesome.min.css"/>" >
      <link rel="stylesheet"
         href="<c:url value="/resources/services/css/styles-responsive.css"/>" >
      <link rel="stylesheet"
         href="<c:url value="/resources/services/css/font-awesome/css/font-awesome.min.css"/>" >
      <link rel="stylesheet"
         href="<c:url value="/resources/services/css/styles-responsive.css"/>" >
      <script src="<c:url value="/resources/services/js/jquery.min.js"/>"></script>
      <script src="<c:url value="/resources/services/js/jquery-cookie.js"/>"></script>
      <script src="<c:url value="/resources/services/js/Chart.js"/>"></script>
      <!-- Favicon -->
      <link rel="shortcut icon" href="../favicon.ico" />
      <!-- bootstrap -->
      <link href="<c:url value="/resources/template/css/bootstrap.min.css"/>" rel="stylesheet"
         type="text/css" />
      <!-- plugins -->
      <link href="<c:url value="/resources/template/css/plugins-css.css"/>" rel="stylesheet"
         type="text/css" />
      <!-- mega menu -->
      <link href="<c:url value="/resources/template/css/mega-menu/mega_menu.css"/>" 
         rel="stylesheet" type="text/css" />
      <!-- default -->
      <link href="<c:url value="/resources/template/css/default.css"/>" rel="stylesheet"
         type="text/css" />
      <!-- main style -->
      <link href="<c:url value="/resources/template/css/style.css"/>" rel="stylesheet"
         type="text/css" />
      <!-- responsive -->
      <link href="<c:url value="/resources/template/css/responsive.css"/>" rel="stylesheet"
         type="text/css" />
      <!-- custom style -->
      <link href="<c:url value="/resources/template/css/custom.css"/>"  rel="stylesheet"
         type="text/css" />
      <title>
         <spring:message code="label.investorProfile" />
      </title>
      
      <!-- GOOGLE ANALYTICS TRACKER -->

      <!-- Inicializar el objeto GoogleAuth para Google SignIn -->

   </head>
   <div class="page-wrapper">
      <!--=================================
         preloader -->
      <div id="preloader">
         <div class="clear-loading loading-effect">
            <span></span>
         </div>
      </div>
      <!--=================================
         header -->
      <jsp:include page="/WEB-INF/views/header.jsp" />
      <!--=================================
         header -->
            <!--=================================
         mega menu -->
      <!--=================================
         inner-intro-->
      <section class="inner-intro bg-office bg-opacity-black-70">
         <div class="container">
            <div class="row text-center intro-title">
               <h1 class="text-blue">
                  <spring:message code="label.investorProfile" />
               </h1>
               <ul class="page-breadcrumb">
                  <li>
                     <a href="/">
                        <i class="fa fa-home"></i> 
                        <spring:message
                           code="label.sitehome" />
                     </a>
                     <i class="fa fa-angle-double-right"></i>
                  </li>
						<li><span><a href="/offersconsulting"><spring:message code="label.siteservice3" /></a> <i class="fa fa-angle-double-right"></i></span></li>

                  <li>
                     <spring:message code="label.investorProfile" />
                  </li>
               </ul>
            </div>
         </div>
      </section>
      <!--=================================
         inner-intro-->
      <section class="faq white-bg page-section-ptb">
         <div class="container">
            <div class="row col-md-10 col-md-offset-1">
               <div class="login-2-form clearfix" style="margin-bottom: 5vh">
    			<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_EMPLEADO','ROLE_SUPERVISOR')">
                    <div class="col-md-12" style="margin-bottom: 5vh">
                      <a class="button mt-20 col-md-5" id="editinvestorprofile" style="display: flex; flex-direction: row" href="editinvestorprofile">
                           <span style="width: 75%">
                              <spring:message code="label.editInvestorProfile"/>
                           </span>
                           <i class="fa fa-send-o" style="width: 25%; position: unset"></i>
                        </a>
					</div>
                  	<span>
                        <spring:message code="label.investorProfile"/>
                     </span>
	                   <c:forEach items="${investorProfile.getRanges()}" var="ranges" varStatus="loop">
                       		<div class="col-md-12" style="margin-top: 2%">
		                      	<div style="display:flex; direction:row" class="col-md-4">
		                      		<input style="background-color:#dbdbdb" value=${ ranges[0] }  type="number" readonly>
		                      		<input style="background-color:#dbdbdb"  value=${ ranges[1] }  type="number" readonly>
		                      	</div>
	                      		<input style="background-color:#dbdbdb" class="col-md-6" value="${ investorProfile.getTypes().get(loop.index) }" type="text" readonly>
	                      	</div>
						</c:forEach>
						<c:if test="${ investorProfile.getRanges().size() == 0}">
							<div class="col-md-12" style="margin-top: 2%">
								<p> </p>
							</div>
						</c:if>
               </sec:authorize>
               </div>
            </div>
         </div>
      <!--=================================
         Footer-->
      <jsp:include page="/WEB-INF/views/footer.jsp" />
      <!--=================================
         Footer-->
      </section>
   <script src="<c:url value="/resources/services/js/tooltip-script.js"/>" ></script>
   <!-- bootstrap -->
   <script type="text/javascript"
      src="<c:url value="/resources/template/js/bootstrap.min.js"/>"></script>
   <!-- plugins-jquery -->
   <script type="text/javascript"
      src="<c:url value="/resources/template/js/plugins-jquery.js"/>"></script>
   <!-- mega menu -->
   <script type="text/javascript"
      src="<c:url value="/resources/template/js/mega-menu/mega_menu.js"/>"></script>
   <!-- custom -->
   <script type="text/javascript" src="<c:url value="/resources/template/js/custom.js"/>"></script>
   </div>
 </html>
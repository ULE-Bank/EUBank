<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="description"
         content="Buscador de ULe-Bank. Busca contenido en ULe-Bank.">
      <meta name="keywords" content="ULe-Bank, buscador, contenidos">
      <meta name="author"
         content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu">
      <meta name="robots" content="index,follow">
      <meta name="google-signin-client_id"
         content="412665771229-fiplfjnpg26j63hut5bdc3vnd7s5spah.apps.googleusercontent.com">
      <meta name="viewport"
         content="width=device-width, initial-scale=1, maximum-scale=1" />
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
      <title>
         <spring:message code="label.officeLogin" />
      </title>
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
      <!-- Inicializar el objeto GoogleAuth para Google SignIn -->
      <script>
         function start() {
         	gapi
         			.load(
         					'auth2',
         					function() {
         						auth2 = gapi.auth2
         								.init({
         									client_id : '412665771229-fiplfjnpg26j63hut5bdc3vnd7s5spah.apps.googleusercontent.com',
         								// Scopes to request in addition to 'profile' and 'email'
         								//scope: 'additional_scope'
         								});
         					});
         }
      </script>
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
         preloader -->
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
                   <spring:message code="label.officeLogin" />
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
                  <li>
                      <spring:message code="label.officeLogin" />
                  </li>
               </ul>
            </div>
         </div>
      </section>
      <!--=================================
         inner-intro-->
	<section class="faq white-bg page-section-ptb">
		<div class="container">
			<div class="row col-md-6 col-md-offset-3">
				<div class="login-2-form clearfix">

					<!--                Definición de contenido -->
					<sec:authorize access="hasRole('ROLE_ADVISORUSER')" var="isUser" />
					<sec:authorize
						access="hasAnyRole('ROLE_EMPLEADO','ROLE_ADMIN','ROLE_SUPERVISOR')"
						var="isUlebankEmployee" />
					<c:choose>
						<c:when test="${isUser}">Para acceder a la oficina debe cerrar sesión en el consultor financiero<br>


							<form:form action="/o/logout" method="POST">
								<input type="submit" value="Logout" />
							</form:form>
						</c:when>
						<c:when test="${isUlebankEmployee}">Ya has iniciado sesión.
						<a href="/o">Volver a la oficina</a>
							<a href="/o/logout">Cerrar sesión</a>
						</c:when>
						<c:otherwise>
							<form name="f"
								action="<c:url value="j_spring_security_check"></c:url>"
								method="POST">
								<c:if test="${not empty param.login_error}">
									<div style="color: red">
										<spring:message code="label.failedLoginMessage" />
									</div>
								</c:if>
								<div class="section-field">
									Username:
									<div class="field-widget">
										<i class="fa fa-user"></i> <input type='text'
											name='j_username' />
									</div>
								</div>
								<div class="section-field">
									Password:
									<div class="field-widget">
										<i class="fa fa-unlock-alt"></i> <input type='password'
											name='j_password'>
									</div>
								</div>
								<div class="section-field">
									<div class="field-widget">
										<i class="fa fa-check"></i> <input value='<spring:message code="label.submit"/>' name="submit"
											type="submit">
									</div>
								</div>
								<div class="section-field">
									<div class="field-widget">
										<i class="fa fa-trash"></i> <input value='<spring:message code="label.clean"/>' name="reset"
											type="reset">
									</div>
								</div>
							</form>
						</c:otherwise>
					</c:choose>
					<!--                Definición de contenido -->

				</div>
			</div>
		</div>
	</section>
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
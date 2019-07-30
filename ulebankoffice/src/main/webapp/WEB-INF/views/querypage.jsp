<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        
        <title><spring:message code="label.query" /> ${idQuery}</title>
        
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
						<li><a href="/"><i class="fa fa-home"></i> <spring:message
									code="label.sitehome" /></a> <i class="fa fa-angle-double-right"></i></li>
						<li><span><a href="/offersconsulting"><spring:message code="label.siteservice3" /></a> <i class="fa fa-angle-double-right"></i></span></li>
						<li><span><spring:message code="label.query" /> ${idQuery}</span></li>		
					</ul>
				</div>
			</div>
		</section>

		<!--=================================
 inner-intro-->
 
 
   
        <section class="white-bg pt-40">
			<div class="container">
			<div class="row">
				<div class ="col-md-3">
				<h4>Autor:</h4> <p>${inquiryAuthor}</p>
				</div> 
				<div class ="col-md-4">
				<h4>Asunto:</h4> <p>${offerMatter}</p> 
				</div>
				<div class ="col-md-3">
				<c:if test="${fileLink != '/offersconsulting/querypage/serve?id=null' }"><h4>Archivo adjunto: </h4><a href="${fileLink}" target="_blank"> Enlace archivo </a></c:if>
				</div>
				<div class ="col-md-2">
				<h4>Fecha creación:</h4> <p>${creationDate}</p> 
				</div>
			</div>
			  <sec:authorize access="hasRole('ROLE_ADMIN')">
			<div class="row"  >
			<div class="col-md-1" style="border: 2px solid #ff0000" >
				<a href="/offersconsulting/querypage/e?id=${idQuery}">Eliminar</a>
			</div>
			</div>
				</sec:authorize>
				<h4>Url oferta:</h4> <p><a href="${offerUrl}" target="_blank">${offerUrl}</a></p>
				
				<h4>Comentarios del autor de la consulta:</h4> <p style="text-align: justify;"> ${offerText}</p>
				
				<h4>Respuesta:</h4> <pre style="white-space:pre-wrap;">${offerResponse}</pre>
			
				 <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_EMPLEADO','ROLE_SUPERVISOR')">
				 <fieldset>
				 <form:form
							action="/offersconsulting/querypage?id=${param.id}"
							role="form" method="post"
							id="servicesform" >
				 <h4>Resultado del usuario ${inquiryAuthor} del test: </h4>
				 <input type="number" id="scoreTest" name="scoreTest" value="${testScore}" readonly/>
				 
				 <h4>Perfil de ${inquiryAuthor}: </h4>
				 <input type="text" id="profileTest" name="profileTest" value="${testProfile}" readonly/>
				 <h4>Escribir o modificar respuesta: </h4>
				  
				
				  
							<div id="register-form" class="register-form">
							
							<textarea id="response" name="response" rows="8" placeholder="Aquí se debe escribir la respuesta." >${offerResponse}</textarea>
							<div class="col-md-3">
							<input type="submit"  style="border: 3px solid #ff0000" value="<spring:message code="label.update"/>">
							</div>
							</div>
							</form:form>
			
				  </fieldset>
				 </sec:authorize>
				
				
				</div>
					
				<div class="row col-md-8">
								<div class="btn-group pull-right last-element" role="group">
						<a href="/offersconsulting" class="button mt-20" >
											<span><spring:message
									code="label.myqueries" /></span> <i
											class="fa fa-list-ol"></i>
										</a>
							
							<a href="/o/logout" class="button mt-20" >
											<span><spring:message
									code="label.closesession" /></span> <i
											class="fa fa-sign-out"></i>
										</a>
						
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
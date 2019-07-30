<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="description"
         content="Buscador de ULe-Bank. Busca contenido en ULe-Bank.">
      <meta name="keywords" content="ULe-Bank, buscador, contenidos">
      <meta name="author"
         content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu, Diego Ordóñez">
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
         <spring:message code="label.survey" />
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
                  <spring:message code="label.survey" />
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
                     <spring:message code="label.survey" />
                  </li>
               </ul>
            </div>
         </div>
      </section>
      <!--=================================
         inner-intro-->
      <section class="faq white-bg page-section-ptb">
         <c:if test="${emptyQuestions}">
            <div class="row col-md-10 col-md-offset-1" style="text-align: center; margin-bottom: 1%">
               <span style="color: red"> <spring:message code="label.emptyQuestions"/> </span>   
            </div>
         </c:if>
         <div class="container">
            <div class="row col-md-10 col-md-offset-1">
               <div class="login-2-form clearfix">
                  <form name="f" action="survey?id=${id}" method="POST">
                     <div class="section-field">
                        <div class="field-widget" style="text-align:justify;">
	                       	<c:forEach items="${listQuestions}" var="question">
	                       		<div class="section-field" id="q${listQuestions.indexOf(question)}"> 
                                 <div class="field-widget" id="q${listQuestions.indexOf(question)}" style="text-align:left;" >
	                        			<label><b>#${1+listQuestions.indexOf(question)}</b></label>
	                        			<spring:message text="${question.getText()}"/>	
                                 </div>

	                        		<select class="answerselect" id="select-q${question.getId().toString()}" name="select-q${question.getId().toString()}" required>
                                    <option value="empty"><spring:message code="label.select"/></option>   
                                    <c:forEach items="${question.getOptions()}" var="answer">
                                       <option value='${answer.getId().toString()}'> ${answer.getText()} </option>
	                          			</c:forEach>
                                 </select>

                                 <c:forEach items="${question.getOptions()}" var="answer">
                                    <c:if test="${answer.getOptions().size() > 0}">
                                       <div class="subAnswerDiv subAnswerQuestion-${answer.getId().toString()}" style="display: none; margin-left: 5%">
                                          <select class="subanswerselect" id="select-q${question.getId().toString()}-a${answer.getId().toString()}" name="select-q${question.getId().toString()}-a${answer.getId().toString()}">
                                                <option value="empty"><spring:message code="label.select"/></option>
                                             <c:forEach items="${answer.getOptions()}" var="subAnswer">
                                                <option value='${subAnswer.getId().toString()}'>${subAnswer.getText()}</option>
                                             </c:forEach>
                                          </select>
                                       </div>
                                    </c:if> 
                                 </c:forEach>

	                       		</div>
				               </c:forEach>
                        </div>
                     </div>
                     <div class="section-field" style="margin-bottom: 5vh">
                        <input id="sendFormSurvey" style="display: none" name="submit" type="submit">
                        <a class="button mt-20 col-md-12" id="submitsurvey" onclick="document.getElementById('sendFormSurvey').click()">
                           <span style="margin-left: 43%">
                              <spring:message code="label.save"/>
                           </span>
                           <i class="fa fa-send-o" style="position: absolute; right: 0px"></i>
                        </a>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      <!--=================================
         Footer-->
      <jsp:include page="/WEB-INF/views/footer.jsp" />
      <!--=================================
         Footer-->
      </section>
   <script>
      $(".answerselect").change(function() {
         $(this).parent('.section-field').children('.subAnswerDiv').hide()
         $('.subAnswerQuestion-' + $(this).val()).toggle()
      });
   </script>
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
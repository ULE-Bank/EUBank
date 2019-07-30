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
         <spring:message code="label.createQuestionTitle" />
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
                  <spring:message code="label.createQuestionTitle" />
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
                     <spring:message code="label.createQuestionTitle" />
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
               <div class="login-2-form clearfix">
    			<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_EMPLEADO','ROLE_SUPERVISOR')">
                  <form name="f" action="createquestion" method="POST">
                     <div class="section-field">
                        <div class="field-widget">
	                       	<span>
                              <spring:message code="label.createQuestionTitleForm"/>
                           </span>
                           <input name="total-simple" value= 0 id="total-simple" type=number style="display: none">
                           <input name="total-compound" value = 0 id="total-compound" type=number style="display:none">
                           <input name="question-text" id="question-text" type="text" style="background-color: lightgrey" required>
                           <div class="addOption-div">
                              <a class="button mt-20 col-md-3" style="display: flex; flex-direction: row" id="addOptionSimple" onclick="return false;">
                                 <span style="width: 75%">
                                    <spring:message code="label.addOptionSimple"/>
                                 </span>
                                 <i class="fa fa-send-o" style="width: 25%; position: unset"></i>
                              </a>

                              <a class="button mt-20 col-md-3" id="addOptionCompound" style="display: flex; flex-direction: row" onclick="return false;">
                                 <span style="width: 75%">
                                    <spring:message code="label.addOptionCompound"/>
                                 </span>
                                 <i class="fa fa-send-o" style="width: 25%; position: unset"></i>
                              </a>
                           </div>
                        </div>
                     </div>
                     <div class="section-field col-md-12" style="padding:0px">
                        <input id="sendFormQuestion" style="display: none" name="submit" type="submit">
                          <a class="button mt-20 col-md-3" id="send" style="display: flex; flex-direction: row" onclick="document.getElementById('sendFormQuestion').click()">
                          
                              <span style="width: 75%">
                                 <spring:message code="label.save"/>
                              </span>
                              <i class="fa fa-send-o" style="width: 25%; position: unset"></i>
                         </a>
                     </div>
                  </form>
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
   <script>
   	  var totalOptionsSimple = 0
   	  var totalOptionsCompound = 0
	  function addSimpleFromCompound(component) {
    	  var associatedCompound = $("#" + component.id).attr('id');
    	  var valueCompound = associatedCompound.substring(associatedCompound.length - 1, associatedCompound.length);
		  $("#" + component.id).parent().append('<div class="mt-20 col-md-12"> <span class="col-md-12"><spring:message code="label.addOptionSimple"/></span><br><br><input name="option-compound-'+valueCompound+'-simple-' + $("#total-simple-compound-" + valueCompound).val() + '" id="option-compound-'+valueCompound+'-simple-' + $("#total-simple-compound-" + valueCompound).val() + '" type="text" style="width: 84%; background-color: lightgrey" required>  <input id="option-compound-' + valueCompound +'-simple-'+ $("#total-simple-compound-" + valueCompound).val() + '-value" name="option-compound-' + valueCompound +'-simple-'+ $("#total-simple-compound-" + valueCompound).val() + '-value" type="number" min=0 step="0.01" placeholder="0,0" style="width: 15%; text-align: left; background-color: lightgrey" required> </div>');
    	  $("#total-simple-compound-" + valueCompound).val(parseInt($("#total-simple-compound-" + valueCompound).val()) + 1);

   	  }
   	  
      $("#addOptionSimple").click(function() {
    	  $(this).parent().append('<div class="mt-20 col-md-12"> <span class="col-md-12"><spring:message code="label.addOptionSimple"/></span><br><br><input name="option-simple-' + totalOptionsSimple + '" id="option-simple-' + totalOptionsSimple + '" type="text" style="width: 84%; background-color: lightgrey" required>  <input id="option-simple-'+ totalOptionsSimple +'-value" name="option-simple-'+ totalOptionsSimple +'-value" type="number" min=0 step="0.01" placeholder="0,0" style="width: 15%; text-align:left; background-color: lightgrey" required> </div>');
	   	  totalOptionsSimple += 1;
    	  $("#total-simple").val(totalOptionsSimple);


      });

      $("#addOptionCompound").click(function() {
          $(this).parent().append('<div class="mt-20 col-md-12"> <span class="col-md-12"> <spring:message code="label.addOptionCompound"/></span><br><br><input type=number name="total-simple-compound-'+totalOptionsCompound+'" id="total-simple-compound-'+totalOptionsCompound+'" style="display:none"> <input name="option-compound-' + totalOptionsCompound + '" id="option-compound-' + totalOptionsCompound + '" type="text" style="background-color: lightgrey" required> <a class="button mt-10" id="button-'+totalOptionsCompound+'" style="width:27%; display: flex; flex-direction: row" onclick="addSimpleFromCompound(this)"><span style="width: 75%"><spring:message code="label.addOptionSimple"/></span><i class="fa fa-send-o" style="width: 25%; position: unset"></i></a></div>');
      	  $("#total-simple-compound-" + totalOptionsCompound).val(0);
    	  totalOptionsCompound += 1;
    	  $("#total-compound").val(totalOptionsCompound);

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
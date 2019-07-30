<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="description" content="Cálculo de TAE Varios tipos de interés.">
      <meta name="keywords"
         content="ULe-Bank, calculos, tae, tasa, anual, equivalente">
      <meta name="author"
         content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu">
      <meta name="robots" content="index,follow">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
      <jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="<spring:message code='label.siteservice1-2' />" />
      <meta property="og:url" content="http://ulebank.unileon.es/apr" />
      <meta property="og:description" content="<spring:message code='label.siteservice1-2description'/>"/>
      <link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
      <!-- <link rel="stylesheet" href="/resources/services/css/bootstrap.min.css"> -->
      <link rel="stylesheet"
         href="/resources/services/css/font-awesome/css/font-awesome.min.css">
      <link rel="stylesheet"
         href="/resources/services/css/styles-responsive.css">
      <script src="/resources/services/js/jquery.min.js"></script>
      <!-- <script src="/resources/services/js/bootstrap.min.js"></script> -->
      <script src="/resources/services/js/jquery-cookie.js"></script>
      <script src="/resources/services/js/script.js"></script>
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
      <title>
         <spring:message code="label.siteservice1-2" />
      </title>
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
            class="inner-intro grayscale bg-services-apr bg-opacity-black-70">
            <div class="container">
               <div class="row text-center intro-title">
                  <h1 class="text-blue">
                     <spring:message code="label.siteservice1-2" />
                  </h1>
                  <p class="text-white">
                     <spring:message code="label.siteservice1-2description" />
                  </p>
                  <ul class="page-breadcrumb">
                     <li>
                        <a href="./">
                           <i class="fa fa-home"></i> 
                           <spring:message
                              code="label.sitehome" />
                        </a>
                        <i class="fa fa-angle-double-right"></i>
                     </li>
                     <li>
                        <a href="/a/services">
                           <spring:message
                              code="label.siteservices" />
                        </a>
                        <i
                           class="fa fa-angle-double-right"></i>
                     </li>
                     <li>
                        <span>
                           <spring:message code="label.siteservice1-2" />
                        </span>
                     </li>
                  </ul>
               </div>
            </div>
         </section>
         <!--=================================
            inner-intro-->
         <!--=================================
            Register-->
         <section class="white-bg page-section-ptb">
            <div class="container">
               <div class="row">
                  <div class="col-md-6 col-md-offset-2">
                     <form:form role="form" method="post" modelAttribute="taeDataSeveralInterests"
                        id="servicesform">
                        <div id="register-form" class="register-form">
                           <div class="row">
                              <div class="section-field col-md-8">
                                 <label for="name">
                                    <spring:message
                                       code="label.period" />
                                 </label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="section-field col-md-8">
                                 <div class="field-widget">
                                    <spring:message code="label.annual" var="variable1" />
                                    <spring:message code="label.biannual" var="variable2" />
                                    <spring:message code="label.cuatrimestral" var="variable3" />
                                    <spring:message code="label.quarterly" var="variable4" />
                                    <spring:message code="label.bimonthly" var="variable5" />
                                    <spring:message code="label.monthly" var="variable6" />
                                    <form:select path="period" id="periodSelection">
                                       <form:option value="1" label="1 - ${variable1}" />
                                       <form:option value="2" label="2 - ${variable2}" />
                                       <form:option value="3" label="3 - ${variable3}" />
                                       <form:option value="4" label="4 - ${variable4}" />
                                       <form:option value="6" label="6 - ${variable5}" />
                                       <form:option value="12" label="12 - ${variable6}" />
                                    </form:select>
                                 </div>
                              </div>
                              <div class="section-field col-md-1 pl-0">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.typeofperiodinfo"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row">
                              <div class="section-field col-md-8">
                                 <h2>
                                    <spring:message
                                       code="label.aprvariosinterestsinfo" />
                                 </h2>
                              </div>
                           </div>
                           <div class="row">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 1 <form:errors style="color: red;" path="interests[0].interest"></form:errors>
                                 
                                 </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input path="interests[0].interest" required="required" />
                                 </div>
                              </div>
                              <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 2  <form:errors style="color: red;" path="interests[1].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[1].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 3 <form:errors style="color: red;" path="interests[2].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[2].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 4  <form:errors style="color: red;" path="interests[3].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[3].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 5 <form:errors style="color: red;" path="interests[4].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[4].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 6 <form:errors style="color: red;" path="interests[5].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[5].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 7 <form:errors style="color: red;" path="interests[6].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[6].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 8 <form:errors style="color: red;" path="interests[7].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[7].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 9 <form:errors style="color: red;" path="interests[8].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[8].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 10 <form:errors style="color: red;" path="interests[9].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[9].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 11 <form:errors style="color: red;" path="interests[10].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[10].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="row TAESeveralInterestsType">
                              <div class="section-field col-md-8">
                                 <spring:message code="label.period"/>
                                 12 <form:errors style="color: red;" path="interests[11].interest"></form:errors>
                                  </div>
                                 <div class="row col-md-8 ml-0">
                                 <div class="field-widget">
                                    <i class="fa fa-percent"></i>
                                    <form:input type="text" name="name" path="interests[11].interest" required="required" />
                                 </div>
                              </div>
                               <div class="section-field col-md-1">
                                 <span class="tooltip-content text-blue"
                                    data-original-title="<spring:message code="label.nominalinteresttype"/>"
                                 data-toggle="tooltip" data-placement="top"><i
                                    class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
                              </div>
                           </div>
                           <div class="bg-info">
                              <h3>
                                 <c:out value="${model.resultado}" />
                              </h3>
                           </div>
                           <div class="row">
                              <div class="section-field col-md-8">
                                 <div class="row text-center intro-title">
                                    <p class="modal-link last-element">
                                       <a href="#" data-toggle="modal"
                                          data-target="#modalExplicativo">
                                          <spring:message
                                             code="label.whatisapr" />
                                       </a>
                                    </p>
                                 </div>
                                 <a class="button mt-20" id="submitservices"
                                    onclick="document.getElementById('servicesform').submit()">
                                    <span>
                                       <spring:message code="label.calculate" />
                                    </span>
                                    <i
                                       class="fa fa-calculator"></i>
                                 </a>
                                 <!-- En caso de que algún usuario tenga desactivado javascript, saldrá este mensaje por defecto. -->
                                 <noscript>
                                    <input type="submit"
                                       value="<spring:message code="label.calculate"/>" />
                                 </noscript>
                              </div>
                           </div>
                        </div>
                     </form:form>
                  </div>
                  <!-- 					Descripción lateral  -->
					<div class="col-md-4" >
					<p style="text-align: justify;"><spring:message code="label.aprlateral" /></p>
						
					</div>
               </div>
            </div>
         </section>
         <!--=================================
            Register-->
         <!--=================================
            Footer-->
         <jsp:include page="/WEB-INF/views/footer.jsp" />
         <!--=================================
            Footer-->
         <!-- Modal -->
         <div class="modal fade" id="modalExplicativo" tabindex="-1"
            role="dialog" aria-labelledby="modalExplicativoLabel">
            <div class="modal-dialog modal-lg" role="document">
               <div class="modal-content">
                  <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                     </button>
                     <h4 class="modal-title" id="modalExplicativoLabel">
                        <spring:message code="label.whatisaprtitle" />
                     </h4>
                  </div>
                  <div class="modal-body" style="text-align: justify;">
                     <p><spring:message code="label.whatisaprbody" /></p>
                     <p><spring:message code="label.whatisapr1" /></p>
                     <p><spring:message code="label.whatisapr2" /></p>
                     <p><spring:message code="label.whatisapr3" /></p>
                  </div>
                  <div class="modal-footer">
                     <button type="button" data-dismiss="modal">
                        <spring:message code="label.close" />
                     </button>
                  </div>
               </div>
            </div>
         </div>
         <!-- Fin Modal -->
         <!-- MODAL RESULTADOS -->
         <div class="modal fade" id="modalResultados" tabindex="-1"
            role="dialog" aria-labelledby="modalResultadosLabel">
            <div class="modal-dialog modal-lg" role="document">
               <div class="modal-content">
                  <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                     </button>
                     <h4 class="modal-title" id="modalResultadosLabel">
                        <spring:message code="label.simulationresult" />
                     </h4>
                  </div>
                  <div class="modal-body">
                     <table class="table">
                        <tr class="text-center">
                           <td>
                              <h3>
                                 <spring:message code="label.APR"/>
                                 ${TAE} %
                              </h3>
                           </td>
                        </tr>
                     </table>
                  </div>
               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">
                     <spring:message code="label.close" />
                  </button>
               </div>
            </div>
         </div>
         <!-- FIN MODAL RESULTADOS -->
      </div>
      <script>
         
      /* Script to show or hide the fields of the interests*/
         
         var selection = $("#periodSelection");
         // I select all elements in the class TAESeveralInterestsPOJO. They are 11 because the first one is always shown.
         var interestsArray = $(".TAESeveralInterestsType");
         // When the page loads, I check the selected value and show only those ones.
         if(selection.val() > 1){
         $.each(interestsArray, function(index) {
         			if (index >= selection.val()-1) {
         				interestsArray.eq(index).hide();
         			}
         		});
         } else interestsArray.hide();
         // When a change is made in the selection of the period, I check the value and show that amount of fields.
         selection.change(function() {
         	if (selection.val() == 12) {
         		interestsArray.show(500);
         	} else if (selection.val() == 1) {
         		interestsArray.hide(500);
         	} else if (selection.val() == 6) {
         		hideShowFields(5);
         	} else if (selection.val() == 2) {
         		hideShowFields(1);
         	} else if (selection.val() == 3) {
         		hideShowFields(2);
         	} else if (selection.val() == 4) {
         		hideShowFields(3);
         	}
         })
         
         function hideShowFields(num){

			/*
			 * The algorithm is made in a way that doesn't look bad when all elements all reloaded.
			 * It's better to make a .hide() over the whole array and show only the 2, 3 or 6 first elements,
			 * but the thing mentioned before occurs.
			 */
         	
         	$.each(interestsArray, function(index) {
         		if (index < num) {
         			interestsArray.eq(index).show(500);
         		} else {
         			interestsArray.eq(index).hide(500);
         		}
         	});
         }
         
      </script>
      <script src="/resources/services/js/tooltip-script.js"></script>
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
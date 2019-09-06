<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" import="java.util.*,java.lang.*" %> 

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
                  <spring:message code="label.editQuestion" />
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
                  </li>
						<li><span><a href="/offersconsulting/editsurvey"><spring:message code="label.editSurvey" /></a> <i class="fa fa-angle-double-right"></i></span></li>

                  <li>
                     <spring:message code="label.editQuestion" />
                  </li>
               </ul>
            </div>
         </div>
      </section>
      <!--=================================
         inner-intro-->
      <%! int nCompounds = 0; %>
	  <%! int nSimples = 0; %>
	  <%! int currentSimplesCompound = 0; %>
	  <%! int total = 0; %>
	  
	  <% nSimples = 0; %>
	  <% nCompounds = 0; %>
	  <% currentSimplesCompound = 0; %>
	  <% total = 0; %>
	  
      <section class="faq white-bg page-section-ptb">
         <div class="container">
            <div class="row col-md-10 col-md-offset-1">
               <div class="login-2-form clearfix">
              <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_EMPLEADO','ROLE_SUPERVISOR')">
               
                  <form name="f" action="editquestion" method="POST">
                     <div class="section-field">
                        <div class="field-widget">
                	       <span>
                           	<spring:message code = "label.position"></spring:message>
                           </span>
                           <div class="col-md-12" style="margin:0px; padding:0px">
                            <input style="background-color: lightgrey" class="mt-20 col-md-2" type="number" name="question-position" id="question-position" min="1" max="${maxPosition}" value="${question.getPosition()}" required>
	                       	</div>
	                       	<br>
	                       	<span>
                              <spring:message code="label.createQuestionTitleForm"/>
                           </span>
                           <input name="question-text" id="question-text" type="text" style="background-color: lightgrey" value="${question.getText() }" required>
						   <input name="question-id" id="question-id" type="text" style="background-color: lightgrey; display:none" value="${question.getId()}">
                           
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
                             
                           <c:forEach items="${question.getOptions()}" var="option">
    							<c:choose>
								  <c:when test="${option.getOptions().size() > 0}">
		
									  <div class="mt-20 col-md-12" id="div-option-<%=total%>"> 
										  <span class="col-md-12"> 
										  	<spring:message code="label.addOptionCompound"/>
										  </span><br><br>
										  <input name="option-compound-<%=nCompounds%>" id="option-compound-<%=nCompounds%>" type="text" style="background-color: lightgrey; width: 80%" value="${option.getText()}"required> 
										  <button class="button" style="display:flex;flex-direction:row;float:left" onclick="deleteNodeCompound('div-option-<%=total%>')"><span style="font-weight:bold;text-align:center">X</span></button>
										  <a class="button mt-10" id="button-<%=nCompounds%>" style="width:27%; display: flex; flex-direction: row" onclick="addSimpleFromCompound(this)">
											  <span style="width: 75%">
											  	<spring:message code="label.addOptionSimple"/>
											  </span>
											  <i class="fa fa-send-o" style="width: 25%; position: unset"></i>
										  </a>
	                           			
	                           			<% total += 1; %>
										
										<c:forEach items="${option.getOptions()}" var="subOption">
											<div class="mt-20 col-md-12" id="div-option-<%=total%>"> 
												<span class="col-md-12">
													<spring:message code="label.addOptionSimple"/>
												</span><br><br>
												<input name="option-compound-<%=nCompounds%>-simple-<%=currentSimplesCompound%>" id="option-compound-<%=nCompounds%>-simple-<%=currentSimplesCompound%>" type="text" style="width: 70%; background-color: lightgrey" value="${subOption.getText()}" required> 
											    <input id="option-compound-<%=nCompounds%>-simple-<%=currentSimplesCompound%>-value" name="option-compound-<%=nCompounds%>-simple-<%=currentSimplesCompound%>-value" type="number" min=0 step="0.01" placeholder="0,0" style="width: 15%; text-align:left; background-color: lightgrey" value="${subOption.getWeight()}" required> 
												<button class="button" style="display:flex;flex-direction:row;float:left" onclick="deleteNodeSimpleFromCompound('div-option-<%=total%>', <%=nCompounds%>)"><span style="font-weight:bold;text-align:center">X</span></button>
											</div>
			                          	 <% currentSimplesCompound += 1; %>
	                           			 <% total += 1; %>
										</c:forEach>
										<input type=number name="total-simple-compound-<%=nCompounds%>" id="total-simple-compound-<%=nCompounds%>" value=<%= currentSimplesCompound%> style="display:none"> 
										
									  </div>
									  <% currentSimplesCompound = 0; %>
	                           		  <% nCompounds += 1; %>


								  </c:when>
								  <c:otherwise>
								    <div class="mt-20 col-md-12" id="div-option-<%=total%>"> 
								    	<span class="col-md-12">
								    		<spring:message code="label.addOptionSimple"/>
								    	</span><br><br>
								    	<input name="option-simple-<%=nSimples%>" id="option-simple-<%=nSimples%>" type="text" style="width: 70%; background-color: lightgrey" value="${option.getText()}"required>  
								    	<input id="option-simple-<%=nSimples%>-value" name="option-simple-<%=nSimples%>-value" type="number" min=0 step="0.01" placeholder="0,0" style="width: 15%; text-align:left; background-color: lightgrey" value="${option.getWeight()}"required> 
								    	<button class="button" style="display:flex;flex-direction:row;float:left" onclick="deleteNodeSimple('div-option-<%=total%>')"><span style="font-weight:bold;text-align:center">X</span></button>
								    	</div>
                           			<% nSimples+= 1; %>
                           			<% total += 1; %>
								  </c:otherwise>
								</c:choose>
							</c:forEach>
							<input name="total-simple" value=<%=nSimples%> id="total-simple" type=number style="display: none">
                            <input name="total-compound" value =<%=nCompounds%> id="total-compound" type=number style="display:none">
                           </div>
                        </div>
                     </div>
                     
                     <div class="section-field">
                        <input id="sendFormQuestion" style="display: none" name="submit" type="submit"> 
                        <a class="button mt-20 col-md-12" id="submitquestion" style="display: flex; flex-direction: row" onclick="document.getElementById('sendFormQuestion').click()">
                           <span style="padding-left: 43%">
                              <spring:message code="label.save"/>
                           </span>
                           <i class="fa fa-send-o" style="position: absolute; right: 0px"></i>
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
   	  var totalOptionsSimple = <%= nSimples %>
   	  var totalOptionsCompound = <%= nCompounds %>
	  var totalCounter = <%= total %>
	  
	  $("#total-simple").val(totalOptionsSimple);
	  $("#total-compound").val(totalOptionsCompound);

	  function addSimpleFromCompound(component) {
    	  var associatedCompound = $("#" + component.id).attr('id');
    	  var valueCompound = associatedCompound.substring(associatedCompound.length - 1, associatedCompound.length);
		  $("#" + component.id).parent().append('<div class="mt-20 col-md-12" id = "div-option-' + totalCounter + '"> <span class="col-md-12"><spring:message code="label.addOptionSimple"/></span><br><br><input name="option-compound-'+valueCompound+'-simple-' + totalCounter + '" id="option-compound-'+valueCompound+'-simple-' + totalCounter + '" type="text" style="width: 70%; background-color: lightgrey" required>  <input id="option-compound-' + valueCompound +'-simple-'+ totalCounter + '-value" name="option-compound-' + valueCompound +'-simple-'+ totalCounter + '-value" type="number" min=0 step="0.01" placeholder="0,0" style="width: 15%; text-align: left; background-color: lightgrey" required> <button class="button" style="display:flex;flex-direction:row;float:left" onclick="deleteNodeSimpleFromCompound(\'div-option-'+totalCounter+'\','+valueCompound+')"><span style="font-weight:bold;text-align:center">X</span></button> </div>');
		  $("#total-simple-compound-" + valueCompound).val(parseInt($("#total-simple-compound-" + valueCompound).val()) + 1);
	   	  totalCounter += 1;
	  }
	  
	  function addSimpleToCompound(valueCompound) {
		  $("#" + component.id).parent().append('<div class="mt-20 col-md-12" id = "div-option-' + totalCounter + '"> <span class="col-md-12"><spring:message code="label.addOptionSimple"/></span><br><br><input name="option-compound-'+valueCompound+'-simple-' + $("#total-simple-compound-" + valueCompound).val() + '" id="option-compound-'+valueCompound+'-simple-' + $("#total-simple-compound-" + valueCompound).val() + '" type="text" style="width: 70%; background-color: lightgrey" required>  <input id="option-compound-' + valueCompound +'-simple-'+ $("#total-simple-compound-" + valueCompound).val() + '-value" name="option-compound-' + valueCompound +'-simple-'+ $("#total-simple-compound-" + valueCompound).val() + '-value" type="number" min=0 step="0.01" placeholder="0,0" style="width: 15%; text-align: left; background-color: lightgrey" required> <button class="button" style="display:flex;flex-direction:row;float:left" onclick="deleteNodeSimpleFromCompound(\'div-option-'+totalCounter+'\','+valueCompound+')"><span style="font-weight:bold;text-align:center">X</span></button> </div>');
		  $("#total-simple-compound-" + valueCompound).val(parseInt($("#total-simple-compound-" + valueCompound).val()) + 1);
    	  return $("#total-simple-compound-" + valueCompound).val() - 1;
   	  }
	  
	  function addOptionSimple() {
		  $("#addOptionSimple").parent().append('<div class="mt-20 col-md-12" id = "div-option-' + totalCounter + '"> <span class="col-md-12"><spring:message code="label.addOptionSimple"/></span><br><br><input name="option-simple-' + totalOptionsSimple + '" id="option-simple-' + totalOptionsSimple + '" type="text" style="width: 70%; background-color: lightgrey" required>  <input id="option-simple-'+ totalOptionsSimple +'-value" name="option-simple-'+ totalOptionsSimple +'-value" type="number" min=0 step="0.01" placeholder="0,0" style="width: 15%; text-align:left; background-color: lightgrey" required> <button class="button" style="display:flex;flex-direction:row;float:left" onclick="deleteNodeSimple(\'div-option-'+totalCounter+'\')"><span style="font-weight:bold;text-align:center">X</span></button> </div>');
		  totalOptionsSimple += 1;
    	  $("#total-simple").val(totalOptionsSimple);
    	  return totalOptionsSimple - 1;
 
	  }
   	  
      $("#addOptionSimple").click(function() {
    	  $(this).parent().append('<div class="mt-20 col-md-12" id = "div-option-' + totalCounter + '"> <span class="col-md-12"><spring:message code="label.addOptionSimple"/></span><br><br><input name="option-simple-' + totalOptionsSimple + '" id="option-simple-' + totalOptionsSimple + '" type="text" style="width: 70%; background-color: lightgrey" required>  <input id="option-simple-'+ totalOptionsSimple +'-value" name="option-simple-'+ totalOptionsSimple +'-value" type="number" min=0 step="0.01" placeholder="0,0" style="width: 15%; text-align:left; background-color: lightgrey" required> <button class="button" style="display:flex;flex-direction:row;float:left" onclick="deleteNodeSimple(\'div-option-'+totalCounter+'\')"><span style="font-weight:bold;text-align:center">X</span></button> </div>');
	   	  totalOptionsSimple += 1;
	   	  totalCounter += 1;
    	  $("#total-simple").val(totalOptionsSimple);
      });

      function addCompound() {
    	  $("#addOptionCompound").parent().append('<div class="mt-20 col-md-12" id = "div-option-' + totalCounter + '"> <span class="col-md-12"> <spring:message code="label.addOptionCompound"/></span><br><br><input type=number name="total-simple-compound-'+totalOptionsCompound+'" id="total-simple-compound-'+totalOptionsCompound+'" style="display:none"> <input name="option-compound-' + totalOptionsCompound + '" id="option-compound-' + totalOptionsCompound + '" type="text" style="background-color: lightgrey; width: 88%" required> <button class="button" style="display:flex;flex-direction:row;float:left" onclick="deleteNodeCompound(\'div-option-'+totalCounter+'\')"><span style="font-weight:bold;text-align:center">X</span></button> <a class="button mt-10" id="button-'+totalOptionsCompound+'" style="width:27%; display: flex; flex-direction: row" onclick="addSimpleFromCompound(this)"><span style="width: 75%"><spring:message code="label.addOptionSimple"/></span><i class="fa fa-send-o" style="width: 25%; position: unset"></i></a></div>');
    	  $("#total-simple-compound-" + totalOptionsCompound).val(0);
    	  totalOptionsCompound += 1;
    	  $("#total-compound").val(totalOptionsCompound);
    	  return totalOptionsCompound - 1;
      }
      
      $("#addOptionCompound").click(function() {
          $(this).parent().append('<div class="mt-20 col-md-12" id = "div-option-' + totalCounter + '"> <span class="col-md-12"> <spring:message code="label.addOptionCompound"/></span><br><br><input type=number name="total-simple-compound-'+totalOptionsCompound+'" id="total-simple-compound-'+totalOptionsCompound+'" style="display:none"> <input name="option-compound-' + totalOptionsCompound + '" id="option-compound-' + totalOptionsCompound + '" type="text" style="background-color: lightgrey; width: 88%" required> <button class="button" style="display:flex;flex-direction:row;float:left" onclick="deleteNodeCompound(\'div-option-'+totalCounter+'\')"><span style="font-weight:bold;text-align:center">X</span></button> <a class="button mt-10" id="button-'+totalOptionsCompound+'" style="width:27%; display: flex; flex-direction: row" onclick="addSimpleFromCompound(this)"><span style="width: 75%"><spring:message code="label.addOptionSimple"/></span><i class="fa fa-send-o" style="width: 25%; position: unset"></i></a></div>');
      	  $("#total-simple-compound-" + totalOptionsCompound).val(0);
    	  totalOptionsCompound += 1;
    	  $("#total-compound").val(totalOptionsCompound);
    	  totalCounter += 1;
      });  
      
      function deleteNodeSimple(id) {
    	  $("#" + id).remove();
    	  totalOptionsSimple -= 1;
    	  $("#total-simple").val(totalOptionsSimple);
      }
      
      function deleteNodeCompound(id) {
    	  $("#" + id).remove();
    	  totalOptionsCompound -= 1;
    	  $("#total-compound").val(totalOptionsCompound);
      }
      
      function deleteNodeSimpleFromCompound(id, valueCompound) {
    	  $("#" + id).remove();
    	  $("#total-simple-compound-" + valueCompound).val(parseInt($("#total-simple-compound-" + valueCompound).val()) - 1);
      }

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
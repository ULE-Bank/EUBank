<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="description"
         content="Simulador de préstamo método Italiano.">
      <meta name="keywords"
         content="ULe-Bank, simulador, calculos, prestamo, metodo, italiano">
      <meta name="author" content="Razvan Raducu, Camino Fernández ">
      <meta name="robots" content="index,follow">
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
      <title>Oficina ulebank</title>
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
            class="inner-intro grayscale bg-office bg-opacity-black-70">
            <div class="container">
               <div class="row text-center intro-title">
                  <h1 class="text-blue">
                     Cuenta corriente
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
                        <a href="/o">
                        <i class="fa fa-home"></i> 
                        Oficina bancaria
                        </a>
                        <i class="fa fa-angle-double-right"></i>
                     </li>
                     <li>
                        <a href="/o/u?uin=${account.dni}">
                        Cliente ${account.dni}
                        </a>
                        <i class="fa fa-angle-double-right"></i>
                     </li>
                     <li>
                        <span>
                        Cuenta ${param.accn}
                        </span>
                     </li>
                  </ul>
               </div>
            </div>
         </section>
         <!--=================================
            inner-intro-->
         <section class="white-bg page-section-ptb" id="clientes">
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <b> Número de cuenta:</b> ${account.accountNumber}
                  </div>
                  <div class="col-md-4">
                     <b> Fecha de alta:</b> 
                     <fmt:formatDate value="${account.openingDate}" pattern="dd-MM-yyyy"/>
                  </div>
                  <div class="col-md-2">
                     <b> Estado:</b> ${account.status}
                  </div>
                  <div class="col-md-4">
                     <b> Liquidación: </b>  
                     <c:choose>
                        <c:when test="${account.liquidationPeriod=='1'}">
                           Mensual
                        </c:when>
                        <c:when test="${account.liquidationPeriod=='6'}">
                           Semestral
                        </c:when>
                        <c:when test="${account.liquidationPeriod=='3'}">
                           Trimestral
                        </c:when>
                        <c:otherwise>
                           Anual 
                           <br />
                        </c:otherwise>
                     </c:choose>
                  </div>
                  <div class="col-md-2">
                     <b> Año:</b>${account.annualDays} días
                  </div>
                  <div class="col-md-4">
                     <b> Comisión mantenimiento: </b>${account.maintenanceComission}€
                  </div>
                  <div class="col-md-6">
                     <b> Comisión saldo descubierto:</b>  ${account.maintenanceDeficit}% (mínimo ${account.minMaintenanceDeficit}€)
                  </div>
                  <div class="col-md-4">
                     <b> Intereses acreedores: </b> ${account.creditorInterests}%
                  </div>
                  <div class="col-md-4">
                     <b> Intereses deudores: </b>${account.debtorInterestOverNegativeBalance}%
                  </div>
                  <div class="col-md-6">
                     <b> Retención rendimientos de capital: </b> ${account.capitalPerformanceRetention}%
                  </div>
                  <div class="col-md-2">
                     <h4><b> Saldo:</b> ${account.balance}€</h4>
                  </div>
                  <div class="row">
                     <hr/>
                     <div class="row">
                        <h2>Movimientos:</h2>
                        <div style="height:450px; overflow:auto;">
                           <table border="1"  class="col-md-12" >
                              <tr style="color:white;background-color:rgb(0,169,218);">
                                 <th>Importe</th>
                                 <th>Concepto</th>
                                 <th>Fecha</th>
                                 <th>Operacion</th>
                              </tr>
                              <c:forEach var="movement" items="${account.movements}">
                                 <tr>
                                    <td>${movement.value}</td>
                                    <td>${movement.concept}</td>
                                    <td>
                                       <fmt:formatDate value="${movement.valueDate}" pattern="dd-MM-yyyy"/>
                                    </td>
                                    <td>
                                       <c:choose>
                                          <c:when test = "${movement.operation == 'I' }">
                                             Ingreso
                                          </c:when>
                                          <c:when test = "${movement.operation == 'D' }">
                                             Disposición
                                          </c:when>
                                          <c:otherwise>
                                             No especificado
                                          </c:otherwise>
                                       </c:choose>
                                    </td>
                                 </tr>
                              </c:forEach>
                           </table>
                        </div>
                     </div>
                     <br>
                     <br>
                     <br>
                     <div class="section-field col-md-12 register-form">
                        <form:form role="form" method="post" modelAttribute="subledgerAccount"
                           id="servicesform">
                           <div id="moves-container">
                              <spring:message code="label.disposicion" var="variable1" />
                              <spring:message code="label.ingreso" var="variable2" />
                              <div class="row"
                                 style="border: 1px solid red; border-radius: 5px;">
                                 <div class="section-field col-md-4">
                                    <label for="movements[0].concept">
                                       <spring:message
                                          code="label.s7c1" />
                                    </label>
                                    <div class="field-widget">
                                       <i class="fa fa-pencil"></i>
                                       <form:input path="movements[0].concept"
                                          required="required" />
                                    </div>
                                    <form:errors  style="color:red;" path="movements[0].concept"/>
                                 </div>
                                 <div class="section-field col-md-3">
                                    <label for="movements[0].value">
                                       <spring:message
                                          code="label.s7c2" />
                                    </label>
                                    <div class="field-widget">
                                       <i class="fa fa-eur"></i>
                                       <form:input path="movements[0].value"
                                          required="required" />
                                    </div>
                                    <form:errors  style="color:red;" path="movements[0].value"/>
                                 </div>
                                 <div class="section-field col-md-3">
                                    <label for="movements[0].valueDate">
                                       <spring:message
                                          code="label.s7c3" />
                                    </label>
                                    <div class="field-widget">
                                       <i class="fa fa-calendar"></i> <input type="date"
                                          id="movements0.valueDate"
                                          name="movements[0].valueDate" required="required" />
                                    </div>
                                    <form:errors  style="color:red;" path="movements[0].valueDate"/>
                                 </div>
                                 <div class="section-field col-md-2">
                                    <label for="movements[0].operation">
                                       <spring:message
                                          code="label.operation" />
                                    </label>
                                    <div class="field-widget">
                                       <form:select path="movements[0].operation"
                                          class="selected">
                                          <form:option value="D" label="${variable1}" />
                                          <form:option value="I" label="${variable2}" />
                                       </form:select>
                                    </div>
                                    <form:errors style="color:red;" path="movements[0].operation"/>
                                 </div>
                              </div>
                           </div>
                           <p>
                              <a role="button" id="add-moves">
                                 <spring:message
                                    code="label.addtransaction" />
                                 <span
                                    class="fa fa-plus-square"></span>
                              </a>
                           </p>
                           <p>
                              <a role="button" id="remove-moves">
                                 <spring:message
                                    code="label.removetransaction" />
                                 <span
                                    class="fa fa-minus-square"></span>
                              </a>
                           </p>
                           <div class="row text-center">
                              <a class="button mt-20" id="formularioMovimientos" onclick="registrar()"><span> Registrar movimientos </span> <i class ="fa fa-plus"></i></a>
                              <input id="submit_handle_formularioMovimientos" type="submit" style="display: none" />
                           </div>
                           <!-- En caso de que algún usuario tenga desactivado javascript, saldrá este mensaje por defecto. -->
                           <noscript>
                              <input type="submit"
                                 value="Registrar movimientos" />
                           </noscript>
                        </form:form>
                        <hr/>
                        <form id="liquidarForm" method="POST">
                           <div class="row">
                              <div class="col-md-6 col-md-offset-3">
                                 <div class="col-md-6">
                                    Realizar liquidación desde 
                                 </div>
                                 <div class="col-md-6">
                                    <input type="date"
                                       id="initLiquidationDate"
                                       name="initLiquidationDate" required="required" />
                                 </div>
                              </div>
                              <br>
                              <br>
                              <div class="col-md-6 col-md-offset-3">
                                 <div class="col-md-6">
                                    Hasta 
                                 </div>
                                 <div class="col-md-6">
                                    <input type="date"
                                       id="finalLiquidationDate"
                                       name="finalLiquidationDate" required="required" />
                                 </div>
                              </div>
                           </div>
                           <div class="row text-center">
                              <a class="button mt-20" id="liquidarFormulario" onclick="liquidar()"> <span> Liquidar </span> <i class ="fa fa-calculator"></i></a>
                              <input id="submit_handle_liquidarFormulario" type="submit" style="display: none" />
                           </div>
                           <!-- En caso de que algún usuario tenga desactivado javascript, saldrá este mensaje por defecto. -->
                           <noscript>
                              <input type="submit"
                                 value="Liquidar" />
                           </noscript>
                        </form>
                     </div>
                  </div>
                        <a href="/o" class="button mt-20"  > <span> Volver a la oficina </span> <i class ="fa fa-fast-backward"></i></a>
               
        
                  <a href="/o/u?uin=${account.dni}" class="button mt-20"  > <span> Volver al expediente electrónico </span> <i class ="fa fa-step-backward"></i></a>
                  <a href="/o/logout" class="button mt-20"  > <span> Cerrar sesión </span> <i class ="fa fa-sign-out"></i></a>
               </div>
            </div>
         </section>
         <!--=================================
            Footer-->
         <jsp:include page="/WEB-INF/views/footer.jsp" />
         <!--=================================
            Footer-->
      </div>
      <script type="text/javascript">
         var strings = new Array();
         strings['movimiento.descripcion'] = "<spring:message code='label.s7c1' javaScriptEscape='true' />";
         strings['movimiento.fecha'] = "<spring:message code='label.s7c3' javaScriptEscape='true' />";
         strings['movimiento.importe'] = "<spring:message code='label.s7c2' javaScriptEscape='true' />";
         strings['movimiento.operacion'] = "<spring:message code='label.operation' javaScriptEscape='true' />";
         strings['movimiento.ingreso'] = "<spring:message code='label.ingreso' javaScriptEscape='true' />";
         strings['movimiento.disposicion'] = "<spring:message code='label.disposicion' javaScriptEscape='true' />";
         
         function liquidar() {
          	$("#submit_handle_liquidarFormulario").click();
          }
          
          function registrar() {
          	$("#submit_handle_formularioMovimientos").click();
          }
         
      </script>
      <script src="/resources/services/js/dynamic-form2.js"></script>
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
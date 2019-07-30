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
      <link rel="shortcut icon" href="../favicon.ico" />
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
                     Expediente electrónico
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
                        Sucursal bancaria
                        </a>
                        <i class="fa fa-angle-double-right"></i>
                     </li>
                     <li>
                        <span>
                        Cliente ${client.dni}
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
                     <h2>Información cliente</h2>
                     <div class="col-md-4">
                        DNI: ${client.dni}
                     </div>
                     <div class="col-md-4">
                        Nombre: ${client.name}
                     </div>
                     <div class="col-md-4">
                        Apellidos: ${client.lastName}
                     </div>
                     <div class="col-md-4">
                        Email: ${client.email}
                     </div>
                     <div class="col-md-4">
                        Fecha nacimiento: 
                        <fmt:formatDate value="${client.birthDate}" pattern="dd-MM-yyyy"/>
                     </div>
                     <div class="col-md-4">
                        Fecha de alta: 
                        <fmt:formatDate value="${client.entryDate}" pattern="dd-MM-yyyy"/>
                     </div>
                  </div>
                  <hr/>
                  <div class="col-md-12">
                     <h2>Direcciones</h2>
                     <c:forEach var="direccion" items="${addresses}">
                        <div class="row" style="border: 1px solid red;">
                           <div class="col-md-4">
                              <b>Calle:</b> ${direccion.street}
                           </div>
                           <div class="col-md-4">
                              <b>Localidad:</b>  ${direccion.city}
                           </div>
                           <div class="col-md-4">
                              <b>Comunidad:</b>   ${direccion.autonomousRegion}
                           </div>
                           <div class="col-md-4">
                              <b>Número:</b> ${direccion.number}
                           </div>
                           <div class="col-md-4">
                              <b>Código postal:</b>  ${direccion.postalCode}
                           </div>
                        </div>
                     </c:forEach>
                     <div class="row">
                        <a class="button mt-20 button-black"  id="mostrarFormularioNuevaDireccion"> <span> Añadir dirección </span> <i class ="fa fa-caret-down"></i></a>
                        <form:form style="display: none;" id="formularioNuevaDireccion" action="/o/u/nd" method="post" modelAttribute="newAddress">
                           <div class="row col-md-12">
                              <h2>Nueva dirección:</h2>
                           </div>
                           <div class="row">
                              <div class="col-md-6">
                                 Calle: 
                                 <div class="field-widget">
                                    <i class="fa fa-home"></i> 
                                    <form:input path="street" type="text" required="required"/>
                                    <form:errors style="color: red;" path="street"></form:errors>
                                 </div>
                              </div>
                              <div class="col-md-2">
                                 Número: 
                                 <div class="field-widget">
                                    <i class="fa fa-home"></i> 
                                    <form:input path="number" class="" type="text" required="required"/>
                                    <form:errors style="color: red;" path="number"></form:errors>
                                 </div>
                              </div>
                              <div class="col-md-4">
                                 Codigo postal: 
                                 <div class="field-widget">
                                    <i class="fa fa-home"></i> 
                                    <form:input path="postalCode" class="" type="text" required="required"/>
                                    <form:errors style="color: red;" path="postalCode"></form:errors>
                                 </div>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col-md-6">
                                 Localidad: 
                                 <div class="field-widget">
                                    <i class="fa fa-home"></i> 
                                    <form:input path="city" class="" type="text" required="required" name="u" />
                                    <form:errors style="color: red;" path="city"></form:errors>
                                 </div>
                              </div>
                              <div class="col-md-6">
                                 Comunidad Autónoma: 
                                 <div class="field-widget">
                                    <i class="fa fa-home"></i>  
                                    <form:input path="autonomousRegion" type="text" 
                                       required="required" name="u" />
                                    <form:errors style="color: red;" path="autonomousRegion"></form:errors>
                                 </div>
                              </div>
                           </div>
                           <div class="row col-md-12">
                              <a class="button mt-20"  onclick="darDeAltaDireccion()"> <span> Dar de alta dirección </span> <i class ="fa fa-plus"></i></a>
                              <input id="submit_handle_nuevaDireccion" type="submit" style="display: none" />
                           </div>
                        </form:form>
                     </div>
                  </div>
                  <hr/>
                  <div class="col-md-12">
                     <h2>Cuentas</h2>
                     <c:forEach var="account" items="${currentAccounts}">
                        <div class="row" style="border: 1px solid red;">
                           <div class="col-md-12">
                              <b> Número de cuenta:</b> ${account.accountNumber}  <a href="/o/u/c?accn=${ account.accountNumber}">Acceder a la cuenta</a>
                              <b> Contrato:</b> <a href="/o/u/contratoCuenta?accn=${ account.accountNumber}" target="_blank">Inspeccionar contrato</a>
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
                                 <c:when test="${account.liquidationPeriod =='1'}">
                                    Mensual
                                 </c:when>
                                 <c:when test="${account.liquidationPeriod =='6'}">
                                    Semestral
                                 </c:when>
                                 <c:when test="${account.liquidationPeriod =='3'}">
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
                              <b> Saldo total:</b> ${account.totalBalance}€
                           </div>
                           <div class="col-md-6">
                              <b> Saldo bloqueado:</b> ${account.blockedBalance}€
                           </div>
                           <div class="col-md-6">
                              <b> Retención rendimientos de capital: </b> ${account.capitalPerformanceRetention}%
                           </div>
                        </div>
                     </c:forEach>
                     <div class="row">
                        <a class="button mt-20 button-black"  id="mostrarFormularioNuevaCuentaCorriente"> <span> Crear nueva cuenta corriente </span> <i class ="fa fa-caret-down"></i></a>
                        <form:form style="display: none;" id="formularioNuevaCuentaCorriente" action="/o/u/nc" method="post" modelAttribute="newCurrentAccount">
                           <div class="row col-md-12">
                              <h2>Datos nueva cuenta corriente:</h2>
                           </div>
                           <div class="row">
                              <div class="col-md-2">
                                 Interés acreedor:
                                 <form:select path="creditorInterests" id="seleccionPeriodo">
                                    <form:option value="0" label="0%" />
                                    <form:option value="1" label="1%" />
                                    <form:option value="2" label="2%" />
                                 </form:select>
                                 <form:errors style="color: red;" path="creditorInterests"></form:errors>
                              </div>
                              <div class="col-md-4">
                                 Interés deudor saldos negativos:
                                 <form:select path="debtorInterestOverNegativeBalance" id="seleccionPeriodo">
                                    <form:option value="20" label="20%" />
                                    <form:option value="25" label="25%" />
                                 </form:select>
                                 <form:errors style="color: red;" path="debtorInterestOverNegativeBalance"></form:errors>
                              </div>
                              <div class="col-md-4">
                                 <div class="col-md-9">
                                    Comisión por descubierto:
                                    <form:select path="maintenanceDeficit" id="seleccionPeriodo">
                                       <form:option value="1" label="1%" />
                                       <form:option value="3" label="3%" />
                                    </form:select>
                                    <form:errors style="color: red;" path="maintenanceDeficit"></form:errors>
                                 </div>
                                 <div class="col-md-3">
                                    Mínimo
                                    <form:select path="minMaintenanceDeficit" id="seleccionPeriodo">
                                       <form:option value="30" label="30€" />
                                       <form:option value="60" label="60€" />
                                    </form:select>
                                    <form:errors style="color: red;" path="minMaintenanceDeficit"></form:errors>
                                 </div>
                              </div>
                              <div class="col-md-2">
                                 Días anuales:
                                 <form:select path="annualDays" id="seleccionPeriodo">
                                    <form:option value="360" label="360" />
                                    <form:option value="365" label="365" />
                                 </form:select>
                                 <form:errors style="color: red;" path="annualDays"></form:errors>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col-md-3">
                                 Periodo de liqudiación:
                                 <form:select path="liquidationPeriod" id="seleccionPeriodo">
                                    <form:option value="1" label="Mensual" />
                                    <form:option value="3" label="Trimestral" />
                                    <form:option value="6" label="Semestral" />
                                    <form:option value="12" label="Anual" />
                                 </form:select>
                                 <form:errors style="color: red;" path="liquidationPeriod"></form:errors>
                              </div>
                              <div class="col-md-3">
                                Porcentaje de retención:
                                 <form:input path="capitalPerformanceRetention" type="text" 
                                    required="required" name="u" />
                                 <form:errors style="color: red;" path="capitalPerformanceRetention"></form:errors>
                              </div>
                              <div class="col-md-3">
                                 Comisión mantenimiento:
                                 <form:select path="maintenanceComission" id="seleccionPeriodo">
                                    <form:option value="0" label="0€" />
                                    <form:option value="10" label="10€" />
                                    <form:option value="25" label="25€" />
                                 </form:select>
                              </div>
                              <form:errors style="color: red;" path="maintenanceComission"></form:errors>
                           </div>
                           <div class="row col-md-12">
                              <a class="button mt-20"  onclick="darDeAltaCuentaCorriente()"> <span> Dar de alta cuenta corriente </span> <i class ="fa fa-plus"></i></a>
                              <input id="submit_handle_nuevaCuentaCorriente" type="submit" style="display: none" />
                           </div>
                        </form:form>
                     </div>
                  </div>
               </div>
               <div class="row">
               <a href="/o" class="button mt-20"  > <span> Volver a la oficina </span> <i class ="fa fa-step-backward"></i></a>
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
      <script>
         //jQuery para mostrar u ocultar el formulario de creación de nuevo cliente
         $("#mostrarFormularioNuevaDireccion").click(function() {
         	form = $("#formularioNuevaDireccion");
         	if (form.css('display') == 'none') {
         		form.show(1000);
         	} else {
         		form.hide(1000);
         	}
         });
         
         function darDeAltaCuentaCorriente() {
         	$("#submit_handle_nuevaCuentaCorriente").click();
         }
         
         function darDeAltaDireccion() {
         	$("#submit_handle_nuevaDireccion").click();
         }
         
         //jQuery para mostrar u ocultar el formulario de creación de nuevo empleado
         $("#mostrarFormularioNuevaCuentaCorriente").click(function() {
         	form = $("#formularioNuevaCuentaCorriente");
         	if (form.css('display') == 'none') {
         		form.show(1000);
         	} else {
         		form.hide(1000);
         	}
         });
      </script>
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
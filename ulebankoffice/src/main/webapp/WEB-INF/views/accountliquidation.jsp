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
                     Liquidación
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
                        <a href="/o/u?uin=${account.dni}">
                        Cliente ${account.dni}
                        </a>
                        <i class="fa fa-angle-double-right"></i>
                     </li>
                      <li>
                        <a href="/o/u/c?accn=${account.accountNumber}">
                        Cuenta ${account.accountNumber}
                        </a>
                        <i class="fa fa-angle-double-right"></i>
                     </li>
                     <li>
                        <span>
                        Liquidación
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
         
         
         
         <div class="modal-body">
					
						<table class="table" style="background-color:white; ">
							<thead>
								<tr>
									<th style="text-align:right;"><spring:message code="label.fecha"/></th>
									<th style="text-align:right;"><spring:message code="label.concepto"/></th>
									<th style="text-align:right;"><spring:message code="label.ingreso"/></th>	
									<th style="text-align:right;"><spring:message code="label.disposicion"/></th>
									<th style="text-align:right;"><spring:message code="label.balance" /></th>
									<th style="text-align:right;"><spring:message code="label.days" /></th>
									<th style="text-align:right;"><spring:message code="label.debtornumbers" /></th>
									<th style="text-align:right;"><spring:message code="label.exceedednumbers" /></th>
								</tr>
							</thead>
							<tbody  style="font-size:13px; text-align:right;">
								<c:forEach var="row" items="${table}">
									<tr>
										<c:forEach var="itemRow" items="${row}">
											<td><c:out value="${itemRow}" /></td>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div style="text-align: center;">
						<table class="table">
							<thead>
								<tr>
									<th></th>
									<th>TIPO</th>
									<th>IMPORTE</th>
								</tr>
							</thead>
						<tbody style=" text-align:right;">
									<tr>
										<td>Intereses acreedores</td>
										<td>${account.creditorInterests}%</td>
										<td>${account.finalCreditorInterests}</td>
									</tr>
									<tr>
										<td>Retencion rendimientos</td>
										<td>${account.capitalPerformanceRetention}%</td>
										<td>${account.finalPerformanceRetention}</td>
									</tr>
									<tr>
										<td>Intereses deudores</td>
										<td>${account.debtorInterestOverNegativeBalance}%</td>
										<td>${account.finalDebtorInterests}</td>
									</tr>
									<tr>
										<td>Comisión mantenimiento</td>
										<td>${account.maintenanceComission}€</td>
										<td>${account.maintenanceComission}€</td>
									</tr>
									<tr>
										<td>Comisión descubierto</td>
										<td>${account.maintenanceDeficit}%</td>
										<td>${account.finalDeficitComission}</td>
									</tr>
									<tr>
										<td></td>
										<td><b>TOTAL</b></td>
										<td>${account.totalLiquidation}</td>
									</tr>
								</tbody>
						</table>
						
						</div>
					</div>
         
         </div>
         
         <div class="col-md-12">
         <div class="row">
                  <a href="/o" class="button mt-20"  > <span> Volver a la oficina </span> <i class ="fa fa-fast-backward"></i></a>
               
        
                  <a href="/o/u/c?accn=${account.accountNumber}" class="button mt-20"  > <span> Volver a la cuenta </span> <i class ="fa fa-step-backward"></i></a>
          
        
                  <a href="/o/logout" class="button mt-20"  > <span> Cerrar sesión </span> <i class ="fa fa-sign-out"></i></a>
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
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="description" content="Buscador de ULe-Bank. Busca contenido en ULe-Bank.">
      <meta name="keywords" content="ULe-Bank, buscador, contenidos">
      <meta name="author" content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu">
      <meta name="robots" content="index,follow">
              <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        
        <jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="<spring:message code='label.ulebanksearch' />" />
      <meta property="og:url" content="http://ulebank.unileon.es/search" />
      <meta property="og:description" content="<spring:message code='label.ulebanksearch'/>"/>
        
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
         <spring:message code="label.ulebanksearch"/>
      </title>
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
         class="inner-intro grayscale bg-searchresult bg-opacity-black-70">
         <div class="container">
            <div class="row text-center intro-title">
               <h1 class="text-blue">
                  <spring:message code="label.ulebanksearch" />
               </h1>
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
                     <span>
                        <spring:message code="label.search"/>
                     </span>
                  </li>
               </ul>
            </div>
         </div>
      </section>
      <!--=================================
         inner-intro-->
      <section class="faq white-bg page-section-ptb">
         <div class="container">
            <div class="row">
               <div class="page-header">
                  <div class="col-md-10 col-md-offset-1">
                     <h1>
                        <spring:message code="label.searchresults" />
                     </h1>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-md-10 col-md-offset-1">
                  <!--              No hace falta incluí el script de Google puesto que al estar en el header.jsp, se incluye mediante jsp:include. Si se incluye dos veces, revienta. -->
                  <gcse:search></gcse:search>
               </div>
            </div>
            <div class="row">
               <div class="col-md-10 col-md-offset-1">
                <h1>
                        <spring:message code="label.topsearch" />
                     </h1>
                  <div id="queries"></div>
                  <script src="https://cse.google.com/query_renderer.js"></script>
                  <script src="https://cse.google.com/api/004973092061729270447/cse/x_i5h1dtlam/queries/js?view=overall&callback=(new+PopularQueryRenderer(document.getElementById(%22queries%22))).render"></script>
               </div>
            </div>
         </div>
      </section>
      </div>
      <!--=================================
         Footer-->
      <jsp:include page="/WEB-INF/views/footer.jsp" />
      <!--=================================
         Footer-->
      <script src="resources/services/js/tooltip-script.js"></script>
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
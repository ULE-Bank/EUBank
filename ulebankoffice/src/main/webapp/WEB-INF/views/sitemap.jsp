<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="author" content="Razvan Raducu, Camino Fernández" />
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
      
      <jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="<spring:message code='label.sitemap' />" />
      <meta property="og:url" content="http://ulebank.unileon.es/sitemap" />
      <meta property="og:description" content="<spring:message code='label.sitemap'/>"/>
      
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
         <spring:message code="label.sitemap" />
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
         <section class="inner-intro grayscale bg-sitemap bg-opacity-black-70">
            <div class="container">
               <div class="row text-center intro-title">
                  <h1 class="text-blue">
                     <i class="fa fa-sitemap" aria-hidden="true">   </i>  
                     <spring:message code="label.sitemap" />
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
                        <span>
                           <spring:message code="label.sitemap" />
                        </span>
                     </li>
                  </ul>
               </div>
            </div>
         </section>
         <!--=================================
            inner-intro-->
         <!--=================================
            sitemap-->
         <section class="sitemap page-section-ptb">
            <div class="container">
               <div class="row">
                  <div class="col-lg-3 col-md-4 col-sm-6">
                     <h4 class="text-blue">
                        <i class="fa fa-home"></i> 
                        <a href="/">
                           <spring:message
                              code="label.sitehome" />
                        </a>
                     </h4>
                     <ul>
                        <li>
                           <a href="/a/services">
                              <i class="fa fa-angle-right"></i>
                              <spring:message code="label.siteservices" />
                           </a>
                        </li>
                        <li><a href="/#blog"><i class="fa fa-angle-right"></i>
                           Blog</a>
                        </li>
                        <li>
                           <a href="/#team">
                              <i class="fa fa-angle-right"></i>
                              <spring:message code="label.ourteam" />
                           </a>
                        </li>
                        <li>
                           <a href="/#sponsors">
                              <i class="fa fa-angle-right"></i>
                              <spring:message code="label.sponsors" />
                           </a>
                        </li>
                        <li>
                           <a href="/#links">
                              <i class="fa fa-angle-right"></i>
                              <spring:message code="label.links" />
                           </a>
                        </li>
                        <li>
                           <a href="/#contact">
                              <i class="fa fa-angle-right"></i>
                              <spring:message code="label.contact" />
                           </a>
                        </li>
                        <li class="text-blue">
                           <spring:message code="label.language" />
                           <ul>
                              <li style="padding-left: 40px">
                                 <a href="/?language=es">
                                    <i
                                       class="fa fa-angle-right"></i> 
                                    <spring:message
                                       code="label.spanish" />
                                 </a>
                              </li>
                              <li style="padding-left: 40px">
                                 <a href="/?language=en">
                                    <i
                                       class="fa fa-angle-right"></i> 
                                    <spring:message
                                       code="label.english" />
                                 </a>
                              </li>
                           </ul>
                        </li>
                     </ul>
                  </div>
                  <div class="col-lg-3 col-md-4 col-sm-6">
                     <h4 class="text-blue">
                        <i class="fa fa-check-circle-o"></i> 
                        <a href="/a/services">
                           <spring:message
                              code="label.siteservices" />
                        </a>
                     </h4>
                     <ul>
                        <li class="text-blue">
                     <b>
                     <spring:message
                                 code="label.servicegroup1" /></b>
                     </li>
                     <li>
                     <b>
                     <spring:message
                                 code="label.serviceheader1" /></b>
                     </li>
                        <li>
                           <a href="/apr">
                              <i class="fa fa-angle-right"></i> 
                              <spring:message
                                 code="label.siteservice1" />
                           </a>
                        </li>
                         <li>
                           <a href="/a/aprv">
                              <i class="fa fa-angle-right"></i> 
                              <spring:message
                                 code="label.siteservice1-2" />
                           </a>
                        </li>
                        <li>
                     <b>
                     <spring:message
                                 code="label.serviceheader2" /></b>
                     </li>
                       <li>
                           <a href="/reversemortgage">
                              <i
                                 class="fa fa-angle-right"></i> 
                              <spring:message
                                 code="label.siteservice6" />
                           </a>
                        </li>
                         <li>
                     <b>
                     <spring:message
                                 code="label.serviceheader3" /></b>
                     </li>
                     
                     
                        <li>
                           <a href="/leasing">
                              <i class="fa fa-angle-right"></i>
                              <spring:message code="label.siteservice2" />
                           </a>
                        </li>
                       
                        <li>
                           <a href="/loans">
                              <i class="fa fa-angle-right"></i> 
                              <spring:message
                                 code="label.siteservice4" />
                           </a>
                           <ul>
                              <li style="padding-left: 40px">
                                 <a href="/frenchloan">
                                    <i class="fa fa-angle-right"></i> 
                                    <spring:message
                                       code="label.s4french" />
                                 </a>
                              </li>
                              <li style="padding-left: 40px">
                                 <a href="/italianloan">
                                    <i class="fa fa-angle-right"></i> 
                                    <spring:message
                                       code="label.s4italian" />
                                 </a>
                              </li>
                              <li style="padding-left: 40px">
                                 <a href="/germanloan">
                                    <i class="fa fa-angle-right"></i> 
                                    <spring:message
                                       code="label.s4german" />
                                 </a>
                              </li>
                              <li style="padding-left: 40px">
                                 <a href="/americanloan">
                                    <i class="fa fa-angle-right"></i> 
                                    <spring:message
                                       code="label.s4american" />
                                 </a>
                              </li>
                           </ul>
                        </li>
                        <li>
                           <a href="/discounts">
                              <i class="fa fa-angle-right"></i>
                              <spring:message code="label.siteservice5" />
                           </a>
                        </li>
                      
                        <li>
                           <a href="/creditaccount">
                              <i
                                 class="fa fa-angle-right"></i> 
                              <spring:message
                                 code="label.siteservice7" />
                           </a>
                        </li>
                        
                        
                           <li class="text-blue">
                     <b>
                     <spring:message
                                 code="label.servicegroup2" /></b>
                     </li>
                         <li>
                           <a href="/offersconsulting">
                              <i
                                 class="fa fa-angle-right"></i> 
                              <spring:message
                                 code="label.siteservice3" />
                           </a>
                        </li>
                        
                     </ul>
                  </div>
                  <div class="col-lg-3 col-md-4 col-sm-6">
                     <h4 class="text-blue">
                        <i class="fa fa-file-text"></i>
                        <spring:message code="label.otherpages" />
                     </h4>
                     <ul>
                        <li>
                           <a href="/contact">
                              <i class="fa fa-angle-right"></i>
                              <spring:message code="label.contactform" />
                           </a>
                        </li>
                        <li>
                           <a href="/">
                              <i class="fa fa-angle-right"></i> 
                              <spring:message
                                 code="label.sitemap" />
                           </a>
                        </li>
                     </ul>
                  </div>
                  <div class="col-lg-3 col-md-4 col-sm-6">
                     <h4 class="text-blue">
                        <i class="fa fa-search"></i>
                        <spring:message code="label.searchengine" />
                     </h4>
                     <ul>
                        <li>
                           <a href="/search">
                              <i class="fa fa-angle-right"></i>
                              <spring:message code="label.ulebanksearch" />
                           </a>
                        </li>
                     </ul>
                  </div>
               </div>
            </div>
         </section>
         <!--=================================
            sitemap-->
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
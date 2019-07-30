<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport"
         content="width=device-width, initial-scale=1, maximum-scale=1" />
      <meta name="description"
         content="<spring:message code='label.indexdescription'/>"/>
      <meta name="keywords"
         content="ULe-Bank, universidad, leon, simulador, calculos, bancarios, operaciones, gestion">
      <meta name="author"
         content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu">
      <meta name="robots" content="index,follow">
      <jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="ULe Bank" />
      <meta property="og:url" content="http://ulebank.unileon.es/" />
      <meta property="og:description" content="<spring:message code='label.indexdescription'/>"/>
      <title>
         <spring:message code="label.sitetitle" />
      </title>
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
      <div class="page-wrapper over-inherit">
         <!--=================================
            preloader -->
         <!-- 		<div id="preloader"> -->
         <!-- 			<div class="clear-loading loading-effect"> -->
         <!-- 				<span></span> -->
         <!-- 			</div> -->
         <!-- 		</div> -->
         <!--=================================
            preloader -->
         <!--=================================
            header -->
         <header id="header" class="header-4">
            <div id="menu-toggle">
               <div id="menu-icon">
                  <span></span> <span></span> <span></span> <span></span> <span></span>
                  <span></span>
               </div>
            </div>
            <div id="menu">
               <div class="menu-side-top">
                  <%--     <spring:message code=""/> --%>
                  <h3 class="text-white">ULe-Bank</h3>
                  <a href="./">
                     <spring:message code="label.sitehome" />
                  </a>
                  <a
                     href="#services">
                     <spring:message code="label.siteservices" />
                  </a>
                  <a href="#contact">
                     <spring:message code="label.siteabout" />
                  </a>
                  <a
                     href="/contact">
                     <spring:message code="label.contact" />
                  </a>
                  <a
                     href="/sitemap">
                     <spring:message code="label.sitemap" />
                  </a>
               </div>
               <!--          <div class="login-side mt-40 text-left"> -->
               <%--           <h3 class="text-white"><spring:message code="lable.sitelogin"/></h3> --%>
               <!--            <form>   -->
               <!--              <div class="form-group">      -->
               <%--               <label><spring:message code="label.siteloginusername"/></label> --%>
               <!--                <input type="text" name="username" placeholder="Email Address" /> -->
               <!--                 </div> -->
               <!--                 <div class="form-group"> -->
               <%--                  <label><spring:message code="label.siteloginpassword"/></label> --%>
               <!--                 <input type="password" name="password" placeholder="Password" />       -->
               <!--                </div> -->
               <!--                <div class="remember-checkbox"> -->
               <!--                  <input type="checkbox" name="one" id="one" /> -->
               <%--                <label class="remember" for="one"><spring:message code="label.siteloginrememberme"/></label> --%>
               <!--                </div> -->
               <!--                <div class="clearfix"> -->
               <!--                <a href="#" class="button button-white mt-20"> -->
               <%--                   <span><spring:message code="lable.sitelogin"/></span> --%>
               <!--                 </a> -->
               <%--                <a class="forgot" href="#"><spring:message code="label.siteloginforgotpassword"/></a>  --%>
               <!--               </div> -->
               <%--            <p class="register text-white mt-20"><spring:message code="lable.sitedonthaveaccount"/>  <a href="#"> <spring:message code="label.siteregisternow"/></a></p>  --%>
               <!--          </form> -->
               <!--       </div> -->
            </div>
            <!--=================================
               mega menu -->
            <div class="menu">
               <!-- menu start -->
               <nav id="menu-1" class="mega-menu">
                  <!-- menu list items container -->
                  <section class="menu-list-items">
                     <div class="container">
                        <div class="row">
                           <div class="col-lg-12 col-md-12">
                              <!-- menu logo -->
                              <ul class="menu-logo">
                                 <li><a href="./"><img id="logo_img"
                                    src="/resources/template/images/logo.png" alt="logo"> </a>
                                 </li>
                              </ul>
                              <!-- menu links -->
                              <ul class="menu-links">
                                 <!-- active class -->
                                 <li class="active page-scroll">
                                    <a href="#">
                                       <spring:message
                                          code="label.sitehome" />
                                    </a>
                                 </li>
                                 <li class="page-scroll">
                                    <a href="#services">
                                       <spring:message
                                          code="label.siteservices" />
                                       <i
                                          class="fa fa-angle-down fa-indicator"></i>
                                    </a>
                                    <!-- drop down full width -->
                                    <div class="drop-down menu-bg grid-col-5">
                                       <!--grid row-->
                                       <div class="grid-row">
                                          <div class="row" style="border-bottom: 1px solid #00a8d9;" >
                                             <h3>
                                                <a href="/a/services" style="text-align:center; font-weight:bold;" >
                                                   <spring:message code="label.accessservicepage" />
                                                </a>
                                             </h3>
                                          </div>
                                          <!--grid column 3-->
                                          <div class="grid-col-12" >
                                             <h3 style="text-align:center;">
                                                <spring:message
                                                   code="label.servicegroup1" />
                                             </h3>
                                          </div>
                                          <div class="grid-col-4">
<!--                                              <h3> -->
<%--                                                 <spring:message --%>
<%--                                                    code="label.serviceheader1" /> --%>
<!--                                              </h3> -->
                                             <ul>
                                                <li>
                                                   <a href="/apr">
                                                      <spring:message
                                                         code="label.siteservice1" />
                                                   </a>
                                                </li>
                                                <li>
                                                   <a href="/a/aprv">
                                                      <spring:message
                                                         code="label.siteservice1-2" />
                                                   </a>
                                                </li>
                                             </ul>
                                          </div>
                                          <!--grid column 3-->
                                          <div class="grid-col-4">
<!--                                              <h3> -->
<%--                                                 <spring:message --%>
<%--                                                     code="label.serviceheader2" /> --%>
<!--                                              </h3> -->
                                             <ul>
                                                <li>
                                                   <a href="/reversemortgage">
                                                      <spring:message
                                                         code="label.siteservice6" />
                                                   </a>
                                                </li>
<!--                                                 <li> -->
<!--                                                    <a href="/a/transactionaccount"> -->
<%--                                                       <spring:message --%>
<%--                                                          code="label.siteservice9" /> --%>
<!--                                                    </a> -->
<!--                                                 </li> -->
<!--                                                 <li> -->
<!--                                                    <a href="/a/deposits"> -->
<%--                                                       <spring:message --%>
<%--                                                          code="label.siteservice8" /> --%>
<!--                                                    </a> -->
<!--                                                 </li> -->
                                             </ul>
                                          </div>
                                          <div class="grid-col-4">
<!--                                              <h3> -->
<%--                                                 <spring:message code="label.serviceheader3"/> --%>
<!--                                              </h3> -->
                                             <ul>
                                             <li>
                                                   <a href="/creditaccount">
                                                      <spring:message
                                                         code="label.siteservice7" />
                                                   </a>
                                                </li>
                                                <li>
                                                   <a href="/loans">
                                                      <spring:message
                                                         code="label.siteservice4" />
                                                   </a>
                                                </li>
                                                <li>
                                                   <a href="/discounts">
                                                      <spring:message
                                                         code="label.siteservice5" />
                                                   </a>
                                                </li>
                                                <li>
                                                   <a href="/leasing">
                                                      <spring:message
                                                         code="label.siteservice2" />
                                                   </a>
                                                </li>

                                             </ul>
                                          </div>
                                       </div>
<!--                                        <div class="grid-row"> -->
<!--                                           <div class="grid-col-4"> -->
<!--                                              <h3> -->
<%--                                                 <spring:message --%>
<%--                                                    code="label.serviceheader4" /> --%>
<!--                                              </h3> -->
<!--                                              <ul> -->
<!--                                              <li> -->
<!--                                                    <a href=""> -->
<!--                                                       Servicio -->
<!--                                                    </a> -->
<!--                                                 </li> -->
<!--                                                 <li> -->
<!--                                                    <a href=""> -->
<!--                                                       Servicio -->
<!--                                                    </a> -->
<!--                                                 </li> -->
<!--                                                 <li> -->
<!--                                                    <a href=""> -->
<!--                                                       Servicio -->
<!--                                                    </a> -->
<!--                                                 </li> -->
<!--                                              </ul> -->
<!--                                           </div> -->
<!--                                           <div class="grid-col-4"> -->
<!--                                              <h3> -->
<%--                                                 <spring:message --%>
<%--                                                    code="label.serviceheader5" /> --%>
<!--                                              </h3> -->
<!--                                              <ul> -->
<!--                                              <li> -->
<!--                                                    <a href=""> -->
<!--                                                       Servicio -->
<!--                                                    </a> -->
<!--                                                 </li> -->
<!--                                                 <li> -->
<!--                                                    <a href=""> -->
<!--                                                       Servicio -->
<!--                                                    </a> -->
<!--                                                 </li> -->
<!--                                                 <li> -->
<!--                                                    <a href=""> -->
<!--                                                       Servicio -->
<!--                                                    </a> -->
<!--                                                 </li> -->
<!--                                              </ul> -->
<!--                                           </div> -->
<!--                                        </div> -->
                                       <div class="grid-row">
                                          <h3 style="text-align:center;">
                                             <spring:message
                                                code="label.servicegroup2" />
                                          </h3>
                                          <a href="/offersconsulting" style="text-align:center;">
                                                      <spring:message
                                                         code="label.siteservice3access" />
                                          </a>
                                       </div>
                                    </div>
                                 </li>
                                 <!--                                  <li class="page-scroll"><a href="#blog">blog</a></li> -->
                                 <li class="page-scroll">
                                    <a href="#team">
                                       <spring:message
                                          code="label.ourteam" />
                                    </a>
                                 </li>
                                 <li class="page-scroll">
                                    <a href="#sponsors">
                                       <spring:message
                                          code="label.sponsors" />
                                    </a>
                                 </li>
                                 <!--                                  <li class="page-scroll"> -->
                                 <!--                                     <a href="#links"> -->
                                 <%--                                        <spring:message --%>
                                 <%--                                           code="label.links" /> --%>
                                 <!--                                     </a> -->
                                 <!--                                  </li> -->
                                 <li class="page-scroll">
                                    <a href="#contact">
                                       <spring:message
                                          code="label.contact" />
                                       <i
                                          class="fa fa-angle-down fa-indicator"></i>
                                    </a>
                                    <!-- drop down multilevel  -->
                                    <ul class="drop-down menu-bg">
                                       <li>
                                          <a href="/contact">
                                             <spring:message
                                                code="label.contactform" />
                                          </a>
                                       </li>
                                    </ul>
                                 </li>
                                 <li>
                                    <a>
                                       <spring:message code="label.language" />
                                       <i class="fa fa-angle-down fa-indicator"></i>
                                    </a>
                                    <!-- drop down multilevel  -->
                                    <ul class="drop-down-multilevel right-menu">
                                       <li>
                                          <a href="?language=en">
                                          English
                                          <img class="languageflag" src="/resources/template/images/feature/ENflag.jpg"/>
                                          </a>
                                       </li>
                                       <li>
                                          <a href="?language=es">
                                          Español
                                          <img class="languageflag" src="/resources/template/images/feature/ESflag.jpg"/>
                                          </a>
                                       </li>
                                    </ul>
                                 </li>
                                 <li>
                                    <!-- GOOGLE CUSTOM SEARCH ENGINE -->
                                    <script>
                                       (function() {
                                         var cx = '004973092061729270447:x_i5h1dtlam';
                                         var gcse = document.createElement('script');
                                         gcse.type = 'text/javascript';
                                         gcse.async = true;
                                         gcse.src = 'https://cse.google.com/cse.js?cx=' + cx;
                                         var s = document.getElementsByTagName('script')[0];
                                         s.parentNode.insertBefore(gcse, s);
                                       })();
                                    </script>
                                    <!-- GOOGLE CUSTOM SEARCH ENGINE -->
                                    <div class="search-3">
                                       <a class="search-btn not_click" href="javascript:void(0);">
                                          <spring:message
                                             code="label.searchbutton" />
                                       </a>
                                       <div class="search-3-box not-click">
                                          <gcse:searchbox-only resultsUrl="/search"></gcse:searchbox-only>
                                          <!--                                           <form role="form" method="get" action="/search" -->
                                          <!--                                              id="searchengine"> -->
                                          <!--                                              <input type="text" class="not-click" placeholder="Search" -->
                                          <!--                                                 value="" name="q"> <i -->
                                          <!--                                                 class="fa fa-search" -->
                                          <!--                                                 onclick="document.getElementById('searchengine').submit()"></i> -->
                                          <!--                                           </form> -->
                                       </div>
                                    </div>
                                 </li>
                                 <li>
                                    <a href="/o">
                                       <spring:message code="label.office"/>
                                    </a>
                                 </li>
                              </ul>
                           </div>
                        </div>
                     </div>
                  </section>
               </nav>
               <!-- menu end -->
            </div>
         </header>
         <!--=================================
            header -->
         <!--=================================
            slider- -->
         <!-- data-interval se necesita pra definir la pausa en cada slide. Al haber texto, es mejor poner algo más. -->
         <section id="animated-slider" class="carousel slide"
            data-ride="carousel" data-interval="6000">
            <!-- Indicators -->
            <ol class="carousel-indicators">
               <li data-target="#animated-slider" data-slide-to="0" class="active"></li>
               <li data-target="#animated-slider" data-slide-to="1"></li>
               <li data-target="#animated-slider" data-slide-to="2"></li>
            </ol>
            <!-- Carousel inner -->
            <div class="carousel-inner">
               <!--/ Carousel item end -->
               <div class="item active bg-opacity-black-50">
                  <img class="img-responsive"
                     src="/resources/template/images/gallery/facultadeconomicas.jpg"
                     alt="slider">
                  <div class="slider-content">
                     <div class="container">
                        <div class="row">
                           <div class="col-md-12 text-center">
                              <div class="slider-2">
                                 <span class="animated1">
                                    <spring:message
                                       code="label.welcometopmessage1" />
                                 </span>
                                 <h1 class="animated2 text-white">
                                    <spring:message code="label.welcomemessage1" />
                                 </h1>
                                 <p class="animated3">
                                    <spring:message code="label.welcomesubmessage1" />
                                 </p>
                                 <a href="/a/services" class="button animated8">
                                    <span>
                                       <spring:message code="label.knowourservices" />
                                    </span>
                                 </a>
                                 <a target="_blank" href="/contact"
                                    class="button button-black animated8">
                                    <span>
                                       <spring:message
                                          code="label.getintouch" />
                                    </span>
                                 </a>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item bg-opacity-black-50">
                  <img class="img-responsive"
                     src="/resources/template/images/gallery/facultadingenieras.jpg"
                     alt="slider">
                  <div class="slider-content">
                     <div class="container">
                        <div class="row">
                           <div class="col-md-12 text-center">
                              <div class="slider-2">
                                 <span class="animated1">
                                    <spring:message
                                       code="label.welcometopmessage2" />
                                 </span>
                                 <h1 class="animated4 text-white">
                                    <spring:message code="label.welcomemessage2" />
                                 </h1>
                                 <p class="animated5">
                                    <spring:message code="label.welcomesubmessage2" />
                                 </p>
                                 <a href="/a/services" class="button animated8">
                                    <span>
                                       <spring:message code="label.knowourservices" />
                                    </span>
                                 </a>
                                 <a target="_blank" href="/contact"
                                    class="button button-black animated8">
                                    <span>
                                       <spring:message
                                          code="label.getintouch" />
                                    </span>
                                 </a>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item bg-opacity-black-50">
                  <img class="img-responsive"
                     src="/resources/template/images/gallery/bibliotecauniversitaria.jpg"
                     alt="slider">
                  <div class="slider-content">
                     <div class="container">
                        <div class="row">
                           <div class="col-md-12 text-center">
                              <div class="slider-2">
                                 <span class="animated1">
                                    <spring:message
                                       code="label.welcometopmessage3" />
                                 </span>
                                 <h1 class="animated6 text-white">
                                    <spring:message code="label.welcomemessage3" />
                                 </h1>
                                 <p class="animated7">
                                    <spring:message code="label.welcomesubmessage3" />
                                 </p>
                                 <a href="/a/services" class="button animated8">
                                    <span>
                                       <spring:message code="label.knowourservices" />
                                    </span>
                                 </a>
                                 <a target="_blank" href="/contact"
                                    class="button button-black animated8">
                                    <span>
                                       <spring:message
                                          code="label.getintouch" />
                                    </span>
                                 </a>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <!--/ Carousel item end -->
            </div>
         </section>
         <!--=================================
            slider -->
         <!--=================================
            custom-content -->
         <!--=================================
            key-features (services) -->
         <!--  Estos son todos los simple line icons que se pueden usar  -->
         <!-- .icon-user-female, .icon-user-follow, .icon-user-following, .icon-user-unfollow, .icon-trophy, .icon-screen-smartphone,  -->
         <!-- .icon-screen-desktop, .icon-plane, .icon-notebook, .icon-moustache, .icon-mouse, .icon-magnet, .icon-energy, .icon-emoticon-smile, . -->
         <!--  icon-disc, .icon-cursor-move, .icon-crop, .icon-credit-card, .icon-chemistry, .icon-user, .icon-speedometer, .icon-social-youtube,  -->
         <!-- .icon-social-twitter, .icon-social-tumblr, .icon-social-facebook, .icon-social-dropbox, .icon-social-dribbble, .icon-shield, .icon-screen-tablet,  -->
         <!-- .icon-magic-wand, .icon-hourglass, .icon-graduation, .icon-ghost, .icon-game-controller, .icon-fire, .icon-eyeglasses, .icon-envelope-open, .icon-envelope-letter,  -->
         <!-- .icon-bell, .icon-badge, .icon-anchor, .icon-wallet, .icon-vector, .icon-speech, .icon-puzzle, .icon-printer, .icon-present, .icon-playlist,  -->
         <!-- .icon-pin, .icon-picture, .icon-map, .icon-layers, .icon-handbag, .icon-globe-alt, .icon-globe, .icon-frame, .icon-folder-alt, .icon-film, .icon-feed,  -->
         <!-- .icon-earphones-alt, .icon-earphones, .icon-drop, .icon-drawer, .icon-docs, .icon-directions, .icon-direction, .icon-diamond, .icon-cup, .icon-compass,  -->
         <!-- .icon-call-out, .icon-call-in, .icon-call-end, .icon-calculator, .icon-bubbles, .icon-briefcase, .icon-book-open, .icon-basket-loaded, .icon-basket,  -->
         <!-- .icon-bag, .icon-action-undo, .icon-action-redo, .icon-wrench, .icon-umbrella, .icon-trash, .icon-tag, .icon-support, .icon-size-fullscreen, .icon-size-actual,  -->
         <!-- .icon-shuffle, .icon-share-alt, .icon-share, .icon-rocket, .icon-question, .icon-pie-chart, .icon-pencil, .icon-note, .icon-music-tone-alt, .icon-music-tone,  -->
         <!-- .icon-microphone, .icon-loop, .icon-logout, .icon-login, .icon-list, .icon-like, .icon-home, .icon-grid, .icon-graph, .icon-equalizer, .icon-dislike, .icon-cursor,  -->
         <!-- .icon-control-start, .icon-control-rewind, .icon-control-play, .icon-control-pause, .icon-control-forward, .icon-control-end, .icon-calendar, .icon-bulb, .icon-bar-chart,  -->
         <!-- .icon-arrow-up, .icon-arrow-right, .icon-arrow-left, .icon-arrow-down, .icon-ban, .icon-bubble, .icon-camcorder, .icon-camera, .icon-check, .icon-clock, .icon-close,  -->
         <!-- .icon-cloud-download, .icon-cloud-upload, .icon-doc, .icon-envelope, .icon-eye, .icon-flag, .icon-folder, .icon-heart, .icon-info, .icon-key, .icon-link,  -->
         <!-- .icon-lock, .icon-lock-open, .icon-magnifier, .icon-magnifier-add, .icon-magnifier-remove, .icon-paper-clip, .icon-paper-plane, .icon-plus, .icon-pointer,  -->
         <!-- .icon-power, .icon-refresh, .icon-reload, .icon-settings, .icon-star, .icon-symbol-female, .icon-symbol-male, .icon-target, .icon-volume-1, .icon-volume-2,  -->
         <!-- .icon-volume-off, .icon-users  -->
         <section id="services" class="key-features white-bg pt-80 pb-20">
            <div class="container">
               <div class="row">
                  <div class="col-lg-12 col-md-12">
                     <div class="section-title-2 text-center">
                        <h1 class="text-blue">
                           <spring:message code="label.siteservicestitle" />
                        </h1>
                        <div class="title-line"></div>
                        <p>
                           <spring:message code="label.siteservicessubtitle" />
                        </p>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-lg-4 col-md-4 col-sm-4">
                     <div class="feature-11 text-center clearfix">
                        <div class="feature-11 text-center mb-30 wow fadeInUp"
                           data-wow-delay="0.2s" data-wow-duration="1.5s ">
                           <div class="feature-11-icon mb-20">
                              <a href="/apr"><span class="icon-calculator"
                                 aria-hidden="true"></span></a>
                           </div>
                           <div class="feature-11-info">
                              <h4 class="text-back pb-10">
                                 <a href="/apr">
                                    <spring:message code="label.siteservice1" />
                                 </a>
                              </h4>
                              <p>
                                 <a href="/apr">
                                    <spring:message
                                       code="label.siteservice1description" />
                                 </a>
                              </p>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4">
                     <div class="feature-11 text-center mb-30 wow fadeInUp "
                        data-wow-delay="0.4s" data-wow-duration="1.5s">
                        <div class="feature-11-icon mb-20">
                           <a href="/leasing"><span class="icon-layers"
                              aria-hidden="true"></span></a>
                        </div>
                        <div class="feature-11-info text-center">
                           <h4 class="text-back pb-10 ">
                              <a href="/leasing">
                                 <spring:message
                                    code="label.siteservice2" />
                              </a>
                           </h4>
                           <p>
                              <a href="/leasing">
                                 <spring:message
                                    code="label.siteservice2description" />
                              </a>
                           </p>
                        </div>
                     </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4">
                     <div class="feature-11 text-center mb-30 wow fadeInUp"
                        data-wow-delay="0.6s" data-wow-duration="1.5s">
                        <div class="feature-11-icon mb-20">
                           <a href="/offersconsulting"><span class="icon-book-open"
                              aria-hidden="true"></span></a>
                        </div>
                        <div class="feature-11-info text-center">
                           <h4 class="text-back pb-10">
                              <a href="/offersconsulting">
                                 <spring:message
                                    code="label.siteservice3" />
                              </a>
                           </h4>
                           <p>
                              <a href="/offersconsulting">
                                 <spring:message
                                    code="label.siteservice3description" />
                              </a>
                           </p>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-lg-4 col-md-4 col-sm-4">
                     <div class="feature-11 text-center mb-30 wow fadeInUp"
                        data-wow-delay="0.8s" data-wow-duration="1.5s">
                        <div class="feature-11-icon mb-20">
                           <a href="/loans"><span class="icon-wallet"
                              aria-hidden="true"></span></a>
                        </div>
                        <div class="feature-11-info text-center">
                           <h4 class="text-back pt-20 pb-10">
                              <a href="/loans">
                                 <spring:message code="label.siteservice4" />
                              </a>
                           </h4>
                           <p>
                              <a href="/loans">
                                 <spring:message
                                    code="label.siteservice4description" />
                              </a>
                           </p>
                        </div>
                     </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4">
                     <div class="feature-11 text-center mb-30 wow fadeInUp"
                        data-wow-delay="1.0s" data-wow-duration="1.5s">
                        <div class="feature-11-icon mb-20">
                           <a href="/discounts"><span class="icon-basket-loaded"
                              aria-hidden="true"></span></a>
                        </div>
                        <div class="feature-11-info text-center">
                           <h4 class="text-back pt-20 pb-10">
                              <a href="/discounts">
                                 <spring:message
                                    code="label.siteservice5" />
                              </a>
                           </h4>
                           <p>
                              <a href="/discounts">
                                 <spring:message
                                    code="label.siteservice5description" />
                              </a>
                           </p>
                        </div>
                     </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4">
                     <div class="feature-11 text-center mb-30 wow fadeInUp"
                        data-wow-delay="1.2s" data-wow-duration="1.5s">
                        <div class="feature-11-icon mb-20">
                           <a href="/reversemortgage"><span class="icon-shuffle"
                              aria-hidden="true"></span></a>
                        </div>
                        <div class="feature-11-info text-center">
                           <h4 class="text-back pt-20 pb-10">
                              <a href="/reversemortgage">
                                 <spring:message
                                    code="label.siteservice6" />
                              </a>
                           </h4>
                           <p>
                              <a href="/reversemortgage">
                                 <spring:message
                                    code="label.siteservice6description" />
                              </a>
                           </p>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="row">
             
                     <div class="section-title-2 text-center">
                     ...
                        <h1> 
                           <a href="/a/services"><spring:message code="label.servicepageaccessmessage" /></a>
                        </h1>
						<p>
                           <spring:message code="label.servicepageaccessmessagesub" />
                        </p>
                  </div>
               </div>
            </div>
         </section>
         <!--=================================
            key-features (services) -->
         <!--=================================
            video-background -->
         <section>
            <div id="video-background" class="video-content bg-opacity-black-30"
               style="width: 100%;"
               data-vide-bg="mp4: /resources/template/video/ulebackground"
               data-vide-options="position: 0% 50%">
               <div class="video-bg bg-opacity-black-50 page-section-pt">
                  <div class="container">
                     <div class="row">
                        <div class="section-title-2 text-center">
                           <h1 class="text-white">
                              <spring:message code="label.knowledge" />
                           </h1>
                           <div class="title-line-2"></div>
                           <p class="text-white mt-20 mb-30">
                              <spring:message code="label.knowledgesub" />
                           </p>
                           <a target="blank" href="/offersconsulting"
                              class="button-border-white">
                              <span>
                                 <spring:message
                                    code="label.knowledgesubmit" />
                              </span>
                           </a>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <!--=================================
            video-background -->
         <!-- About us -->
         <section id="links" class="about page-section-ptb">
            <div class="container">
               <div class="row">
                  <div class="col-lg-12 col-md-12">
                     <div class="section-title-1 text-center">
                        <h1 class="text-blue">
                           <spring:message code="label.aboutus" />
                        </h1>
                        <div class="title-line"></div>
                     </div>
                  </div>
               </div>
               <!--=================================
                  owl-custom -->
               <section class="owl-custom white-bg">
                  <div class="container">
                     <div class="row">
                        <div class="owl-carousel-12">
                           <div class="item">
                              <div class="col-lg-6 col-md-6">
                                 <img class="img-responsive center-block"
                                    src="/resources/template/images/about/uleabout1.jpg" alt="">
                              </div>
                              <div class="col-lg-6 col-md-6">
                                 <div class="custom-content uleaboutus">
                                    <h2 class="text-blue mb-20"><spring:message code="label.aboutus1"/></h2>
                                    <p><spring:message code="label.aboutus1sub1"/>
                                    </p>
                                    
                                 </div>
                              </div>
                           </div>
                           <div class="item">
                              <div class="col-lg-6 col-md-6">
                                 <div class="custom-content uleaboutus">
                                    <h2 class="text-blue mb-30"><spring:message code="label.aboutus2"/></h2>
                                    <p><spring:message code="label.aboutus2sub1"/>
                                    </p>
                                    <ul class="mt-20">
                                       <li><i class="fa fa-hand-o-right"></i> <spring:message code="label.aboutus2sub2"/>
                                       </li>
                                       <li><i class="fa fa-hand-o-right"></i> <spring:message code="label.aboutus2sub3"/>
                                       </li>
                                       <li><i class="fa fa-hand-o-right"></i> <spring:message code="label.aboutus2sub4"/>
                                       </li>
                                       <li><i class="fa fa-hand-o-right"></i> <spring:message code="label.aboutus2sub5"/>
                                       </li>
                                    </ul>
                                 </div>
                              </div>
                              <div class="col-lg-6 col-md-6">
                                 <img class="img-responsive center-block"
                                    src="/resources/template/images/about/uleabout2.jpg" alt="">
                              </div>
                           </div>
                           <div class="item">
                              <div class="col-lg-6 col-md-6">
                                 <img class="img-responsive center-block"
                                    src="/resources/template/images/about/uleabout3.jpg" alt="">
                              </div>
                              <div class="col-lg-6 col-md-6">
                                 <div class="custom-content uleaboutus">
                                    <h2 class="text-blue mb-30"><spring:message code="label.aboutus3"/></h2>
                                    <p><spring:message code="label.aboutus3sub1"/>
                                    </p>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </section>
               <!--=================================
                  owl-custom -->
            </div>
         </section>
         <!-- About us -->
         <!--=================================
            make the good decision -->
         <section id="blog"
            class="bg-4 bg-opacity-black-60 creativity page-section-ptb">
            <div class="container">
               <div class="row">
                  <div class="col-lg-12 col-md-12 text-center">
                     <h1 class="text-white">
                        <spring:message code="label.rightdecision" />
                     </h1>
                     <p class="text-white mt-30 mb-0">
                        <spring:message code="label.freehelp" />
                     </p>
                     <a class="button mt-50" href="/contact">
                        <span>
                           <spring:message
                              code="label.contactways" />
                        </span>
                        <i class="fa fa-info"></i>
                     </a>
                     <a class="button button-white mt-50" target="blank"
                        href="http://lawandfinanceule.blogspot.com.es/">
                        <span>
                           <spring:message
                              code="label.ourblog" />
                        </span>
                        <i class="fa fa-eye"></i>
                     </a>
                  </div>
               </div>
            </div>
         </section>
         <!--=================================
            make the good decision -->
         <!--=================================
            our-team  -->
         <section id="team" class="our-team white-bg page-section-ptb">
            <div class="container">
               <div class="row">
                  <div class="col-lg-12 col-md-12">
                     <div class="section-title-2 text-center">
                        <h2 class="text-blue">
                           <spring:message code="label.meetourteam" />
                        </h2>
                        <div class="title-line"></div>
                        <p>
                           <spring:message code="label.meetourteamsub" />
                        </p>
                     </div>
                  </div>
               </div>
               <div class="team-2">
                  <div style=" display: flex; flex-direction: row; flex-wrap: wrap; justify-content: center ">
					<div class="col-lg-3 col-md-3 col-sm-6">
                        <div class="team-2-box">
                           <img alt="" src="/resources/template/images/team/alexis.jpg"
                              class="img-responsive">
                           <div class="team-overlay text-center">
                              <div class="info">
                                 <h5 class="text-white">Alexis Gutiérrez</h5>
                                 <span>
                                    <spring:message code="label.teamrol2" />
                                 </span>
                              </div>
                              <div class="social">
                                 <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
					<div class="col-lg-3 col-md-3 col-sm-6">
                        <div class="team-2-box">
                           <img alt="" src="/resources/template/images/team/razvan.jpg"
                              class="img-responsive">
                           <div class="team-overlay text-center">
                              <div class="info">
                                 <h5 class="text-white">Razvan Raducu</h5>
                                 <span>
                                    <spring:message code="label.teamrol2" />
                                 </span>
                              </div>
                              <div class="social">
                                 <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-lg-3 col-md-3 col-sm-6">
                        <div class="team-2-box">
                           <img alt="" src="/resources/template/images/team/david.jpg"
                              class="img-responsive">
                           <div class="team-overlay text-center">
                              <div class="info">
                                 <h5 class="text-white">David Fernández</h5>
                                 <span>
                                    <spring:message code="label.teamrol2" />
                                 </span>
                              </div>
                              <div class="social">
                                 <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-lg-3 col-md-3 col-sm-6">
                        <div class="team-2-box">
                           <img alt="" src="/resources/template/images/team/camino.jpg"
                              class="img-responsive">
                           <div class="team-overlay text-center">
                              <div class="info">
                                 <h5 class="text-white">Camino Fernández</h5>
                                 <span>
                                    <spring:message code="label.teamrol1" />
                                 </span>
                              </div>
                              <div class="social">
                                 <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-lg-3 col-md-3 col-sm-6" style="margin-top: 5%">
                        <div class="team-2-box">
                           <img alt="" src="/resources/template/images/team/javier.jpg"
                              class="img-responsive">
                           <div class="team-overlay text-center">
                              <div class="info">
                                 <h5 class="text-white">Javier Castaño</h5>
                                 <span>
                                    <spring:message code="label.teamrol3" />
                                 </span>
                              </div>
                              <div class="social">
                                 <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                     
                     <div class="col-lg-3 col-md-3 col-sm-6" style="margin-top: 5%">
                        <div class="team-2-box">
                           <img alt="" src="/resources/template/images/team/maite.jpg"
                              class="img-responsive">
                           <div class="team-overlay text-center">
                              <div class="info">
                                 <h5 class="text-white">Mar&iacute;a T. Tascón</h5>
                                 <span>
                                    <spring:message code="label.teamrol3" />
                                 </span>
                              </div>
                              <div class="social">
                                 <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                  
                     <div class="col-lg-3 col-md-3 col-sm-6" style="margin-top: 5%">
                        <div class="team-2-box">
                           <img alt="" src="/resources/template/images/team/paula.jpg"
                              class="img-responsive">
                           <div class="team-overlay text-center">
                              <div class="info">
                                 <h5 class="text-white">Paula Castro</h5>
                                 <span>
                                    <spring:message code="label.teamrol3" />
                                 </span>
                              </div>
                              <div class="social">
                                 <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <!--=================================
            our-team -->
            
        
               <!--=================================
action box- -->

<section class="action-box-3">
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-8">
        <h3 class="text-white"><spring:message code="label.happyclients"/></h3>
        <p class="text-white"><spring:message code="label.happyclientssub"/></p>
      </div>
    </div>
  </div>
</section>
 
<!--=================================
action box- -->
               
 <!--=================================
Our happy clients   -->              
<section class="experience pt-40 pb-20 black-bg">
 

   <div class="container">
  
    <div class="owl-carousel-20"> 
      <div class="row item">
         <div class="col-lg-3 col-md-3 col-sm-3">
           <img style="width:285px;" alt="" src="/resources/template/images/clients/uleclient1.jpg">
         </div>
         <div class="col-lg-9 col-md-9 col-sm-9">
           <h3 class="text-white uppercase"><spring:message code="label.happyclients1"/></h3>
           <p class="text-white"><spring:message code="label.happyclients1sub"/>         
           </div>
      </div>
      <div class="row item">
         <div class="col-lg-3 col-md-3 col-sm-3">
           <img style="width:285px;" alt="" src="/resources/template/images/clients/uleclient2.jpg">
         </div>
         <div class="col-lg-9 col-md-9 col-sm-9">
           <h3 class="text-white uppercase"><spring:message code="label.happyclients2"/></h3>
           <p class="text-white"> <spring:message code="label.happyclients2sub"/>
           </div>
           
      </div>
             <div class="row item">
         <div class="col-lg-3 col-md-3 col-sm-3">
           <img style="width:285px;" alt="" src="/resources/template/images/clients/uleclient5.jpg">
         </div>
         <div class="col-lg-9 col-md-9 col-sm-9">
           <h3 class="text-white uppercase"><spring:message code="label.happyclients3"/></h3>
           <p class="text-white"> <spring:message code="label.happyclients3sub"/> 
         </div>
      </div>
      <div class="row item">
         <div class="col-lg-3 col-md-3 col-sm-3">
           <img style="width:285px;" alt="" src="/resources/template/images/clients/uleclient3.jpg">
         </div>
         <div class="col-lg-9 col-md-9 col-sm-9">
           <h3 class="text-white uppercase"><spring:message code="label.happyclients2"/></h3>
           <p class="text-white"><spring:message code="label.happyclients2sub"/>         
           </div>
      </div>
       <div class="row item">
         <div class="col-lg-3 col-md-3 col-sm-3">
           <img style="width:285px;" alt="" src="/resources/template/images/clients/uleclient6.jpg">
         </div>
         <div class="col-lg-9 col-md-9 col-sm-9">
           <h3 class="text-white uppercase"><spring:message code="label.happyclients3"/></h3>
           <p class="text-white"> <spring:message code="label.happyclients3sub"/> 
           </div>
      </div>
   </div>
   </div>
</section>

<!--=================================
Our happy clients   -->
            
            <hr>
            
         <!--=================================
            testimonial (sponsors) -->
         <section id="sponsors"
            class="testimonial-3 bg-17 bg-opacity-black-40 white-bg page-section-ptb">
            <div class="container">
               <div class="row">
                  <div class="col-lg-12 col-md-12 text-center">
                     <h2 class="text-white mb-60">
                        <spring:message code="label.oursponsorstitle"></spring:message>
                     </h2>
                     <div class="owl-carousel-19">
                        <div class="item">
                           <p>
                              <a href="www.unileon.es"><img alt="logoule"
                                 src="/resources/template/images/sponsors/logo-ule.png"></a>
                           </p>
                           <span>Universidad de León</span><br> <span><a
                              href="www.unileon.es">Acceder</a></span>
                        </div>
                        <div class="item">
                           <p>
                              <a href="http://centros.unileon.es/eiii/"><img
                                 alt="logoule"
                                 src="/resources/template/images/sponsors/logo-ule.png" /></a>
                           </p>
                           <span>Escuela de Ingenierías</span><br> <span><a
                              href="http://centros.unileon.es/eiii/">Acceder</a></span>
                        </div>
                        <div class="item">
                           <p>
                              <a href="http://economicas.unileon.es/"><img alt="logoule"
                                 src="/resources/template/images/sponsors/logo-ule.png" /></a>
                           </p>
                           <span>Facultad de Ciencias Económicas y Empresariales</span><br>
                           <span><a href="http://economicas.unileon.es/">Acceder</a></span>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <!--=================================
            testimonial (sponsors)-->
         <!--=================================
            External Links (Interest)-->
         <section id="links" class="about page-section-ptb">
            <div class="container">
               <div class="row">
                  <div class="col-lg-12 col-md-12">
                     <div class="section-title-1 text-center">
                        <h1 class="text-blue">
                           <spring:message code="label.interestlinks" />
                        </h1>
                        <div class="title-line"></div>
                        <p>
                           <spring:message code="label.interestlinkssub" />
                        </p>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-lg-6 col-md-6">
                     <div class="who-we-are-left">
                        <h3 class="text-blue mb-20 text-center">
                           <a href="https://www.unileon.es" target="_blank">
                              <spring:message
                                 code="label.interestlink1" />
                           </a>
                        </h3>
                        <h3 class="text-blue mb-20 text-center">
                           <a href="http://www.economicas.unileon.es" target="_blank">
                              <spring:message
                                 code="label.interestlink2" />
                           </a>
                        </h3>
                        <h3 class="text-blue mb-20 text-center">
                           <a href="http://www.imf.org/external/index.htm" target="_blank">
                              <spring:message
                                 code="label.interestlink3" />
                           </a>
                        </h3>
                        <h3 class="text-blue mb-20 text-center">
                           <a href="http://www.bancomundial.org" target="_blank">
                              <spring:message
                                 code="label.interestlink4" />
                           </a>
                        </h3>
                     </div>
                  </div>
                  <div class="col-lg-6 col-md-6">
                     <div class="who-we-are-left">
                        <h3 class="text-blue mb-20 text-center">
                           <a href="http://lawandfinanceule.blogspot.com.es/"
                              target="_blank">
                              <spring:message code="label.interestlink5" />
                           </a>
                        </h3>
                        <h3 class="text-blue mb-20 text-center">
                           <a href="http://www.bde.es/bde/es/" target="_blank">
                              <spring:message
                                 code="label.interestlink6" />
                           </a>
                        </h3>
                        <h3 class="text-blue mb-20 text-center">
                           <a href="https://www.ecb.europa.eu/home/html/index.en.html"
                              target="_blank">
                              <spring:message code="label.interestlink7" />
                           </a>
                        </h3>
                        <h3 class="text-blue mb-20 text-center">
                           <a href="http://www.mineco.gob.es/portal/site/mineco/"
                              target="_blank">
                              <spring:message code="label.interestlink8" />
                           </a>
                        </h3>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <!--=================================
            External Links (Interest)-->
         <!--=================================
            map-->
         <section id="contact"
            class="white-bg contact clearfix page-section-pt">
            <div class="container">
               <div class="row">
                  <div class="col-lg-12 col-md-12">
                     <div class="section-title text-center">
                        <h1 class="text-blue">
                           <spring:message code="label.getintouch" />
                        </h1>
                        <div class="title-line"></div>
                        <p>
                           <spring:message code="label.getintouchsub" />
                        </p>
                     </div>
                  </div>
               </div>
            </div>
            <div class="container-fluid">
               <div class="contact-map">
                  <iframe
                     src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d11744.720547149747!2d-5.567375190484793!3d42.61513548195593!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd379a96402735cb%3A0x3f44569fb640efd5!2sUniversity+of+Le%C3%B3n!5e0!3m2!1sen!2ses!4v1487545508683"
                     width="100%" height="300" frameborder="0" style="border: 0"
                     allowfullscreen></iframe>
               </div>
            </div>
            <div class="col-lg-12 col-md-12">
               <div class="section-title text-center">
                  <h2 class="text-blue">
                     <spring:message code="label.contactifyouprefer" />
                  </h2>
                  <h1 class="text-red">
                     <a href="/contact">
                        <spring:message code="label.contactform" />
                     </a>
                  </h1>
               </div>
            </div>
         </section>
         <!--=================================
            social -->
         <section class="social-full white-bg">
            <div class="container-fluid">
               <ul>
                  <li><a class="fb" href="#"><i class="fa fa-facebook"></i></a></li>
                  <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                  <li><a class="pinterest" href="#"><i
                     class="fa fa-pinterest-p"></i></a></li>
                  <li><a class="vimeo" href="#"><i class="fa fa-vimeo"></i></a></li>
                  <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
                  <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                  <li><a class="rss" href="#"><i class="fa fa-rss"></i></a></li>
                  <li><a class="behance" href="#"><i class="fa fa-behance"></i></a></li>
               </ul>
            </div>
         </section>
         <!--=================================
            social -->
         <!--=================================
            footer -->
         <footer id="contact2" class="footer-4 page-section-pt">
            <div class="container">
               <div class="row">
                  <div class="col-lg-3 col-md-3 col-sm-6">
                     <div class="get-in-touch footer-hedding">
                        <h4 class="text-blue mb-20">
                           <spring:message code="label.getintouch" />
                        </h4>
                        <div class="contact-add">
                           <i class="fa fa-map-marker"></i>
                           <p class="mt-15 mb-15 text-white">Campus Universitario de
                              Vegazana, S/N, 24071 León
                           </p>
                        </div>
                        <div class="contact-add">
                           <i class="fa fa-phone"></i>
                           <p class="mt-15 mb-15 text-white">987 29 10 00 (ES)</p>
                        </div>
                        <div class="contact-add">
                           <i class="fa fa-envelope-o"></i>
                           <p class="mt-15 mb-15 text-white">
                              <spring:message code="label.contactemail"/>
                           </p>
                        </div>
                     </div>
                  </div>
                  <div class="col-lg-3 col-md-3 col-sm-6">
                     <div class="office-hours footer-hedding">
                        <h4 class="text-blue mb-20">
                           <spring:message code="label.siteofficehours" />
                        </h4>
                        <p>Mon-Fri : 10 a.m. – 7 p.m. (GMT +1)</p>
                        <p>Saturday : 9 a.m. – 1 p.m. (GMT +1)</p>
                        <img src="/resources/template/images/clock.png" alt="">
                     </div>
                  </div>
                  <div class="col-lg-3 col-md-3 col-sm-6">
                     <div class="tags footer-hedding">
                        <h4 class="text-blue mb-20">
                           <spring:message code="label.sitetopsearch" />
                        </h4>
                        <ul>
                           <li>
                              <a href="/apr">
                                 <spring:message
                                    code="label.siteservice1" />
                              </a>
                           </li>
                           <li>
                              <a href="/offersconsulting">
                                 <spring:message
                                    code="label.siteservice3" />
                              </a>
                           </li>
                           <li>
                              <a href="/discounts">
                                 <spring:message
                                    code="label.siteservice5" />
                              </a>
                           </li>
                           <li>
                              <a href="/creditaccount">
                                 <spring:message
                                    code="label.siteservice7" />
                              </a>
                           </li>
                        </ul>
                     </div>
                  </div>
                  <div class="col-lg-3 col-md-3 col-sm-6">
                     <div class="footer-useful-link footer-hedding">
                        <h4 class="text-blue mb-20">Latest Tweets</h4>
                        <ul class="twitter-feed">
                           <li>
                              <i class="fa fa-twitter"></i>
                              <p class="text-white">
                                 Our brand new website builder, Envato Sites, has just launched
                                 into private beta! <a href=""> http://enva.to/nKqxx </a>
                              </p>
                           </li>
                           <li>
                              <i class="fa fa-twitter"></i>
                              <p class="text-white">
                                 Get your photo on Unstock and win prizes. <a href="#">http://enva.to/unstock</a>
                              </p>
                           </li>
                        </ul>
                     </div>
                  </div>
               </div>
            </div>
         </footer>
         <!--=================================
            Footer-->
         <jsp:include page="/WEB-INF/views/footer.jsp" />
         <!--=================================
            Footer-->
         <!--=================================
            popup contact -->
         <div class="popup-contact">
            <div class="popup-contact-box">
               <a href="#" id="contact-btn"><i class="fa fa-envelope-o"></i></a>
               <div class="contact-info clearfix">
                  <h4 class="mb-30">Send us a message</h4>
                  <div id="formmessage-2">Success/Error Message Goes Here</div>
                  <form class="form-horizontal" id="contactform-2" role="form"
                     method="post" action="php/contact-form-2.php">
                     <div class="contact-form">
                        <div class="section-field">
                           <div class="field-widget">
                              <i class="fa fa-user"></i> <input id="name" type="text"
                                 placeholder="Name*" name="name">
                           </div>
                        </div>
                        <div class="section-field">
                           <div class="field-widget">
                              <i class="fa fa-envelope-o"></i> <input type="email"
                                 placeholder="Email*" name="email">
                           </div>
                        </div>
                        <div class="section-field clearfix">
                           <div class="field-widget">
                              <i class="fa fa-pencil"></i>
                              <textarea class="input-message" placeholder="Comment*" rows="3"
                                 name="message"></textarea>
                           </div>
                        </div>
                        <input type="hidden" name="action" value="sendEmail" />
                        <button id="submit-2" name="submit" type="submit" value="Send"
                           class="button-border pull-right clearfix">
                        <span>Send</span>
                        </button>
                     </div>
                  </form>
                  <div id="ajaxloader-2" style="display: none">
                     <img class="center-block mt-30 mb-30"
                        src="/resources/template/images/ajax-loader.gif" alt="">
                  </div>
               </div>
            </div>
         </div>
         <!--=================================
            popup contact -->
      </div>
      <div id="back-to-top">
         <a class="top arrow" href="#top"><i class="fa fa-long-arrow-up"></i></a>
      </div>
      <!--=================================
         jquery -->
      <!-- jquery  -->
      <script type="text/javascript"
         src="/resources/template/js/jquery.min.js"></script>
      <!-- bootstrap -->
      <script type="text/javascript"
         src="/resources/template/js/bootstrap.min.js"></script>
      <!-- plugins-jquery -->
      <script type="text/javascript"
         src="/resources/template/js/plugins-jquery.js"></script>
      <!-- mega menu -->
      <script type="text/javascript"
         src="/resources/template/js/mega-menu/mega_menu.js"></script>
      <!-- hover -->
      <script type="text/javascript"
         src="/resources/template/js/portfolio/jquery.directional-hover.js"></script>
      <!-- socialstream -->
      <script src="/resources/template/js/social/socialstream.jquery.js"></script>
      <!-- videoBG -->
      <script src="/resources/template/js/video/jquery.vide.js"></script>
      <!-- popup -->
      <script src="/resources/template/js/popup/jquery.magnific-popup.js"></script>
      <!-- isotope -->
      <script src="/resources/template/js/isotope/isotope.pkgd.min.js"></script>
      <!-- Wow -->
      <script type="text/javascript" src="/resources/template/js/wow.min.js"></script>
      <!-- custom -->
      <script type="text/javascript" src="/resources/template/js/custom.js"></script>
      <!--Start Cookie Script-->
      <script type="text/javascript"
         src="/resources/template/js/cookie-bar-master/cookiebar-latest.js?tracking=1&thirdparty=1&scrolling=1&always=1&blocking=1&privacyPage=cookies"></script>
      <!--End Cookie Script-->
   </body>
</html>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
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
      <title>Office coming soon</title>

<body>

<div class="page-wrapper">

<!--=================================
 preloader -->
 
<div id="preloader">
  <div class="clear-loading loading-effect"> <span></span> </div>
</div>

<!--=================================
 preloader -->

<div class="coming-soon">

<!--=================================
 header -->

		<!--=================================
 header -->
		<jsp:include page="/WEB-INF/views/header.jsp" />

		<!--=================================
 header -->
 

<!--=================================
 inner-intro-->

<section class="inner-intro bg-office bg-opacity-black-70">
  <div class="container">
     <div class="row text-center intro-title">
            <h1 class="text-blue">Coming Soon</h1>
            <p class="text-white">Please come back in sometime</p>
            <ul class="page-breadcrumb">
              <li><a href=""><i class="fa fa-home"></i> Home</a> <i class="fa fa-angle-double-right"></i></li>
              <li>Office</li>
           </ul>
     </div>
  </div>
</section>

<!--=================================
 inner-intro-->


<!--=================================
 Coming Soon-->
<div class="bg-httperror-404 bg-opacity-black-70">
<section class="coming-soon-main maintenance-progress-bar page-section-ptb clearfix">
  <div class="container">
    <div class="row">
       <div class="col-lg-12 col-md-12">
          <div class="text-center">
              <i class="fa fa-clock-o"></i>
              <h1 class="text-blue">Coming soon</h1>
              <p class="text-white">We are currently working on a website and won't take long. Don't forget to check out our Social updates.</p>
          </div>
          <div class="coming-soon-countdown countdown">
            <ul class="countdown">
              <li> <span class="days">00</span>
              <p class="days_ref">days</p>
              </li>
              <li> <span class="hours">00</span>
              <p class="hours_ref">hours</p>
              </li>
              <li> <span class="minutes">00</span>
              <p class="minutes_ref">minutes</p>
              </li>
              <li> <span class="seconds">00</span>
              <p class="seconds_ref">seconds</p>
              </li>
              </ul>
          </div>
           <div class="coming-soon-form text-center">
           <p>Provide your email address & we will notify you when site is ready:</p>
           <div class="clearfix">
             <input   type="text" placeholder="Email address" name="email">
             <a href="#" class="button-border pull-right"> <span>Notify Me</span> </a>
           </div>
         </div> 
      </div>
    </div>
  </div>
 </section>
</div>
<!--=================================
 Coming Soon-->
 
 </div>
 

 
<!--=================================
 Footer-->
		<jsp:include page="/WEB-INF/views/footer.jsp" />
		<!--=================================
 Footer-->


 <!--=================================
 popup-contact -->

<div class="popup-contact">
 <div class="popup-contact-box">
  <a href="#" id="contact-btn"><i class="fa fa-envelope-o"></i></a> 
  <div class="contact-info clearfix">
    <h4 class="mb-30">Send us a message</h4>
    <div id="formmessage-2">Success/Error Message Goes Here</div>
     <form class="form-horizontal" id="contactform-2" role="form" method="post" action="php/contact-form-2.php">
        <div class="contact-form">
        <div class="section-field">
            <div class="field-widget">
            <i class="fa fa-user"></i>  
            <input id="name" type="text" placeholder="Name*"  name="name">
          </div> 
         </div>
         <div class="section-field">
            <div class="field-widget">
            <i class="fa fa-envelope-o"></i>
             <input type="email" placeholder="Email*" name="email">
          </div> 
         </div>
         <div class="section-field clearfix">
          <div class="field-widget">
               <i class="fa fa-pencil"></i>
               <textarea class="input-message"  placeholder="Comment*" rows="3" name="message"></textarea>
            </div>
          </div>
          <input type="hidden" name="action" value="sendEmail"/>
             <button id="submit-2" name="submit" type="submit" value="Send" class="button-border pull-right clearfix"><span>Send</span></button>
             </div> 
         </form>
       <div id="ajaxloader-2" style="display:none"><img class="center-block mt-30 mb-30" src="resources/template/images/ajax-loader.gif" alt=""></div>
    </div>
 </div>
</div>

 <!--=================================
 popup-contact -->

 </div>
 
<div id="back-to-top"><a class="top arrow" href="#top"><i class="fa fa-long-arrow-up"></i></a></div>
 
<!--=================================
 jquery -->

<!-- jquery  -->
<script type="text/javascript" src="/resources/template/js/jquery.min.js"></script>

<!-- bootstrap -->
<script type="text/javascript" src="/resources/template/js/bootstrap.min.js"></script>

<!-- plugins-jquery -->
<script type="text/javascript" src="/resources/template/js/plugins-jquery.js"></script>

<!-- appear -->
<script src="/resources/template/js/jquery.appear.js"></script>

<!-- mega menu -->
<script type="text/javascript" src="/resources/template/js/mega-menu/mega_menu.js"></script>
 
<!-- countdown -->
<script src="/resources/template/js/countdown/jquery.downCount.js"></script>

<!-- progressbar -->
<script type="text/javascript" src="/resources/template/js/skills-graph/jQuery-plugin-progressbar.js"></script>

<!-- custom -->
<script type="text/javascript" src="/resources/template/js/custom.js"></script>
 <script class="source" type="text/javascript">
        $('.countdown').downCount({
            date: '05/07/2017 12:00:00',
            offset: +2
        }, function () {
            //alert('WOOT WOOT, done!');
        });
    </script>
</body>
</html>

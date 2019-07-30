<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="keywords" content="HTML5 Template" />
<meta name="description" content="Contact form" />
<meta name="author" content="Razvan Raducu, Camino Fernández" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

<jsp:include page="/WEB-INF/views/OpenGraph.jsp" />
      <meta property="og:determiner" content="the" />
      <meta property="og:title" content="<spring:message code='label.contactways' />" />
      <meta property="og:url" content="http://ulebank.unileon.es/contact" />
      <meta property="og:description" content="<spring:message code='label.contacttogether'/>"/>


<title><spring:message code="label.contactways"/></title>

<!-- Favicon -->
<link rel="shortcut icon" href="resources/template/images/favicon.ico" />

<!-- bootstrap -->
<link href="resources/template/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<!-- plugins -->
<link href="resources/template/css/plugins-css.css" rel="stylesheet" type="text/css" />

<!-- mega menu -->
<link href="resources/template/css/mega-menu/mega_menu.css" rel="stylesheet" type="text/css" />

 <!-- default -->
<link href="resources/template/css/default.css" rel="stylesheet" type="text/css" />

<!-- main style -->
<link href="resources/template/css/style.css" rel="stylesheet" type="text/css" />

<!-- responsive -->
<link href="resources/template/css/responsive.css" rel="stylesheet" type="text/css" />

<!-- custom style -->
<link href="resources/template/css/custom.css" rel="stylesheet" type="text/css" />

</head>

<body>

<div class="page-wrapper">

<!--=================================
 preloader -->
 
<div id="preloader">
  <div class="clear-loading loading-effect"> <span></span> </div>
</div>

<!--=================================
 preloader -->


<!--=================================
 header -->
		<jsp:include page="/WEB-INF/views/header.jsp" />

		<!--=================================
 header -->

<!--=================================
 mega menu -->




<!--=================================
 inner-intro-->

<section class="inner-intro bg-contactform bg-opacity-black-70">
  <div class="container">
     <div class="row text-center intro-title">
            <h1 class="text-blue"><spring:message code="label.contactways"/></h1>
            <p class="text-white"><spring:message code="label.contacttogether"/></p>
            <ul class="page-breadcrumb">
              <li><a href="/"><i class="fa fa-home"></i> <spring:message code="label.sitehome"/></a> <i class="fa fa-angle-double-right"></i></li>
              <li><span><spring:message code="label.contactform"/></span> </li>
           </ul>
     </div>
  </div>
</section>

<!--=================================
 inner-intro-->


<!--=================================
 map-->

<section class="white-bg contact-3 clearfix page-section-pt">
  <div class="container">
    <div class="row">
     <div class="col-lg-12 col-md-12">
      <div class="section-title-1 text-center">
        <h1 class="text-blue"><spring:message code="label.contactinformation"/></h1>
        <div class="title-line"></div>
        <p><spring:message code="label.contactformwehelp"/></p>
       </div>
      </div>
     </div>
   </div>
   <!-- =============================== -->
   <div class="co-plr">
   <div class="container-fluid">
    <div class="row">
    <div class="col-lg-6 col-md-6">
       <div class="contact-map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d11744.720547149747!2d-5.567375190484793!3d42.61513548195593!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd379a96402735cb%3A0x3f44569fb640efd5!2sUniversity+of+Le%C3%B3n!5e0!3m2!1sen!2ses!4v1487545508683" width="100%" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>
   </div>       
  </div>
  <div class="col-lg-6 col-md-6"> 
    <div class="bg-contactform contact-3-info bg-opacity-black-80">
      <div class="clearfix">
           <h2 class="text-white"><spring:message code="label.contact"/></h2>
           <p class="text-white mb-50"><spring:message code="label.contacthearfromyou"/><span class="tooltip-content-2" data-original-title="<spring:message code="label.timezone"/>" data-toggle="tooltip" data-placement="top"> <spring:message code="label.contact24hours"/></span></p>
            <div id="formmessage">Success/Error Message Goes Here</div>
             <form class="form-horizontal" id="contactform" role="form" method="post" action="resources/template/php/contact-form.php">
               <div class="contact-form clearfix">
                  <div class="section-field">
                    <i class="fa fa-user"></i>
                    <input id="name" type="text" placeholder="<spring:message code="label.name"/>"*  name="name">
                   </div> 
                   <div class="section-field">
                      <i class="fa fa-envelope-o"></i>
                      <input type="email" placeholder="<spring:message code="label.email"/>*" name="email">
                    </div>
                   <div class="section-field">
                      <i class="fa fa-phone"></i>
                      <input type="text" placeholder="<spring:message code="label.phone"/>*" name="phone">
                    </div>
                   <div class="section-field textarea">
                     <i class="fa fa-pencil"></i>
                     <textarea class="input-message" placeholder="<spring:message code="label.message"/>*" rows="7" name="message"></textarea>
                    </div>
                    <input type="hidden" name="action" value="sendEmail"/>
                     <button id="submit" name="submit" type="submit" value="Send" class="button mt-15"><span> <spring:message code="label.sendyourmessage"/> </span> <i class="fa fa-paper-plane"></i></button>
                    </div> 
                  </form>
                 <div id="ajaxloader" style="display:none"><img class="center-block mt-30 mb-30" src="resources/template/images/ajax-loader-white.gif" alt=""></div>
              </div>
<!-- =================================== -->
           <div class="row mt-30 pt-30">
            <div class="col-lg-4 col-md-4 col-sm-4"> 
             <div class="contact-add">
               <i class="fa fa-map-marker"></i>
               <p class="text-white">Universidad de León<br> Campus Vegazana, S/N, León, España</p>
              </div>
             </div>
             <div class="col-lg-4 col-md-4 col-sm-4">
              <div class="contact-add">
               <i class="fa fa-phone"></i>
               <p class="text-white">+0123 456 789<br> +0123 456 789</p>
              </div>
             </div>
             <div class="col-lg-4 col-md-4 col-sm-4">
             <div class="contact-add">
               <i class="fa fa-envelope-o"></i>
               <p class="text-white"> <spring:message code="label.contactemail"/><br> </p>
             </div>
           </div>
          </div>
         </div>
<!-- =================================== -->
    </div>
   </div>
  </div>
 </div>
</section>

<!--=================================
map -->

 
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
<script type="text/javascript" src="resources/template/js/jquery.min.js"></script>

<!-- bootstrap -->
<script type="text/javascript" src="resources/template/js/bootstrap.min.js"></script>

<!-- plugins-jquery -->
<script type="text/javascript" src="resources/template/js/plugins-jquery.js"></script>

<!-- mega menu -->
<script type="text/javascript" src="resources/template/js/mega-menu/mega_menu.js"></script>
 
<!-- custom -->
<script type="text/javascript" src="resources/template/js/custom.js"></script>
  
</body>
</html>

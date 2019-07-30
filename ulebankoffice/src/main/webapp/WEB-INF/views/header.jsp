<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--Start Cookie Script-->
      <script type="text/javascript"
         src="/resources/template/js/cookie-bar-master/cookiebar-latest.js?tracking=1&thirdparty=1&scrolling=1&always=1&blocking=1&privacyPage=cookies"></script>
      <!--End Cookie Script-->

<header id="header" class="header-4">
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
                        <li><a href="/"><img id="logo_img"
                           src="/resources/template/images/logo.png" alt="logo"> </a></li>
                     </ul>
                     <!-- menu links -->
                     <ul class="menu-links">
                        <!-- active class -->
                        <li class="page-scroll">
                           <a href="/">
                              <spring:message
                                 code="label.sitehome" />
                           </a>
                        </li>
                        <li class="page-scroll">
                           <a>
                              <spring:message
                                 code="label.siteservices" />
                              <i
                                 class="fa fa-angle-down fa-indicator"></i>
                           </a>
                           <!-- drop down full width -->
                           <div class="drop-down menu-bg grid-col-3">
                              <!--grid row-->
                              <div class="grid-row">
                                 <!--grid column 3-->
                                 <div class="row" style="border-bottom: 1px solid #00a8d9;" >
                                    <h3>
                                       <a href="/a/services" style="text-align:center; font-weight:bold;" >
                                          <spring:message code="label.accessservicepage" />
                                       </a>
                                    </h3>
                                 </div>
                                 <ul>
                                    <li class="uleservicegroup">
                                       <spring:message
                                          code="label.servicegroup1" />
                                    </li>
<!--                                     <li class="uleserviceheader"> -->
<%--                                        <spring:message --%>
<%--                                           code="label.serviceheader1" /> --%>
<!--                                     </li> -->
                                    <li>
                                       <a href="/apr">
                                          <i class="fa fa-angle-double-right"></i>
                                          <spring:message
                                             code="label.siteservice1" />
                                       </a>
                                    </li>
                                    <li>
                                       <a href="/a/aprv">
                                          <i class="fa fa-angle-double-right"></i>
                                          <spring:message
                                             code="label.siteservice1-2" />
                                       </a>
                                    </li>
<!--                                     <li class="uleserviceheader"> -->
<%--                                        <spring:message --%>
<%--                                          code="label.serviceheader2" /> --%>
<!--                                     </li> -->
                                    <li>
                                       <a href="/reversemortgage">
                                          <i class="fa fa-angle-double-right"></i>
                                          <spring:message
                                             code="label.siteservice6" />
                                       </a>
                                    </li>
<!--                                     <li> -->
<!--                                        <a href="/a/deposits"> -->
<!--                                           <i class="fa fa-angle-double-right"></i> -->
<%--                                           <spring:message --%>
<%--                                              code="label.siteservice8" /> --%>
<!--                                        </a> -->
<!--                                     </li> -->
<!--                                     <li> -->
<!--                                        <a href="/a/transactionaccount"> -->
<!--                                           <i class="fa fa-angle-double-right"></i> -->
<%--                                           <spring:message --%>
<%--                                              code="label.siteservice9" /> --%>
<!--                                        </a> -->
<!--                                     </li> -->
<!--                                     <li class="uleserviceheader"> -->
<%--                                        <spring:message --%>
<%--                                           code="label.serviceheader3" /> --%>
<!--                                     </li> -->
                                    <li>
                                       <a href="/creditaccount">
                                          <i class="fa fa-angle-double-right"></i>
                                          <spring:message
                                             code="label.siteservice7" />
                                       </a>
                                    </li>
                                    <li>
                                       <a href="/loans">
                                          <i class="fa fa-angle-double-right"></i>
                                          <spring:message
                                             code="label.siteservice4" />
                                       </a>
                                    </li>
                                    <li>
                                       <a href="/discounts">
                                          <i class="fa fa-angle-double-right"></i>
                                          <spring:message
                                             code="label.siteservice5" />
                                       </a>
                                    </li>
                                    <li>
                                       <a href="/leasing">
                                          <i class="fa fa-angle-double-right"></i>
                                          <spring:message
                                             code="label.siteservice2" />
                                       </a>
                                    </li>
<!--                                     <li class="uleserviceheader"> -->
<%--                                        <spring:message --%>
<%--                                           code="label.serviceheader4" /> --%>
<!--                                     </li> -->
<!--                                     <li><a href=""><i class="fa fa-angle-double-right"></i>Servicio</a></li> -->
<!--                                     <li><a href=""><i class="fa fa-angle-double-right"></i>Servicio</a></li> -->
<!--                                     <li><a href=""><i class="fa fa-angle-double-right"></i>Servicio</a></li> -->
<!--                                     <li class="uleserviceheader"> -->
<%--                                        <spring:message --%>
<%--                                           code="label.serviceheader5" /> --%>
<!--                                     </li> -->
<!--                                     <li><a href=""><i class="fa fa-angle-double-right"></i>Servicio</a></li> -->
<!--                                     <li><a href=""><i class="fa fa-angle-double-right"></i>Servicio</a></li> -->
<!--                                     <li><a href=""><i class="fa fa-angle-double-right"></i>Servicio</a></li> -->
                                    <li class="uleservicegroup">
                                       <spring:message
                                      code="label.servicegroup2" />
                                    </li>
                                    <li>
                                       <a href="/offersconsulting">
                                          <i class="fa fa-angle-double-right"></i>
                                          <spring:message
                                             code="label.siteservice3access" />
                                       </a>
                                    </li>
                                 </ul>
                              </div>
                           </div>
                        </li>
                        <li>
                           <a>
                              <spring:message
                                 code="label.language" />
                              <i
                                 class="fa fa-angle-down fa-indicator"></i>
                           </a>
                           <!-- drop down multilevel  -->
                           <ul class="drop-down-multilevel right-menu">
                              <li><a href="?language=en">English <img class="languageflag" src="/resources/template/images/feature/ENflag.jpg"/></a></li>
                              <li><a href="?language=es">Español <img class="languageflag" src="/resources/template/images/feature/ESflag.jpg"/></a></li>
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
                              </div>
                           </div>
                        </li>
                       	<sec:authorize access="isAuthenticated()">
                        <li>
                        <a href="/o/logout">
                              <spring:message
                                 code="label.logout" />
                           </a>
                        </li>
                        </sec:authorize>
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
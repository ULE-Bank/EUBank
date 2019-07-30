<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include.jsp"%>
<footer id="contact2" class="footer-4 ">
   <div class="footer-widget mt-10">
      <div class="container">
         <div class="row">
            <div class="pr-0 col-lg-4 col-md-3 col-sm-3">
               <p class="text-white mt-15">
                  &copy;Copyright 
                  <span id="copyright">
                     <script>
                        document.getElementById('copyright').appendChild(
                        		document.createTextNode(new Date()
                        				.getFullYear()))
                     </script>
                  </span>
                  <a href="/"> ULe-Bank </a>
                  <spring:message code="label.siterights" />
               </p>
            </div>
            <div class="pl-0 pr-0 col-lg-2 col-md-2 col-sm-2">
               <p class="text-white mt-15">
                  <span id="copyright"></span> 
                  <a href="/cookies">
                     <spring:message
                        code="label.cookiespolicy" />
                  </a>
               </p>
            </div>
            <div class="pl-0 col-lg-2 col-md-2 col-sm-2">
               <p class="text-white mt-15">
                  <span id="copyright"></span> 
                  <a href="/contact">
                     <spring:message
                        code="label.contact" />
                  </a>
               </p>
            </div>
         </div>
         <div class="row">
            <div class="pr-0 col-lg-4 col-md-9 col-sm-9 ">
               <a href="https://www.unileon.es"><img id="logo_img"
                  src="/resources/template/images/sponsors/logo-ule.png" alt="logo"></a>
            </div>
            <div class="pl-0 col-lg-2 col-md-4 col-sm-4">
               <p class="text-white mt-15">
                  <span id="copyright"></span> 
                  <a href="/sitemap">
                     <spring:message
                        code="label.sitemap" />
                  </a>
               </p>
            </div>
            <div class="pl-0 col-lg-2 col-md-4 col-sm-4">
               <p class="text-white mt-15">
                  <span id="copyright"></span> 
                  <a href="/search">
                     <spring:message
                        code="label.ulebanksearch" />
                  </a>
               </p>
            </div>
         </div>
      </div>
   </div>
</footer>
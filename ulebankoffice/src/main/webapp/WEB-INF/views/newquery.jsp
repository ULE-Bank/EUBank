<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />

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
<link rel="shortcut icon" href="/../favicon.ico" type="image/gif" />

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

<title><spring:message code="label.newquery" /></title>

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

		<section class="inner-intro grayscale bg-newquery bg-opacity-black-70">
			<div class="container">
				<div class="row text-center intro-title">
					<h1 class="text-blue">
						<spring:message code="label.newquery" />
					</h1>
					<p class="text-white">
						<spring:message code="label.siteservice3description" />
					</p>
					<ul class="page-breadcrumb">
						<li><a href="./"><i class="fa fa-home"></i> <spring:message
									code="label.sitehome" /></a> <i class="fa fa-angle-double-right"></i></li>
						<li><a href="/offersconsulting"><spring:message
									code="label.siteservice3" /></a><i
							class="fa fa-angle-double-right"></i></li>
						<li><span><spring:message code="label.newquery" /></span></li>
					</ul>
				</div>
			</div>
		</section>

		<!--=================================
 inner-intro-->

		<section class="white-bg page-section-ptb">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<form:form role="form" method="post" modelAttribute="newQuestion" id="servicesform" enctype="multipart/form-data">
							<div id="register-form" class="register-form">

								<!-- --------- -->


								<div class="row">
									<div class="section-field col-md-11">
										<label for="name"><spring:message code="label.topic" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-11">
										<div class="field-widget">
										<i class="fa fa-exclamation"></i>
											<form:input id="asunto" type="text" path="offerMatter"  />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.queryTopicInfo"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-11">
										<p style="color: red;">
											<form:errors path="offerMatter" />
										</p>
									</div>
								</div>

								<!-- --------- -->


								<div class="row">
									<div class="section-field col-md-11">
										<label for="name"><spring:message
												code="label.yourQuery" /></label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-11">
										<div class="field-widget">
											<form:textarea id="descrption" path="offerText" rows="4"
												required="required" />
										</div>
									</div>
									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi8"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>


								<div class="row">
									<div class="section-field col-md-11">
										<form:errors style="color: red;" path="offerText"></form:errors>
									</div>
								</div>



								<!-- --------- -->


								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-11">
										<label for="name"><spring:message
												code="label.documentAttach" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-11">
									
									<!--  Duplicating the div would allow more than one file to be uploaded at the same time -->
									
										<div class="file-input">
												<form:input id="doc" type="file" path="files" accept=".pdf, application/pdf"/>
										</div>
									</div>


									<div class="section-field col-md-1">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.documentAttachInfo"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>
								
								<div class="row">
									<div class="section-field col-md-11">
										<p style="color:red;">${param.fileError}</p>
									</div>
								</div>

								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-11">
										<label for="name"><spring:message
												code="label.documentLink" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-11">
										<div class="field-widget">
										<i class="fa fa-link"></i>
											<form:input id="url" type="text" path="offerUrl" />
										</div>
									</div>
									<div class="section-field col-md-1">
									
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.documentLink"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-11">
										<form:errors style="color: red;" path="offerUrl"></form:errors>
									</div>
								</div>




								<!-- --------- -->

								<a class="button mt-20" id="submitservices"
									onclick="document.getElementById('servicesform').submit()">
									<span><spring:message code="label.sendquery" /></span> <i
									class="fa fa-paper-plane"></i>
								</a>
								<!-- En caso de que algún usuario tenga desactivado javascript, saldrá este mensaje por defecto. -->
								<noscript>
									<input type="submit"
										value="<spring:message code="label.sendquery"/>" />
								</noscript>
							</div>

						</form:form>
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

	<!--  file Filter -->

	<script>
	//A lo largo de todo el script se usan arrays porque se tiene en cuenta la posibilidad de que algún día se implemente subida multiarchivos 

var file = document.getElementById('doc');
file.onchange = function(e){
	var controlFile = file.files;
	var fileSize = controlFile[0].size;
	var MAXIMUMSIZE_15_MB = 15*1024*1024;
	
	
	console.log("Filename: " + controlFile[0].name);
    console.log("Type: " + controlFile[0].type);
    console.log("Size: " + fileSize + " bytes");
    var ext = this.value.match(/\.([^\.]+)$/)[1];
    
//     Comprobación muy simple de extensión
    if(ext.toLowerCase() !== 'pdf'){
    	alert("<spring:message code='label.fileNotSupported' javaScriptEscape='true' />");
    	this.value='';
    	this.focus();
    }
    
    if(fileSize > MAXIMUMSIZE_15_MB){
    	alert("<spring:message code='label.fileSizeTooBig' javaScriptEscape='true' />");
    	this.value='';
    	this.focus();
    }
    
    
//     Comprobación de los bytes de la cabecera del archivo. Los magic numbers
    var blob = controlFile[0]; // See step 1 above
    var fileReader = new FileReader();
    fileReader.onload = function(e) {
    	var fileMagicNumbers = new Uint8Array(e.target.result);
    	console.log(fileMagicNumbers);
    	 //verify the magic number
        // for PDF is 25 50 44 46 (see https://en.wikipedia.org/wiki/List_of_file_signatures)
        if(!fileMagicNumbers.length>4 || fileMagicNumbers[0]!=0x25 || 
        		fileMagicNumbers[1]!=0x50 || fileMagicNumbers[2]!=0x44 || 
        		fileMagicNumbers[3]!=0x46) {
            alert("<spring:message code='label.fileContentNotSupported' javaScriptEscape='true' />");
            $("#doc").val(""); // Reiniciar el selector de archivo
            return;
        }
    };
    fileReader.readAsArrayBuffer(blob);
};


</script>



	<!--  file Filter -->


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
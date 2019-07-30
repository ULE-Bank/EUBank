window.onload = function() {
	if($.cookie('cookies-accepted') == undefined) {
		$("#cookies-alert").removeClass("hidden");
	}
	
	$(".close").click(function() {
		$.cookie('cookies-accepted', '1');
		$("#cookies-alert").addClass("hidden");
	});
};
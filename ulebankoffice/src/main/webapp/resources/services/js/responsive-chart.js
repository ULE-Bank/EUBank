var fullSize = true;

function resizeChart() {
	var win = $(this);
	var canvas = document.getElementById("myChart");

	if (win.width() <= 992) {
		canvas.width  = 400;
		canvas.height = 200;
		fullSize = false;
	}
	else {
		canvas.width  = 600;
		canvas.height = 300;
		fullSize = true;
	}
}

$(window).on('resize', function(){
	var win = $(this);
	var canvas = document.getElementById("myChart");

	if (win.width() < 992) {
		if(fullSize) {
			canvas.width  = 400;
			canvas.height = 200;
			drawChart();
			fullSize = false;
		}
	}
	else {
		if(!fullSize) {
			canvas.width  = 600;
			canvas.height = 300;
			drawChart();
			fullSize = true;
		}
	}
});
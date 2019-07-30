window.onload = function() {
	
	if($.cookie("resultados") == "1") {
		$('#modalResultados').modal('show'); 
		$.cookie("resultados", null);
	}
	
	var value = document.getElementById("p").value;
	
	if(value != 0) {
		if(value == 6) {
			document.getElementById("range").value = "5";
		}
		else if(value == 12) {
			document.getElementById("range").value = "6";
		}
		else {
			document.getElementById("range").value = value;
		}
	}
	
	rangeListener();
	//Pensar mejor solucion para el window.onload
	resizeChart();
};

function rangeListener() {
	var range = document.getElementById("range").value;
    
    var element = document.getElementById("p");
    
    if(range == 1) {
    	document.getElementById("p-expl").innerHTML = "1 - anual";
        element.value = 1;
    }
    else if(range == 2) {
    	document.getElementById("p-expl").innerHTML = "2 - semestral";
        element.value = 2;
    }
    else if(range == 3) {
    	document.getElementById("p-expl").innerHTML = "3 - cuatrimestral";
        element.value = 3;
    }
    else if(range == 4) {
    	document.getElementById("p-expl").innerHTML = "4 - trimestral";
        element.value = 4;
    }
    else if(range == 5) {
    	document.getElementById("p-expl").innerHTML = "6 - bimensual";
        element.value = 6;
    }
    else {
    	document.getElementById("p-expl").innerHTML = "12 - mensual";
        element.value = 12;
    }
}
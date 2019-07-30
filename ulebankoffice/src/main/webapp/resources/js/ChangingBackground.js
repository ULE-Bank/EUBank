/**
 * Author: Razvan Raducu
 */

var urls = [ "resources/images/background/1.JPG",
		"resources/images/background/2.JPG",
		"resources/images/background/3.JPG",
		"resources/images/background/4.JPG",
		"resources/images/background/5.JPG",
		"resources/images/background/6.JPG",
		"resources/images/background/7.JPG",
		"resources/images/background/8.JPG",
		"resources/images/background/9.JPG" 
		];

function goRandom() {
	return Math.floor(Math.random() * (urls.length - 1));
	
}

function changeimage(every_seconds) {

	var fondoAleatorio = goRandom();
		// change the image
		document.getElementById("myimage").src = urls[fondoAleatorio];

		// call same function again for x of seconds
		setTimeout("changeimage(" + every_seconds + ")",
				((every_seconds) * 1000));
	

}
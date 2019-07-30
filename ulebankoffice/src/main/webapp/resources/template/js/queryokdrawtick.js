/*
 * Documento incorporado al proyecto por Razvan Raducu. 
 * Este código se encarga de dibujar el tick en pantalla cuando el usuario
 * envía una nueva consulta con éxito. Por el momento sólo he cambiado el color.
 * 
 * Código original: http://stackoverflow.com/questions/26558916/draw-a-check-mark-css-animation-from-left-down-to-right-up
 * 
 * Salve stackoverflow, save us all.
 * 
 * */


var start = 100;
var mid = 145;
var end = 250;
var width = 22;
var leftX = start;
var leftY = start;
var rightX = mid - (width / 2.7);
var rightY = mid + (width / 2.7);
var animationSpeed = 20;

var ctx = document.getElementsByTagName('canvas')[0].getContext('2d');
ctx.lineWidth = width;
ctx.strokeStyle = 'rgba(0,169,218, 1)';

for (i = start; i < mid; i++) {
    var drawLeft = window.setTimeout(function () {
        ctx.beginPath();
        ctx.moveTo(start, start);
        ctx.lineTo(leftX, leftY);
        ctx.stroke();
        leftX++;
        leftY++;
    }, 1 + (i * animationSpeed) / 3);
}

for (i = mid; i < end; i++) {
    var drawRight = window.setTimeout(function () {
        ctx.beginPath();
        ctx.moveTo(leftX, leftY);
        ctx.lineTo(rightX, rightY);
        ctx.stroke();
        rightX++;
        rightY--;
    }, 1 + (i * animationSpeed) / 3);
}
var movesContainer = $('#moves-container');
var movesCounter = 1;

/* Obteniendo las variables internacionalizadas del código html*/
var mDescription = strings['movimiento.descripcion'];
var mDate = strings['movimiento.fecha'];
var mAmount = strings['movimiento.importe'];
var mOperation = strings['movimiento.operacion'];
var mIngreso = strings['movimiento.ingreso'];
var mDisposicion = strings['movimiento.disposicion'];

window.onload = function() {

    if ($.cookie("movements")) {
        restaurarForm();
        replicarImportes();
        replicarFechas();
    }

    if ($.cookie("resultados") === "1") {
        $('#modalResultados').modal('show');
        $.cookie("resultados", null);
    }

    $("#creditLimit").on("change paste keyup", function() {
        replicarImportes();
    });

    $("#openingDate").on("change paste keyup", function() {
        replicarFechas();
    });

    $("#openingComission").on("change paste keyup", function() {
        replicarImportes();
    });

    $("#brokerage").on("change paste keyup", function() {
        replicarImportes();
    });

    $("#add-moves").click(function() {

        var row = $('<div class="row" style="border: 1px solid red; border-radius: 5px;"/>');
        var inputs = $('<div class="section-field col-md-4">' +
            '<label for="movements' + movesCounter + '.movementDescription">' + mDescription + '</label>' +
            '<div class="field-widget"><i class="fa fa-pencil" ></i><input name="movements[' + movesCounter + '].movementDescription" id="movements' + movesCounter + '.movementDescription" type="text" required="required"/>' +
            '</div></div>' +

            '<div class="section-field col-md-3">' +
            '<label for="movements' + movesCounter + '.movementValue">' + mAmount + '</label>' +
            '<div class="field-widget">' +
            '<i class="fa fa-eur" ></i>' +
            '<input name="movements[' + movesCounter + '].movementValue" id="movements' + movesCounter + '.movementValue" type="text" value="0.0" required="required"/>' +
            '</div>' +
            '</div>' +

            '<div class="section-field col-md-3">' +
            '<label for="movements' + movesCounter + '.movementDate">' + mDate + '</label>' +
            '<div class="field-widget">' +
            '<i class="fa fa-calendar"></i>' +
            '<input name="movements[' + movesCounter + '].movementDate" id="movements' + movesCounter + '.movementDate" type="date" value="0" required="required"/>' +
            '</div>' +
            '</div>' +

            '<div class="section-field col-md-2">' +
            '<label for="movements[' + movesCounter + '].operation">' + mOperation + '</label>' +
            '<div class="field-widget">' +
            '<select name="movements[' + movesCounter + '].operation" class="selected">' +
            '<option value="D" label="' + mDisposicion + '" />' +
            '<option value="I" label="' + mIngreso + '" />' +
            '<select> ' +
            '</div>' +
            '</div>' +
            '</div>');


        row.append(inputs);

        row.appendTo(movesContainer);

        movesCounter++;
    });

    $("#remove-moves").click(function() {
        if (movesCounter > 1) {
            $('#moves-container .row').last().remove();
            $('#moves-container br').last().remove();

            movesCounter--;
        }
    });
}

function replicarImportes() {
    $("#importe-cero").val($("#creditLimit").val() * ($("#openingComission").val() / 100.0));
    $("#importe-uno").val($("#creditLimit").val() * ($("#brokerage").val() / 1000.0));
}

function replicarFechas() {
    $("#fecha-cero").val($("#openingDate").val());
    $("#fecha-uno").val($("#openingDate").val());
}

function restaurarForm() {
    $("#openingDate").val($.cookie("openingDate"));
    $("#expirationDate").val($.cookie("expirationDate"));

    var movimientos = $.parseJSON($.cookie("movements"));

    movesContainer.empty();
    movesCounter = 0;

    for (var i = 0; i < movimientos.length; i++) {
        addMovimiento(movimientos[i].movementDescription, movimientos[i].movementValue, movimientos[i].movementDate, i);
    }

    var date = new Date();
    date.setTime(date.getTime() + (1 * 1000));

    $.cookie("movements", null, {
        expires: date
    });
    $.cookie("openingDate", null, {
        expires: date
    });
    $.cookie("expirationDate", null, {
        expires: date
    });
}

function addMovimiento(descripcion, importe, fecha, index) {

    var row = $('<div class="row" style="border: 1px solid red; border-radius: 5px;"/>');
    var inputs = $('<div class="section-field col-md-4">' +
        '<label for="movements' + movesCounter + '.descripcionMovimiento">' + mDescription + '</label>' +
        '<div class="field-widget"><i class="fa fa-pencil" ></i><input name="movements[' + movesCounter + '].movementDescription" id="movements' + movesCounter + '.movementDescription" type="text" required="required"/>' +
        '</div></div>' +

        '<div class="section-field col-md-3">' +
        '<label for="movements' + movesCounter + '.movementValue">' + mAmount + '</label>' +
        '<div class="field-widget">' +
        '<i class="fa fa-eur" ></i>' +
        '<input name="movements[' + movesCounter + '].movementValue" id="movements' + movesCounter + '.movementValue" type="text" value="0.0" required="required"/>' +
        '</div>' +
        '</div>' +

        '<div class="section-field col-md-3">' +
        '<label for="movements' + movesCounter + '.movementDate">' + mDate + '</label>' +
        '<div class="field-widget">' +
        '<i class="fa fa-calendar"></i>' +
        '<input name="movements[' + movesCounter + '].movementDate" id="movements' + movesCounter + '.movementDate" type="date" value="0" required="required"/>' +
        '</div>' +
        '</div>' +

        '<div class="section-field col-md-2">' +
        '<label for="movements[' + movesCounter + '].operation">' + mOperation + '</label>' +
        '<div class="field-widget">' +
        '<select name="movements[' + movesCounter + '].operation" class="selected">' +
        '<option value="D" label="' + mDisposicion + '" />' +
        '<option value="I" label="' + mIngreso + '" />' +
        '<select> ' +
        '</div>' +
        '</div>' +
        '</div>');


    row.append(inputs);

    row.appendTo(movesContainer);


    movesCounter++;
}
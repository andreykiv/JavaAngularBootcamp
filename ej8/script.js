var arrNum = [], op = "", num = "", acc = "";

//reseteamos los valores
function vaciar(){
    acc = "";
    arrNum = [];
    op = "";
    num = "";
    $("#operation").text(acc);
    $("#result").text(acc);
}

function vaciarMemoria(){
    acc = "";
    arrNum = [];
    op = "";
    num = "";
}

$(document).ready(function() {
    pulsarBoton();
});

//funcion que muestra el valor del boton clickado en el display operacion y los guarda en memoria
function pulsarBoton(){
    vaciar();
    $('button').on('click', function(e) {
        let output = e.target.id;
        if(output >= "0" && output <= "9"){
            num +=output;
            acc += output;
            $("#operation").text(acc);
        } else if(output === "=") {
            operacion();
        } else if(output === "del"){
            vaciar();
        } else if (output === ".") {
            addComma();
        } else {
            op = output;
            if(acc === ""){
                op = "";
            } else {
                acc+= op;
                //sumamos el valor de num al array de acc;
                arrNum.push(num);
                //reseteamos el valor de num
                num = "";
                $("#operation").text(acc);
            }
        }
    });
}

function addComma(){
    num = num + ".";
    acc = acc + ".";
    $("#operation").text(acc);
}


function operacion(){
    if(arrNum.length != 1 && num === ""){
        alert("Selecciona dos numeros!");
    } else {
        let result = "";
        switch(op) {
            case("-"):
                result = arrNum[0] - num;
                $("#result").text(result);
                vaciarMemoria();
                break;
            case("+"):
                result = parseInt(arrNum[0]) + parseInt(num);
                $("#result").text(result);
                vaciarMemoria();
                break;
            case("x"):
                result = arrNum[0] * num;
                $("#result").text(result);
                vaciarMemoria();
                break;
            case("/"):
                if(num == 0){
                    alert("No se puede dividir entre 0!");
                    vaciar();
                    break;
                } else {
                    result = arrNum[0] / num;
                    $("#result").text(result);
                    vaciarMemoria();
                    break;
                }
        }
    }
}
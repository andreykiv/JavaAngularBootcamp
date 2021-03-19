var arrNum = [], op = "", num = "", acc = "";
//reseteamos los valores
function vaciar(){
    acc = "";
    arrNum = [];
    op = "";
    num = "";
    document.getElementById("display").value = acc;
}

function vaciarMemoria(){
    acc = "";
    arrNum = [];
    op = "";
    num = "";
}

function guardarNumero(id){
    let clickNumero = document.getElementById(id).innerHTML;
    num +=clickNumero;
    acc += clickNumero;
    document.getElementById("display").value = acc;
}

function guardarOperacion(id){
    let clickOp = document.getElementById(id).innerHTML;
    //asignamos la operacion elegida
    op = clickOp;
    //sumamos el valor de num al array de acc;
    arrNum.push(num);
    //reseteamos el valor de num
    num = "";
    //mostramos por la pantalla el numero pulsado y la operación
    acc += clickOp;
    document.getElementById("display").value = acc;
}

function cambiarSigno(){
    num = -num;
    acc = -acc;
    document.getElementById("display").value = acc;
}

function addComma(){
    num = num + ".";
    acc = acc + ".";
    document.getElementById("display").value = acc;
}

function raiz(){
        let result = "";
        result = Math.sqrt(num);
        document.getElementById("display").value = result;
}

function unoEntreX(){
    let result = "";
    result = 1 / num;
    document.getElementById("display").value = result;
}

function calcular(){
    if(arrNum.length != 1 && num === ""){
        alert("Selecciona dos numeros!");
    } else {
        let result = "";
        switch(op) {
            case("-"):
                result = arrNum[0] - num;
                document.getElementById("display").value = result;
                vaciarMemoria();
                break;
            case("+"):
                result = parseInt(arrNum[0]) + parseInt(num);
                document.getElementById("display").value = result;
                vaciarMemoria();
                break;
            case("*"):
                result = arrNum[0] * num;
                document.getElementById("display").value = result;
                vaciarMemoria();
                break;
            case("/"):
                if(num == 0){
                    alert("No se puede dividir entre 0!");
                    vaciar();
                    break;
                } else {
                    result = arrNum[0] / num;
                    document.getElementById("display").value = result;
                    vaciarMemoria();
                    break;
                }
        }
    }
}
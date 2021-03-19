var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

let DNIuser =  window.prompt("Introduce tu DNI: ");

let letraDNI = DNIuser.charAt(DNIuser.length - 1)
let numerosDNI = DNIuser.substring(0, DNIuser.length - 1) 

function comprobarDNI(){
    if(numerosDNI < 0 || numerosDNI > 99999999){
        alert("El número proporcionado no es válido!");
        return
    }
    let indexLetras = numerosDNI % 23;

    if(letras[indexLetras] === letraDNI){
        alert("La letra y los números del DNI son correctos!")
    } else {
        alert("La letra indicada del DNI no es la correcta!");
    }
}
comprobarDNI();

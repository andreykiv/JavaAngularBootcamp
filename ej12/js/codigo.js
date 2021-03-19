//crear una regex que valide una fecha formato "XX/XX/XXXX", donde "X" es un dígito. Probarlo con la expresión: nací el 05/04/1982 en Donostia
let regExpFecha = /^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;


let myFecha = "05/04/1982";
if(myFecha.match(regExpFecha)){
    console.log("El formato de la fecha es correcto!")
} else {
    console.log("Formato fecha incorrecto!")
}

//crear expresión regular que valide una dirección de email. 
let regExpEmail = /^([.-]|\w)+@([.-]|\w)+(\.\w{2,3})+$/;


// crear una expresión regular que elimine las etiquetas potencialmente peligrosas <script></script> y todo su contenido de una cadena HTML
let regExpEtiqueta = /<script[\s\S]*?>[\s\S]*?<\/script>/;

let userInput = prompt("Introduce un texto para comprobar si es un palíndromo: ")

function reverseFunc(){
    //metodos en cadena que transforman el string a un array, lo invierten y se crea otro string con el metodo join
    let invertedInput = userInput.split("").reverse().join("")

    if(invertedInput === userInput){
        console.log("Es un políndromo")
    } else {
        console.log("No es un políndromo")
    }
}

reverseFunc();
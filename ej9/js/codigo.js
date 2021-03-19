let userInput = prompt('Introduce una palabra: ');

function queContiene(){

    if(userInput.toUpperCase() === userInput){
        alert("El texto solo contiene letras en mayusculas")
    } else if (userInput.toLowerCase() === userInput){
        alert("El texto contiene letras en minusculas");
    } else {
        alert("El texto introducido tiene minusculas y mayusculas")
    }
}

queContiene();
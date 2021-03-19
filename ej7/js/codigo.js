let userNumber = window.prompt("Introduce el numero para calcular su factorial: ");

let factorial = parseInt(userNumber);

for(let i = 1; i < userNumber; i++){
    factorial *= i;
}

alert("El factorial del " + userNumber + " es " + factorial);

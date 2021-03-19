let numUser = prompt("Introduce un número: ");

function esParONo(){
    //parseamos primero
    let intParseado = parseInt(numUser);

    if(intParseado % 2 === 0){
        console.log("El número introducido es par");
    } else {
        console.log('El número introducido es impar');
    }
}
//ejecutamos la func
esParONo();
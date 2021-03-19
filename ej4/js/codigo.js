var valores = [true, 5, false, "hola", "adios", 2];

//1. determinamos cual de los dos elementos de texto es mayor
var mayor = "";
valores.forEach((x) => {
    if(typeof x === "string" && x.length > mayor.length){
        mayor = x;
    }
})

console.log("El string con mas longitud es: " + mayor);

//2. utilizando exclusivamente los dos valores booleanos del array, determinar los operadores necesarios para obtener un resultado true y otro false
if((typeof valores[0] && typeof valores[2]) === 'boolean'){
    console.log('true');
    if(!(valores[0] === valores[2])){
        console.log('false');
    }
} 

//3. Determinar el resultado de las cinco operaciones matemámicas realizadas con los dos elementos numéricos
let param1 = valores[1];
let param2 = valores[5];

function suma(){
    console.log(param1 + param2);
}
suma()

function resta(){
    console.log(param1 - param2);
}
resta()

function division(){
    console.log(param1/param2)
}
division()
function multiplicacion(){
    console.log(param1*param2);
}
multiplicacion()

function elevadoa(){
    console.log(Math.pow(param1, param2));
}
elevadoa()



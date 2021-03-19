//cada index representa el valor de la suma de los dos dados y su repetición. Empezando por 2 (valor minimo posible)
let numApariciones = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

//repetimos operacion 36.000 veces
for(let i = 0; i < 36000; i++){
    //num aleatorio entre 1 y 6
    let dado1 = Math.floor(Math.random() * 6 + 1);
    let dado2 = Math.floor(Math.random() * 6 + 1);

    //sumamos los valores de los dados
    let sumaValores = dado1 + dado2;
    numApariciones[sumaValores] = numApariciones[sumaValores] + 1;
}
//devolvemos la array sin los primeros dos indexes donde no existen valores repetidos.
console.log(numApariciones.slice(2));


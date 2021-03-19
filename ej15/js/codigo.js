function mostrarImagen(id){
    let img = document.getElementById("imgCentral");
    img.src = id;

    let textoAMostrar = document.getElementById(id);

    let textoACambiar = document.getElementById("textImg");
    textoACambiar.innerHTML = textoAMostrar.alt;
}
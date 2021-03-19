setInterval(function(){
    getHora()
}, 1000)

function getHora(){
    let hora = document.getElementById('hora');
    let minutos = document.getElementById("minuto");
    let segundos = document.getElementById("segundo");

    let date = new Date();

    hora.innerHTML = date.getHours();
    minutos.innerHTML = date.getMinutes();
    segundos.innerHTML = date.getSeconds();
}


// //endpoints:
let id = "";
let productos = "http://localhost:8181/api/products"


let get = 'GET'
let post = 'POST'
let put = 'PUT'
let deleteRequest = 'DELETE'

function ajaxRequest(url, method){
    $.ajax({
        url: url,
        method: method,
        dataType: 'json',
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJteXJvc2xhdiIsImV4cCI6MTYxNzMwNTcwMn0.zljbMUhoCEFwUzNAiuwSsHz16rauEOvZbZzJfb5dbsjiY-S6phDAbT9f2-b3-Ri3rC4ZlWkMf_wDppPT1HAs3Q'
        },
        contentType: 'application/x-www-form-urlencoded',
        success: function(result) {
            $("#data").text(JSON.stringify(result));
        },
        error: function(error){
            console.log(error);
            $("#data").text("Invalid input");
        }
    })
}

function ajaxRequestCrear(nombre, det){
    $.ajax({
        url: productos,
        method: post,
        dataType: 'json',
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmaXJzdHVzZXIiLCJleHAiOjE2MTczMTgxODR9.YqMBhDPRP6BfllBXgKTC68ftwCBwxQGxuG067azGXIIhsUVzI_nPIbcCLqt2-VYUwWryLxfSMfM2gjJCZ0qmmw'
        },
        contentType: 'application/x-www-form-urlencoded',
        data: {name: nombre, detail: det},
        success: function(data, textStatus, jqXHR) {
            alert("Product posted in DB")
        },
        error: function(error){
            console.log(error);
            $("#data").text("Invalid input");
        }
    })
}

function ajaxRequestModificar(url, nombre, det){
    $.ajax({
        url: url,
        method: put,
        dataType: 'json',
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmaXJzdHVzZXIiLCJleHAiOjE2MTczMTgxODR9.YqMBhDPRP6BfllBXgKTC68ftwCBwxQGxuG067azGXIIhsUVzI_nPIbcCLqt2-VYUwWryLxfSMfM2gjJCZ0qmmw'
        },
        contentType: 'application/x-www-form-urlencoded',
        data: {name: nombre, detail: det},
        success: function(data, textStatus, jqXHR) {
            alert("Product modified!")
        },
        error: function(error){
            console.log(error);
            $("#data").text("Invalid input");
        }
    })
}

function ajaxRequestEliminar(url){
    $.ajax({
        url: url,
        method: deleteRequest,
        dataType: 'json',
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmaXJzdHVzZXIiLCJleHAiOjE2MTczMTgxODR9.YqMBhDPRP6BfllBXgKTC68ftwCBwxQGxuG067azGXIIhsUVzI_nPIbcCLqt2-VYUwWryLxfSMfM2gjJCZ0qmmw'
        },
        contentType: 'application/x-www-form-urlencoded',
        success: function(data, textStatus, jqXHR) {
            alert("Producto eliminado!")
        },
        error: function(error){
            console.log(error);
           
        }
    })
}

$(document).ready(function() {
    $('#getAllData').click(function(){
        ajaxRequest(productos, get);
    });

    $('#btnConsultar').click(function(){
        let id = $("#idConsultar").val();
        let productoXID = `http://localhost:8181/api/products/${id}`;
        ajaxRequest(productoXID, get);
    })

    $('#btnEliminar').click(function(){
        let id = $("#idEliminar").val();
        let productoXID = `http://localhost:8181/api/products/${id}`;
        ajaxRequestEliminar(productoXID);
    })

    $('#btnCrear').click(function(){
        let name = $("#idNombre").val();
        let detail = $("#idDescripcion").val();
        ajaxRequestCrear(name, detail);
    })

    $('#btnModificar').click(function(){
        let id = $("#idProductoModificar").val();
        let productoXID = `http://localhost:8181/api/products/${id}`;
        let name = $("#idNuevoNombre").val();
        let detail = $("#idNuevaDescripcion").val();
        ajaxRequestModificar(productoXID, name, detail);
    })
});







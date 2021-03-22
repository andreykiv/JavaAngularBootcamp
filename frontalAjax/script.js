// //endpoints:
let getAllURL = "https://restcountries.eu/rest/v2/all";
let getCountryByName = "https://restcountries.eu/rest/v2/name/Algeria"
let getName = "https://restcountries.eu/rest/v2/name/Ukraine?fullText=true"
let getCode = "https://restcountries.eu/rest/v2/alpha/ua"
let get3Codes = "https://restcountries.eu/rest/v2/alpha?codes=ua;es;nl"
let getCurrency = "https://restcountries.eu/rest/v2/currency/uah"
let getLanguage = "https://restcountries.eu/rest/v2/lang/es"
let getCapital = "https://restcountries.eu/rest/v2/capital/madrid"
let getCallingCode = "https://restcountries.eu/rest/v2/callingcode/34"
let getRegion = "https://restcountries.eu/rest/v2/region/europe"
let getRegionalBlock = "https://restcountries.eu/rest/v2/regionalbloc/eu"
let get3Fields = "https://restcountries.com/v2/all?fields=name,capital,currencies"

function ajaxRequest(url){
    $.ajax({
        url: url,
        method: 'GET',
        dataType: 'json',
        headers: {
            'Accept': 'application/json'
        },
        contentType: 'application/x-www-form-urlencoded',
        
        
        success: function(result) {
            $("#data").text(JSON.stringify(result));
        },
        error: function(error){
            console.log(error);
        }
    })
}

$(document).ready(function() {
    $('#getAllData').click(function(){
        ajaxRequest(getAllURL);
    });

    $('#getCountry').click(function(){
        ajaxRequest(getCountryByName);
    });

    $('#getName').click(function(){
        ajaxRequest(getName);
    });

    $('#getCode').click(function(){
        ajaxRequest(getCode);
    });

    $('#get3Codes').click(function(){
        ajaxRequest(get3Codes);
    });

    $('#getCurrency').click(function(){
        ajaxRequest(getCurrency);
    });

    $('#getLang').click(function(){
        ajaxRequest(getLanguage);
    });

    $('#getCapital').click(function(){
        ajaxRequest(getCapital);
    });

    $('#getCallingCode').click(function(){
        ajaxRequest(getCallingCode);
    });

    $('#getRegion').click(function(){
        ajaxRequest(getRegion);
    });

    $('#getRegionalBlock').click(function(){
        ajaxRequest(getRegionalBlock);
    });

    $('#getThreeFields').click(function(){
        ajaxRequest(get3Fields);
    });
});







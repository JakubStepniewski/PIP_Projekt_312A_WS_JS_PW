import {elementGenerator,inputGenerator,buttonsGenerator,buttonsGeneratorEditAsLink,searchParametr} from './functions.js'


$( document ).ready(function() {
    fillForm();
});

function fillForm(){
$.getJSON( "http://localhost:8034/routes/"+searchParametr('id'), function( data ) {
        $('#routeId').val(data.routeId);
        $('#agencyId').val(data.agencyId);
        $('#routeShortName').val(data.routeShortName);
        $('#routeLongName').val(data.routeLongName);
        $('#routeType').val(data.routeType);
        $('#routeColor').val(data.routeColor);
        $('#routeTextColor').val(data.routeTextColor);
});
} 

$(".container").on("click", "#saveEdit", function(){
    $.ajax({
        url: 'http://localhost:8034/routes/updateroute',
        type: 'PUT',
        headers: {"Content-Type": "application/json"},
        data: JSON.stringify(
             { 
                "routeId": $('#routeId').val(),
                "agencyId": $('#agencyId').val(),
                "routeShortName":  $('#routeShortName').val(),
                "routeLongName": $('#routeLongName').val(),
                "routeType":  $('#routeType').val(),
                "routeColor":$('#routeColor').val(),
                "routeTextColor": $('#routeTextColor').val(), 
                "id": searchParametr('id')
            }
        ), 
        success: function(response) {
            
        }
     });
});
import {elementGenerator,inputGenerator,buttonsGenerator,buttonsGeneratorEditAsLink,searchParametr} from './functions.js'


$( document ).ready(function() {
    fillForm();
});

function fillForm(){
$.getJSON( "http://localhost:8034/stops/"+searchParametr('id'), function( data ) {
        $('#stopCode').val(data.stopCode);
        $('#stopName').val(data.stopName);
        $('#stopLat').val(data.stopLat);
        $('#stopLon').val(data.stopLon);
        $('#zoneId').val(data.zoneId);
});
} 

$(".container").on("click", "#saveEdit", function(){
    $.ajax({
        url: 'http://localhost:8034/stops/updatestop',
        type: 'PUT',
        headers: {"Content-Type": "application/json"},
        data: JSON.stringify(
             { 
                "id": searchParametr('id'),
                "stopCode": $('#stopCode').val(),
                "stopName": $('#stopName').val(),
                "stopLat": $('#stopLat').val(),
                "stopLon":  $('#stopLon').val(),
                "zoneId": $('#zoneId').val()
            }
        ), 
        success: function(response) {
            
        }
     });
});
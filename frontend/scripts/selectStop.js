import {elementGenerator,inputGenerator,buttonsGenerator,buttonsGeneratorEditAsLink,searchParametr,buttonsGeneratorNextStep} from './functions.js'

$( document ).ready(function() {
    generateTable();
});

function generateTable(){
    $.getJSON( "http://localhost:8034/trips/routeid/"+searchParametr('id'), function( data ) {
    let tableElement = $("#tableContent");
        data.forEach(element => {
            tableElement.prepend(
                "<tr><th scope='row'>"+
                elementGenerator(element.tripId,'span',element.id,'value') +
                "</th><td>"+
                buttonsGeneratorNextStep(element.tripId,'stoptimesTrip.html')
                +"</td></tr>");
        });
    });
    } 
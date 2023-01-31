import {elementGenerator,inputGenerator,buttonsGenerator,buttonsGeneratorEditAsLink,searchParametr,buttonsGeneratorNextStep} from './functions.js'

$( document ).ready(function() {
    generateTable();
});

function generateTable(){
    $.getJSON( "http://localhost:8034/trips/all", function( data ) {
    let tableElement = $("#tableContent");
        data.forEach(element => {
            tableElement.prepend(
                "<tr><th scope='row'>"+
                elementGenerator(element.routeLongName,'span',element.id,'value') +
                "</th><td>"+
                buttonsGeneratorNextStep(element.routeId,'selectStop.html')
                +"</td></tr>");
        });
    });
    } 
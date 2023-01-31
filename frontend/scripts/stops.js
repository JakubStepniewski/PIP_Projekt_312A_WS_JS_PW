import {elementGenerator,inputGenerator,buttonsGenerator,buttonsGeneratorEditAsLink} from './functions.js'
$( document ).ready(function() {
    generateTable();
});

function generateTable(){
$.getJSON( "http://localhost:8034/stops/all", function( data ) {
let tableElement = $("#tableContent");
    data.forEach(element => {
        tableElement.prepend("<tr><th scope='row'>"+
        elementGenerator(element.stopCode,'span',element.id,'')+
        "</th><td>"+ 
        elementGenerator(element.stopName,'span',element.id,'value') +
        inputGenerator(element.stopName,'text',element.id,'input','name')+
        "</td><td>"+
        buttonsGeneratorEditAsLink(element.id,'editStop.html')
        +"</td></tr>");
    });
});
} 

$(".table").on("click", "#delete", function(){
    const idData = parseInt($(this).attr('data-id'));
    $.ajax({
        url: 'http://localhost:8034/stops/'+idData,
        type: 'DELETE',
       
        success: function(response) {
            generateTable()
        }
     });
});


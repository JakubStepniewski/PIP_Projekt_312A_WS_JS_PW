import {elementGenerator,inputGenerator,buttonsGenerator,buttonsGeneratorEditAsLink} from './functions.js'
$( document ).ready(function() {
    generateTable();
});

function generateTable(){
$.getJSON( "http://localhost:8034/routes/all", function( data ) {
let tableElement = $("#tableContent");
    data.forEach(element => {
        tableElement.prepend("<tr><th scope='row'>"+
        elementGenerator(element.id,'span',element.id,'')+
        "</th><td>"+ 
        elementGenerator(element.routeLongName,'span',element.id,'value') +
        inputGenerator(element.routeLongName,'text',element.id,'input','name')+
        "</td><td>"+
        buttonsGeneratorEditAsLink(element.id,'editLine.html')
        +"</td></tr>");
    });
});
} 

$(".table").on("click", "#delete", function(){
    const idData = parseInt($(this).attr('data-id'));
    $.ajax({
        url: 'http://localhost:8034/routes/'+idData,
        type: 'DELETE',
       
        success: function(response) {
            generateTable()
        }
     });
});


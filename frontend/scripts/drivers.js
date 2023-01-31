import {elementGenerator,inputGenerator,buttonsGenerator} from './functions.js'
$( document ).ready(function() {
    generateTable();
});

function generateTable(){
$.getJSON( "http://localhost:8034/drivers/all", function( data ) {
let tableElement = $("#tableContent");
    data.forEach(element => {
        tableElement.prepend("<tr><th scope='row'>"+
            elementGenerator(element.id,'span',element.id,'')+
        "</th><td>"+ 
            elementGenerator(element.driverName,'span',element.id,'value') +
            inputGenerator(element.driverName,'text',element.id,'input','name')+
        "</td><td>"+ 
            elementGenerator(element.lineId,'span',element.id,'value') +
            inputGenerator(element.lineId,'text',element.id,'input','line')+
        "</td><td>"+
        buttonsGenerator(element.id)
        +"</td></tr>");
    });
});
}

$(".table").on("click", "#edit", function(){
    const idData = $(this).attr('data-id');
    $('.value.'+idData).css('display','none');
    $('.input.'+idData).css('display','block');
    $('.save-btn[data-id="'+idData+'"]').css('display','inline');
    $('.edit-btn[data-id="'+idData+'"]').css('display','none');
   //debugger;
});



$(".table").on("click", "#save", function(){
    const idData = parseInt($(this).attr('data-id'));
    $('.save-btn[data-id="'+idData+'"]').css('display','none');
    $('.edit-btn[data-id="'+idData+'"]').css('display','inline');
    const name = $('.name.'+idData).val();
    const line = $('.line.'+idData).val();
    $.ajax({
        url: 'http://localhost:8034/drivers/updatedriver',
        type: 'PUT',
        headers: {"Content-Type": "application/json"},
        data: JSON.stringify(
            {"id":idData,"driverName": name,"lineId": line}
        ), 
        success: function(response) {
            $("#tableContent").html('');
            generateTable()
        }
     });
});

$(".table").on("click", "#delete", function(){
    const idData = parseInt($(this).attr('data-id'));
    $.ajax({
        url: 'http://localhost:8034/drivers/'+idData,
        type: 'DELETE',
       
        success: function(response) {
            generateTable()
        }
     });
});


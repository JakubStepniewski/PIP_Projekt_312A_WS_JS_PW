import {elementGenerator,inputGenerator,buttonsGenerator,buttonsGeneratorEditAsLink,searchParametr,buttonsGeneratorNextStep} from './functions.js'

$( document ).ready(function() {
    generateTable();
});

function generateTable(){
    $.getJSON( "http://localhost:8034/stoptime/serviceid/"+searchParametr('id'), function( data ) {
    let tableElement = $("#tableContent");
        data.forEach(element => {
            tableElement.prepend(
                "<tr><th scope='row'>"+
                elementGenerator(element.stopSequence,'span',element.id,'') +
                "</th><td>"+
                elementGenerator(element.stopId,'span',element.id,'value') +
                inputGenerator(element.stopId,'text',element.id,'input','idStop')+
                "</td><td>"+
                elementGenerator(element.arrivalTime,'span',element.id,'value') +
                inputGenerator(element.arrivalTime,'text',element.id,'input','time')+
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
        const stop = $('.idStop.'+idData).val();
        const time = $('.time.'+idData).val();
        $.ajax({
            url: 'http://localhost:8034/stoptime/updatestoptime',
            type: 'PUT',
            headers: {"Content-Type": "application/json"},
            data: JSON.stringify(
                {"id":idData,"stopId": stop,"arrivalTime": time}
            ), 
            success: function(response) {
                $("#tableContent").html('');
                generateTable()
            }
         });
    });
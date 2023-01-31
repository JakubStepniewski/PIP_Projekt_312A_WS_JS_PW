$( document ).ready(function() {
    generateSelect();
});

function generateSelect(){
    $.getJSON( "http://localhost:8034/routes/all", function( data ) {
    let select = $("#select");
        data.forEach(element => {
            select.prepend("<option value="+element.routeId+">"+element.routeId+"</option>");
        });
    });
    } 


function addNewDriver()
{
 $.ajax({
        url: 'http://localhost:8034/drivers/adddriver',
        type: 'POST',
        headers: {"Content-Type": "application/json"},
        data: JSON.stringify(
             { 
                "driverName": $("#imie_nazwisko").val(),
                "lineId": $("#select").val()
            }
        ), 
        success: function(response) {
            alert("dodano nowego kierowcę");
        },
     });
}


function addNewLine()
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


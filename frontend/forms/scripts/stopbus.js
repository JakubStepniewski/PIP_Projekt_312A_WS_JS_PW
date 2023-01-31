function addNewStopBus()
{
    $.ajax({
        url: 'http://localhost:8034/stops/updatestop',
        type: 'POST',
        headers: {"Content-Type": "application/json"},
        data: JSON.stringify(
            { 
                "stopCode": $('#stopCode').val(),
                "stopName": $('#stopName').val(),
                "stopLat": $('#stopLat').val(),
                "stopLon":  $('#stopLon').val(),
                "zoneId": $('#strefa').val()
            }
        ), 
        success: function(response) {
            alert("Poprawnie dodano nowy przystanek");
        }
     });
}

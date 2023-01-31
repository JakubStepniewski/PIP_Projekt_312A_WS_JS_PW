function initMap() {
  // The location of Uluru
  //const uluru = { lat: 50.87033, lng: 20.61881 };
  // The map, centered at Uluru
  var map = new google.maps.Map(document.getElementById("map"),
  {
    center: new google.maps.LatLng(50.87033, 20.62752),
    zoom: 11,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  });


  $.getJSON( "http://localhost:8034/stops/all", function( data ) {

  let items = [];
      data.forEach(element => {

          var marker = new google.maps.Marker({
            position: {lat: element.stopLat, lng: element.stopLon},
            map: map,
            title: element.stopName,
            animation: google.maps.Animation.DROP
          });
      });
      return items;
    });
}




window.initMap = initMap;
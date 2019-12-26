  var map;
  
function initMap() {
  map = new google.maps.Map(document.getElementById('map'), {
    zoom: 15,
    center: {lat: 41.016464, lng: -91.964360}
  });
} // end of initMap
 
  var rendererList = new Array();
  var directionsDisplay;
  
  // Let server know about new route
  // Based on clicking GO button on map.jsp
  onClickHandler = function() {
	  var newRoute = new Array(); 
	    var str = document.getElementById('start').value;
	    var temp =  str.split(",");
		newRoute[0]  = {lat:temp[0], lng:temp[1]}; 

	    str = document.getElementById('end').value;
	    temp =  str.split(",");
	    newRoute[1]= {lat:temp[0], lng:temp[1]}; 
  
	    // Call taxiSchedule.js method...to send router to server
	    sendNewRouteRequest(newRoute);
  };
  
  // Delete route - via saved renderer
  function deleteRoute(taxiName) {
		for ( var i = 0, l = rendererList.length; i < l; i++ ) {
			if (rendererList[i].name === taxiName) {
				var directionsDisplay = rendererList[i].renderer;
				directionsDisplay.setMap(null);
				rendererList.splice(i, 1);
				break;
			}
		}
  }
  
  // Figure the move increments[steps] & send to server
 	function calculateAndDisplayRoute(routeData) {
 		var start = routeData[0];
 		var end = routeData[1];
 		
 	  var directionsService = new google.maps.DirectionsService;
	  directionsService.route({
	    origin: start.latLng,
	    destination: end.latLng,
	    travelMode: google.maps.TravelMode.DRIVING
	  }, 
	  function(result, status) {
	    if (status === google.maps.DirectionsStatus.OK) {
	    	directionsDisplay = new google.maps.DirectionsRenderer({
	    	    polylineOptions: {
	    	        strokeColor: start.name
	    	      }
	    	    });
	    	
          var routeOne = result.routes[0];

          directionsDisplay.setMap(map);
	      directionsDisplay.setDirections(result);
 	      rendererList.push({name: start.name, renderer: directionsDisplay });
 	      
 		    var steps = getSteps(routeOne);
 		    // Send route details to Server...[see TaxiScheduler.js)
 		    sendRoute(steps);


   	    } else {
	      window.alert('Directions request failed due to ' + status);
	    }
	  });
	}
 	
 	// get the increment points on the route - 
 	// we'll use for moving the car...along 
 	function getSteps(route) {
  		var steps = new Array();		
 		var leg = route.legs[0];
		var directSteps = leg.steps;
  	
 
			var step;
 			var startLat = directSteps[0].start_location.lat();
 			var startLng = directSteps[0].start_location.lng();
 			var endLat = directSteps[ directSteps.length-1 ].end_location.lat();
 			var endLng = directSteps[directSteps.length-1 ].end_location.lng();
 			
 			step = {lat:startLat, lng:startLng}; 
  			steps.push(step);
  			
		for ( var i = 0, l = directSteps.length; i < l; i++ ) {
  			
 		
  			var lat_lngs = directSteps[i].lat_lngs;
  			var previous_ndx = 0;
  	 		for ( var n = 0, j = lat_lngs.length; n < j; n++ ) {
  	 			
  	 			if (lat_lngs[n].lat() != lat_lngs[previous_ndx].lat() && 
  	 					lat_lngs[n].lng() != lat_lngs[previous_ndx].lng()) {
  	 			 
  	 		 		step= {lat:lat_lngs[n].lat(), lng:lat_lngs[n].lng()}
  	 	 			steps.push(step);
  	 		 	previous_ndx = n;
  	 			}
  	 		}
 		};
 	
			step = {lat:endLat, lng:endLng}; 
			steps.push(step);		

 		return steps;
 	}
 	

 


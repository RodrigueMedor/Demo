<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>ComPro Taxi</title>
</head>
 
    <body>
 
   <h1 style="text-align: center;">Welcome to the ComPro Taxi Service</h1>
 <p style="text-align: center">
    <img src="<spring:url value="/resources/images/greenCar.png" />" alt="Car NOT found!!!" align="middle" />
     <img src="<spring:url value="/resources/images/redCar.png" />" alt="Car NOT found!!!"  align="middle"/>
 </p>

<div style="text-align:center;">
   <h3 >
     <img src="<spring:url value="/resources/images/orangeCar.png" />" alt="Car NOT found!!!"  />
   TAXI DISPATCHER:
      <img src="<spring:url value="/resources/images/blueCar.png" />" alt="Car NOT found!!!"  />
   </h3>
 
     <form action="map" method="get">
           <input id="submit" type="submit"  
                value="Manage the Schedule">
	</form>
 </div >
 
 <div style="text-align:center;">
<canvas width='500' height='500' id='canvas'></canvas>
</div>
<script>
    var canvas = document.getElementById('canvas');
    var context = canvas.getContext('2d');

    var imgBlank = new Image();
    imgBlank.src = '/ComproTaxi/resources/images/blankCar.png';
    var imgGreen = new Image();
    imgGreen.src = '/ComproTaxi/resources/images/greenCar.png';
    var imgRed = new Image();
    imgRed.src = '/ComproTaxi/resources/images/redCar.png';
    var imgOrange = new Image();
    imgOrange.src = '/ComproTaxi/resources/images/orangeCar.png';
 
    var imgBlue = new Image();
    imgBlue.src = '/ComproTaxi/resources/images/blueCar.png';
 
    var img = imgGreen;

         var x = 1;
         var y = 250;
         var n = 1;   // x increment
         var m=0;    
 
         repeat (function() {     	 
           	 
        	 // Green goes Left to Right
            if (x == 240  && y == 250) { 
            		  x = 500; n=-1; m=0;
           		   img = imgRed;
             }   
            
        	 // Red goes Right to Left
            if (x == 270  && y == 250) { 
            	x=250; y=1; n=0;m=1;
           		   img = imgOrange;
           	   }
         
           	// Orange/Yellow goes Top - down
           	if (y == 220  && x == 250) {
 				  y = 500; n=0; m=-1;
                  img = imgBlue;
           	}
 
           	// Blue goes Bottom up
           	if (y == 280  && x == 250) {
           		// Sleep for 2 seconds - then start again
           		 sleep(2000);
           		 context.clearRect(0, 0, canvas.width, canvas.height);
                     x = 1;
                      y = 250;
                      n = 1;  // x increment
                      m=0;    // y increment
             		img = imgGreen;
              	   }
              		   
 
		 context.drawImage(imgBlank, x, y);

        	x = x+n;
        	y = y+m;
   		 context.drawImage(img, x, y);

      });
      
 //       context.clear = function() {this.clearRect(0,0,1000,200);};
        
        function repeat(fn) {
            if (window.requestAnimationFrame) {
              var advance = function() {fn(); requestAnimationFrame(advance);};
              requestAnimationFrame(advance);
            } else window.setInterval(fn, 50);
          };
          
          function sleep(miliseconds) {
        	   var currentTime = new Date().getTime();

        	   while (currentTime + miliseconds >= new Date().getTime()) {
        	   }
        	}

</script>
</body>
</html>

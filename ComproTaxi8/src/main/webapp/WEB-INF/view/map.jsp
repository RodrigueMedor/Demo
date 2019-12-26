<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Directions service</title>
  <style type="text/css">@import url("<spring:url value="/resources/css/map.css"/>");</style>
  <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.0.3/sockjs.min.js"></script>
 
  <script src="<spring:url value="/resources/js/stomp.js"/>" ></script>

   <script src="<spring:url value="/resources/js/map.js"/>" ></script>
   <script src="<spring:url value="/resources/js/taxiScheduler.js"/>" ></script>
 <script  src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCval8uFCzal-l07dpyZATfNvNZvoBV7gM&callback=initMap" defer>

 </script>
	<title>ComPro Taxi Dispatcher</title>
 
 </head>
<body>
   <div id="floating-panel">
    <b>Start: </b>
    <select id="start">
      <option value="41.016464, -91.964360">MUM</option>
      <option value="41.012255, -91.964468">EveryBodys</option>
      <option value="41.007592, -91.993264">Walmart</option>
      <option value="41.004669, -91.978597">HyVee</option>
      <option value="41.018658, -91.955616">Waterworks Park</option>
    </select>
   <b>End: </b>

    <select id="end">
      <option value="41.012255, -91.964468">EveryBodys</option>
      <option value="41.007592, -91.993264">Walmart</option>
      <option value="41.016464, -91.964360">MUM</option>
      <option value="41.004669, -91.978597">HyVee</option>
      <option value="41.018658, -91.955616">Waterworks Park</option>
    </select>
    <input type="button" value="Go" onclick="onClickHandler();return false;">
 
    </div>
    
    <div id="map"></div>
    
    
   
    
    
</body>
</html>
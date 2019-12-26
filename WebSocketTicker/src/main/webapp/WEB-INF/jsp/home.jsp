<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Stock Ticker</title>
</head>
<body>
  <h1>Stock Ticker</h1>
  
  <div>
  <marquee bgcolor="khaki" direction="left" speed="normal" behavior="loop"  width="50%" id="priceDisplay"> 
  </marquee>
 </div>  
  
 
  <p class="new">
    Code: <input type="text" class="code"/>
    Price: <input type="text" class="price"/>
    <button class="add">Add</button>
    <button class="remove-all">Remove All</button>
  </p>

  <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="<spring:url value="/resources/stomp.js"/>"></script>
  <script src="<spring:url value="/resources/tickerScheduler.js"/>" ></script>

  </body>
</html>

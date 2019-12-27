<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
   <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="<spring:url value="/resources/js/welcome.js"/>"></script>
<TITLE>  Spring MVC Regular with AJAX call</TITLE>
 </head>


<body>
  <div class="container-fluid">
    <div align="center">
         <h1> ${message} </h1> 
        <!--div id="result"></div-->
    </div>   
    
 		<h1 class="welcome" style = "text-align:center"> </h1>  
  		
  		<!-- Display icon based on screen size -->
     <table class="duke">
      <tr>
        <td   style="visibility: hidden;"> 
        	<img class="visible-xs" src="<spring:url value="/resources/images/java2.png"  htmlEscape="true" />" height="100" width="100"  />
        	<img class="visible-sm" src="<spring:url value="/resources/images/java1.png"  htmlEscape="true" />" height="200" width="200"  />
         	<img class="visible-md" src="<spring:url value="/resources/images/cupo.png"  htmlEscape="true" />" height="200" width="200"  />
         	<img class="visible-lg" src="<spring:url value="/resources/images/Duke2.png"  htmlEscape="true" />" height="300" width="150" />  
        </td>
        
        <td   style="visibility: hidden;"> 
         	<img class="visible-xs" src="<spring:url value="/resources/images/java2.png"  htmlEscape="true" />" height="100" width="100"  />
        	<img class="visible-sm" src="<spring:url value="/resources/images/java1.png"  htmlEscape="true" />" height="200" width="200"  />
         	<img class="visible-md" src="<spring:url value="/resources/images/cupo.png"  htmlEscape="true" />" height="200" width="200"  />
         	<img class="visible-lg" src="<spring:url value="/resources/images/Duke21.png"  htmlEscape="true" />" height="300" width="300" />  
        </td>
       
        <td   style="visibility: hidden;">
       		<img class="hidden-lg hidden-md hidden-sm " src="<spring:url value="/resources/images/java2.png"  htmlEscape="true" />" height="100" width="100"  />
        	<img class="hidden-lg hidden-md hidden-xs" src="<spring:url value="/resources/images/java1.png"  htmlEscape="true" />" height="200" width="200"  />
          	<img class="hidden-lg hidden-sm hidden-xs " src="<spring:url value="/resources/images/cupo.png"  htmlEscape="true" />" height="200" width="200"  />
        	<img class="hidden-md hidden-sm hidden-xs" src="<spring:url value="/resources/images/Duke2a.png"  htmlEscape="true" />" height="150" width="300"  /> 
        </td>
        
        <td   style="visibility: hidden;"> 
	       	<img class="hidden-lg hidden-md hidden-sm " src="<spring:url value="/resources/images/java2.png"  htmlEscape="true" />" height="100" width="100"  />
        	<img class="hidden-lg hidden-md hidden-xs" src="<spring:url value="/resources/images/java1.png"  htmlEscape="true" />" height="200" width="200"  />
           	<img class="hidden-lg hidden-sm hidden-xs " src="<spring:url value="/resources/images/cupo.png"  htmlEscape="true" />" height="200" width="200"  />
         	<img class="hidden-md hidden-sm hidden-xs" src="<spring:url value="/resources/images/Duke2a1.png"  htmlEscape="true" />" height="300" width="300"  />
        </td>
     </tr>
        </table>
        <br>
  </div>
 
</body>
</html>
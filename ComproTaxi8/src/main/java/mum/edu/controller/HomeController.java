package mum.edu.controller;

/**
* @author JBruen
*
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.domain.LatLng;
import mum.edu.domain.Taxi;
import mum.edu.messages.TaxiMessage;
import mum.edu.scheduler.TaxiScheduler;
import mum.edu.service.TaxiService;


@Controller
public class HomeController {

	  @Autowired 
	  private TaxiService taxiService;  
	 
	  @Autowired 
	  private TaxiScheduler taxiScheduler;  
	 
   /**
   * Serve the main page
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
    return "home";
  }
  

  /**
   * Serve the map page
   */
  @RequestMapping(value = "/map", method = RequestMethod.GET)
  public String map() {
    return "map";
  }
  
  /**
   * Handler to declare new route - Via WebSocket
   * This is called from map.js when the "GO" button is clicked on map.jsp
   * Assigns first available taxi & requests the client to 
   * Calculate the route details
   */
  @MessageMapping("/newRouteRequest")
  public void newRoute(LatLng[] routeRequest) throws Exception {
	  
	  List<LatLng> routeEndPoints = Arrays.asList(routeRequest);
	   List<TaxiMessage> startMessage = new ArrayList<TaxiMessage>();

	   List <Taxi> taxis = taxiService.getAll();
	    for(Taxi taxi : taxis) {

	    	if (taxi.getRoute() == null) {
	    		taxi.setRouteEndPoints(routeEndPoints);
	    		startMessage.add(new TaxiMessage(taxi.getName(),taxi.getStart()));
	    		startMessage.add(new TaxiMessage(taxi.getName(),taxi.getEnd()));
	    		break;
	    	}
	    }
	    
 	    taxiScheduler.createRoute(startMessage);

  }

  /**
   * Handler to set up new route details - Via WebSocket
   */
  @MessageMapping("/addNewRouteDetails")
  public void addRoute(LatLng[] routeArray) throws Exception {
	  
	  List<LatLng> route  = Arrays.asList(routeArray);
	  List <Taxi> taxis = taxiService.getAll();
	    for(Taxi taxi : taxis) {

	    	if (taxi.getRoute() == null) {
	    		taxi.setRoute(route);
	    		break;
	    	}
	    }

  }

}

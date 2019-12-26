package mum.edu.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Component;

import mum.edu.domain.LatLng;
import mum.edu.domain.Taxi;
import mum.edu.messages.TaxiMessage;
import mum.edu.service.TaxiService;

@Component
public class TaxiScheduler {

	  @Autowired 
	  private SimpMessagingTemplate template;  
	  
	  @Autowired 
	  private TaxiService taxiService;  
	  
   /**
   * Iterates route list, update the car location then broadcast it to all subscribing clients
   */
 // @PostConstruct
  @Scheduled(fixedDelay = 1000)
  public void updateRouteAndBroadcast() {
	  List <Taxi> taxis = taxiService.getAll();
    for(Taxi taxi : taxis) {
    	 
    	if (taxi.getRoute() != null) {
 
      		Integer currentLocation = taxi.getCurrentLocation();

    		if (currentLocation < taxi.getRoute().size()) {
	    		
        		LatLng latLng = taxi.getRoute().get(currentLocation);		
        		
        		TaxiMessage taxiMessage = new TaxiMessage(taxi.getName(),latLng);
       			taxi.setCurrentLocation(++currentLocation);  
      			template.convertAndSend("/topic/car", taxiMessage);
    		}
    		else {
    			// clear route, reset location, 
    			taxi.init( ); 
    			//delete path & move car Home
    			TaxiMessage taxiMessage = new TaxiMessage(taxi.getName(),taxi.getDefaultLatLng());
    			template.convertAndSend("/topic/removeRoute", taxiMessage);

    		}
 
    	}
    }
  }
  
 public void createRoute(List<TaxiMessage> start) {
		template.convertAndSend("/topic/createRoute", start);

  }



}

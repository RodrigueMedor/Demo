package mum.edu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mum.edu.domain.LatLng;
import mum.edu.domain.Taxi;


@Component
public class Database {
 	public List<Taxi> taxis = new ArrayList<Taxi>();
 	 {
 		 
 		taxis.add(new Taxi("Red", new LatLng(41.022800, -91.967117) ));
		taxis.add(new Taxi("Green", new LatLng(41.023846, -91.967117) ));
		taxis.add(new Taxi("Blue",new LatLng(41.022800, -91.966117) ));
		taxis.add( new Taxi("Orange" , new LatLng(41.023846, -91.966100)));
}
	
  
}

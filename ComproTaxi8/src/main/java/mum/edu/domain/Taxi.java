package mum.edu.domain;

import java.util.List;

public class Taxi {

	String name;
	List<LatLng> route;
	Integer currentLocation;
	Integer previousLocation;
	LatLng defaultLatLng;
	LatLng start;
	LatLng end;

	public Taxi(String name, LatLng defaultLatLng) {
		this.name = name;
		this.route = null;
		this.currentLocation = 0;
		this.previousLocation = 0;
		this.defaultLatLng = defaultLatLng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<LatLng> getRoute() {
		return route;
	}
	public void setRoute(List<LatLng> route) {
		this.route = route;
	}
	public Integer getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Integer currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public Integer getPreviousLocation() {
		return previousLocation;
	}
	public void setPreviousLocation(Integer previousLocation) {
		this.previousLocation = previousLocation;
	}
	public LatLng getDefaultLatLng() {
		return defaultLatLng;
	}
	public void setDefaultLatLng(LatLng defaultLatLng) {
		this.defaultLatLng = defaultLatLng;
	}
	
 
	public void setRouteEndPoints(List<LatLng> routeEndPoints) {
		this.start = routeEndPoints.get(0);
		this.end = routeEndPoints.get(1);
	}
	
	public LatLng getStart() {
		return start;
	}
	public void setStart(LatLng start) {
		this.start = start;
	}
	
	public LatLng getEnd() {
		return end;
	}
	public void setEnd(LatLng end) {
		this.end = end;
	}
	public void init() {
		this.route = null;
		this.currentLocation = 0;
		this.previousLocation = 0;
		this.start = null;
		this.end = null;
	}
	
}

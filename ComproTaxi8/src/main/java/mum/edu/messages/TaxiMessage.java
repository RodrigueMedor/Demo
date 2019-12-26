package mum.edu.messages;

import mum.edu.domain.LatLng;

public class TaxiMessage {
	
	
	private  LatLng latLng;
	private String name;
	
	public TaxiMessage() {}

	public TaxiMessage(String name, LatLng latLng) {
		this.name = name;
		this.latLng = latLng;
	}

	
	public LatLng getLatLng() {
		return latLng;
	}
	public void setLatLng(LatLng latLng) {
		this.latLng = latLng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}

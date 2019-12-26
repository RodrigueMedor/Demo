package mum.edu.domain;

public class LatLng {
	private double lat=0;

	private double lng=0;

	public LatLng() {}
	
	public LatLng(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return this.lat;
	}

	public double getLng() {
		return this.lng;
	}

}

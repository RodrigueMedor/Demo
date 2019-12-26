package mum.edu.service;

import java.util.List;

import mum.edu.domain.Taxi;


 

 public interface TaxiService   {
	
	public List<Taxi> getAll();
	
	public Taxi findByName(String name);
	
	
		   
}
 

package mum.edu.repository;

import java.util.List;

import mum.edu.domain.Taxi;


 public interface TaxiRepository   {
	
	public List<Taxi> getAll();
	
	public Taxi findByName(String name);
	
	
		   
}
 

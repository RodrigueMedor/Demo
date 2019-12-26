package mum.edu.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mum.edu.data.Database;
import mum.edu.domain.Taxi;
import mum.edu.repository.TaxiRepository;




 
@Repository
 public class TaxiRepositoryImpl implements TaxiRepository {

	@Autowired
	Database data;
 
	public List<Taxi> getAll() {
		return (List<Taxi>) data.taxis;
	}
	
 
	public Taxi findByName(String name) {
		for (Taxi taxi:data.taxis ) {
			if (taxi.getName().equals(name))  			
				return taxi;
		}
		return null;
	}
	
	
		   
}
 

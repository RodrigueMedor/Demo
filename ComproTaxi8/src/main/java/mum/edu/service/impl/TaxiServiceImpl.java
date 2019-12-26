package mum.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.Taxi;
import mum.edu.repository.TaxiRepository;
import mum.edu.service.TaxiService;


 
@Service
 public class TaxiServiceImpl implements TaxiService  {
	
	@Autowired 
	TaxiRepository taxiRepository;
	
	public List<Taxi> getAll() {
		return taxiRepository.getAll();
	}
	
	public Taxi findByName(String name) {
		return taxiRepository.findByName(name);
	}
	
	
		   
}
 

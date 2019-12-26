package edu.mum.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import edu.mum.domain.Stock;
import edu.mum.service.StockService;

@Service
public class StockServiceImpl implements StockService {
	
	private  List<Stock> stockList = new ArrayList<Stock>();
    private Random randomNumber = new Random(System.currentTimeMillis());

	public List<Stock> getAll() {
	    for(Stock stock : stockList) {
		      double chgPct = randomNumber.nextDouble() * 5.0;
		      if(randomNumber.nextInt(2) == 1) chgPct = -chgPct;
		      stock.setPrice(stock.getPrice() + (chgPct / 100.0 * stock.getPrice()));
	    }
		return stockList;
	}
	
	public void save(Stock stock) {
		stockList.add(stock);
	}

	public void delete(Stock stock) {
		stockList.remove(stock);
	}
	
	public void deleteAll() {
		stockList.clear();
	}

}

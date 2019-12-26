package edu.mum.service;

import java.util.List;

import edu.mum.domain.Stock;

public interface StockService {

	public List<Stock> getAll();
	public void save(Stock stock);
	public void delete(Stock stock);
	public void deleteAll();
}

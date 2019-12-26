package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Stock;
import edu.mum.scheduler.TickerScheduler;
import edu.mum.service.StockService;

@Controller
public class HomeController {

	@Autowired
	StockService stockService;
  
	  /**
	   * Serve the main page
	   */
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String home() {
	    return "home";
	  }

  /**
   * WebSocket Handler to add one stock
   */
  @MessageMapping("/addStock")
  @SendTo("/topic/price")
  public List<Stock> addStock(Stock stock) throws Exception {
	  stockService.save(stock);
	  return stockService.getAll();
	  }
  
  /**
   * WebSocket Handler to remove all stocks
   */
  @MessageMapping("/removeAllStocks")
  @SendTo("/topic/price")
  public List<Stock> removeAllStocks() {
		  stockService.deleteAll();
	  return stockService.getAll();
  }
  

}

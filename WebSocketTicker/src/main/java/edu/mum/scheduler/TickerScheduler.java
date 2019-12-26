package edu.mum.scheduler;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.mum.domain.Stock;
import edu.mum.service.StockService;
 
@Component
public class TickerScheduler {

	  @Autowired 
	  private StockService stockService;  
	
	    @Autowired
	    private SimpMessagingTemplate template;

 	  /**
	   * Invoked after bean creation is complete, this method will schedule 
	   * updatePriceAndBroacast every 1 second
	   */
	  @PostConstruct
	  @Scheduled(fixedDelay = 1000)
	  private void broadcast() {
 		  List<Stock> stockList =  stockService.getAll();
	       this.template.convertAndSend("/topic/price", stockList);
	  }


}

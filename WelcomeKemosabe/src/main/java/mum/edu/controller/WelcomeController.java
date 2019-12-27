package mum.edu.controller;


	import java.util.Map;
import java.util.ResourceBundle;

import mum.edu.domain.CellManagement;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
	 
	/**
	* @author JB
	*
	*/
	 
	@Controller
	@SessionAttributes({"cellManagement","studentCounter"})
 	public class WelcomeController {	 
		
       		String[] studentList;
    		
	    @RequestMapping({"/","/welcome"})
	    public ModelAndView helloKemosabes(Model model) {
	    	String view = "welcome";
  	  
	    	model.addAttribute("cellManagement", new CellManagement(4));

  	    	studentList = getStudentList();

   	    	model.addAttribute("studentCounter", 0);

 	    	ModelAndView modelAndView = new ModelAndView(view, "message", " Welcome Kemosabes!!!");

	        return modelAndView ;
	    }
	 
	    /*
	     * Called every 730 milliseconds to advance Duke across screen
	     * After screen traversal is complete ..
	     * Move to next student...and continue
	     */
	    @RequestMapping(value = "/welcomeStudent", method = RequestMethod.GET)
	    public @ResponseBody String[] displayWelcome(Map map, Model model ) {
	  	
	    	int studentCounter = (int) map.get("studentCounter");
	    	CellManagement cellManagement = (CellManagement)map.get("cellManagement");
	
	    	String currentStudent= studentList[studentCounter];
	    
	    	cellManagement.incrementCellCounter();
 	    	if (cellManagement.getCellCounter() == (cellManagement.getTotalCells())) {
	    		cellManagement.resetCellCounter();
	    		
	    		if (++studentCounter == studentList.length)
	    			 studentCounter = 0;  		 
	   	    	model.addAttribute("studentCounter", studentCounter);
		    	 currentStudent= studentList[studentCounter];
			    
   	     }
	    	
 	    	String [] result = {
  	        					String.valueOf(cellManagement.getTotalCells()),
  	        					String.valueOf(cellManagement.getCellCounter()),
  	        					"Welcome to " + currentStudent
  	        					};
 	       
 			 return result;
	    }
	    
	    
	    /*
	     * Get student list from properties file
	     */
	    String [] getStudentList() {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("students");	
			 
			String list = resourceBundle.getString("Students");
			String [] studentList = list.split(",");
	 
			return studentList;

	    }
	    
 	    
	}
	
	

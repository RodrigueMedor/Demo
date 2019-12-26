package mum.edu.domain;

import java.util.Locale;

import javax.validation.constraints.Min;

import mum.edu.formatter.ISBNFormatter;

public class ISBNumber {

//	@Min(value=100,message="{ISBN.min}")
	  private Integer start;  //first 3
	  private Integer middle;  //middle 3
	  private Integer end;  // last 3

	  
	  public ISBNumber(Integer start, Integer middle, Integer end) {
		  this.start = start;
		  this.middle = middle;
		  this.end = end;
	  }
	  
	  public ISBNumber () {
		  
	  }
	  
	  public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getMiddle() {
		return middle;
	}
	public void setMiddle(Integer middle) {
		this.middle = middle;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	
	public String getISBNFormatted() {
		ISBNFormatter formatter = new ISBNFormatter();
		
		return formatter.print(this, new Locale("en"));
	}
	 
}

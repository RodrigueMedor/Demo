package mum.edu.formatter;

import java.util.Locale;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import mum.edu.domain.ISBNumber;

@Component
public class ISBNFormatter implements Formatter<ISBNumber> {

	  public String print(ISBNumber isbn, Locale locale) {
		  String start = String.format("%03d", isbn.getStart());
		  String middle = String.format("%03d", isbn.getMiddle());
		  String end = String.format("%03d", isbn.getEnd());
		  
		  return  start + "-" + middle + "-" + end;
	  }

	  public ISBNumber parse(String source, Locale locale)
	      throws ParseException {
		  ISBNumber isbNumber= null;
 
			int start = Integer.parseInt(source.substring(0, 3));
		    int middle = Integer.parseInt(source.substring(4, 7));
		    int end = Integer.parseInt(source.substring(8, 11));
		    isbNumber =  new ISBNumber(start, middle, end);
 
		    return isbNumber;
	  }
}
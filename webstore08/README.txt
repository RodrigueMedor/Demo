Internationalization
    Has activeDate field with @DateFormat  
    Has @NumberFormat on product price & DateFormat on activeDate
LOOK at PRODUCTS to see formatting    
    SEE web.xml for filter to Recognize unicode characters on web page 
   also to use characters in properties file:
    window->preferences->general-content types-Text default encoding UTF-8
    make sure *.properties is under text file associations
Tiles

Custom  validators:
ProductId W/annotation [enter already existing [e.g.,P1234] code to test
UnitsInStock - cross field as "classic" Validator
Cross field with Annotation in Webstore 7

ExceptionHandling:
@ResponseStatus :
Input "bogus" category with products/{category} 
e.g. products/laptop is a GOOD category ; products/laptp is NOT
ExceptionHandler:
products/throw  for exception

CONTROLLER ADVICE

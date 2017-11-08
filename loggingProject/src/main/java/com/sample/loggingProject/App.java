package com.sample.loggingProject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {	
	
    public static void main( String[] args )
    {
    	 Logger logger = LoggerFactory.getLogger(App.class);
    	 if(logger.isDebugEnabled())
    	 	logger.debug("Hello World");
    	 
    	 
    }
}

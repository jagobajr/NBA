package main;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LogController {
	
	private static Logger log=Logger.getLogger("LOG");
	
	
	static void log( Level level, String msg, Throwable ex ) {
			log = Logger.getLogger(LogController.class.getName() );  
			log.setLevel( Level.ALL );  // 
			try {
				log.addHandler( new FileHandler( "log.xml", true ) );  
			} catch (Exception e) {
				log.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		
		if (ex==null)
			log.log( level, msg );
		else
			log.log( level, msg, ex );
	}
	

}

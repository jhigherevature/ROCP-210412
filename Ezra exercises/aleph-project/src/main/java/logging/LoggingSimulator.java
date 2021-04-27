package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

public class LoggingSimulator {
		private static Logger log = LogManager.getLogger(LoggingSimulator.class);

	public static void main(String[] args) {
		LoggingMethod();
//		log.info("Main Method!");
//		log.error("uh oh SpaghettiOs!");  
	} 
	public static void LoggingMethod() {	
		log.trace("Trace Message");
		log.debug("Debug Log");
		log.info("info log");
		log.warn("warning log");
		log.error("error log");
		log.fatal("fatal log");
			}

	}

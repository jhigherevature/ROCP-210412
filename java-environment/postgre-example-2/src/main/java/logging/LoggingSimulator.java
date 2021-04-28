package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingSimulator {
	private static Logger log = LogManager.getLogger(LoggingSimulator.class);
	
	public static void main(String[] args) {
		loggingMethod();
	}
	
	public static void loggingMethod() {
		log.trace("TRACE LOG");
		log.debug("DEBUG LOG");
		log.info("INFO LOG");
		log.warn("WARNING LOG");
		log.error("ERROR LOG");
		log.fatal("FATAL LOG");
	}

}

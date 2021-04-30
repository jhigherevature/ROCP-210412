package postgredataaccessobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostgreDAOLogger {
	
	private static Logger log = LogManager.getLogger(PostgreDAOLogger.class);

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		PostgreDAOLogger.log = log;
	}

}

package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerObject {

    public static Logger getLogger() {
          return LogManager.getLogger();
    }
}

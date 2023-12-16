package org.flamaral256.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Log logWithCustomApacheCommonsSpringJcl = LogFactory.getLog(Application.class);
    private static final Logger loggerWithLog4jAPI = LogManager.getLogger(Application.class);
    private static final org.apache.logging.log4j.core.Logger loggerWithLog4jCORE = (org.apache.logging.log4j.core.Logger) LogManager
            .getLogger(Application.class);
    private static final java.util.logging.Logger loggerWithJUL = java.util.logging.Logger.getLogger(Application.class.getName());

    public void run() {
        logWithCustomApacheCommonsSpringJcl.error("Are you programming a new framework without log dependencies?");
        loggerWithLog4jCORE.warn("You have coupled the application's code with a log implementation");
        loggerWithLog4jAPI.info("Ok, it is an interface! You can change the log implementation later");
        loggerWithJUL.fine("fine");
        loggerWithJUL.finest("finest");
    }
}

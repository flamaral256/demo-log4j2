package org.flamaral256.app;

public class Application {

    private static final org.apache.commons.logging.Log logWithCustomApacheCommonsSpringJcl = org.apache.commons.logging.LogFactory.getLog(Application.class);
    private static final org.apache.logging.log4j.Logger loggerWithLog4jAPI = org.apache.logging.log4j.LogManager.getLogger(Application.class);

    private static final org.slf4j.Logger loggerWithSLF4jAPI = org.slf4j.LoggerFactory.getLogger(Application.class);

    private static final org.apache.logging.log4j.core.Logger loggerWithLog4jCORE = (org.apache.logging.log4j.core.Logger)
            org.apache.logging.log4j.LogManager.getLogger(Application.class);
    private static final java.util.logging.Logger loggerWithJUL = java.util.logging.Logger.getLogger(Application.class.getName());

    public void run() {
        logWithCustomApacheCommonsSpringJcl.error("Are you programming a new framework without log dependencies?");
        loggerWithLog4jCORE.warn("You have coupled the application's code with a log implementation");
        loggerWithLog4jAPI.info("Ok, it is the interface of log4j2-api! But you need to change the log code later if you choose another provider such as logback");
        loggerWithSLF4jAPI.info("Ok, it is the interface of sl4fj-api! You don't need to change the log code later if you choose another provider such as logback because you hide the providers behind SL4Fj facade");
        loggerWithJUL.fine("fine");
        loggerWithJUL.finest("finest");
    }
}

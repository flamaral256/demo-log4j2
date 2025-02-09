package org.flamaral256.app;

public class Application {

    private static final org.apache.commons.logging.Log logWithApacheCommonsJcl = org.apache.commons.logging.LogFactory.getLog(Application.class);
    private static final org.apache.logging.log4j.Logger loggerWithLog4jAPI = org.apache.logging.log4j.LogManager.getLogger(Application.class);

    private static final org.slf4j.Logger loggerWithSLF4jAPI = org.slf4j.LoggerFactory.getLogger(Application.class);

    private static final org.apache.logging.log4j.core.Logger loggerWithLog4jCORE = (org.apache.logging.log4j.core.Logger)
            org.apache.logging.log4j.LogManager.getLogger(Application.class);
    private static final java.util.logging.Logger loggerWithJUL = java.util.logging.Logger.getLogger(Application.class.getName());
    private static final java.util.logging.Logger loggerWithJULGlobal = java.util.logging.Logger.getGlobal();
    private static final java.util.logging.Logger loggerWithJULAnonymous = java.util.logging.Logger.getAnonymousLogger();

    public void run() {
        logWithApacheCommonsJcl.warn("Are you programming a new framework without log dependencies? By the way it redirects to log4j");
        loggerWithLog4jCORE.warn("You have coupled the application's code with a log4j-core implementation");
        loggerWithLog4jAPI.info("OUR CHOICE! It is the interface of log4j2-api, a better facade than SL4J and where all bridges points to here directly");
        loggerWithSLF4jAPI.warn("Ok, it is the interface of sl4fj-api but log4j is a better facade! You can still use SL4j with a bridge to redirect to log4j");
        loggerWithJUL.finest("fine");
        loggerWithJUL.finest("finest");
        loggerWithJULGlobal.finest("finest Logger.getGlobal()");
        loggerWithJULAnonymous.finest("finest Logger.getAnonymousLogger()");
    }
}

package org.flamaral256.app;

import org.junit.jupiter.api.Test;

public class ApplicationTests {

    private static final org.apache.logging.log4j.Logger LOG4J = org.apache.logging.log4j.LogManager.getLogger(ApplicationTests.class);
    private static final org.slf4j.Logger SLF4J = org.slf4j.LoggerFactory.getLogger(Application.class);
    private static final java.util.logging.Logger JUL = java.util.logging.Logger.getLogger(ApplicationTests.class.getName());
    private static final java.util.logging.Logger JULGlobal = java.util.logging.Logger.getGlobal();
    private static final java.util.logging.Logger JULAnonymous = java.util.logging.Logger.getAnonymousLogger();

    @Test
    public void log_with_Jul() {
        JUL.finest("Logging in a test scope with jul");
    }

    @Test
    public void log_with_Jul_Global() {
        JULGlobal.finest("Logging in a test scope with jul global");
    }

    @Test
    public void log_with_Jul_Anonymous() {
        JULAnonymous.finest("Logging in a test scope with jul anonymous");
    }

    @Test
    public void log_with_Log4j() {
        LOG4J.info("Logging in a test scope with log4j");
    }

    @Test
    public void log_with_Slf4j() {
        SLF4J.info("Logging in a test scope with slf4j");
    }
}

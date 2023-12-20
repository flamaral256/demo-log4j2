package org.flamaral256.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTests {

    private static final org.apache.logging.log4j.Logger LOG4J = org.apache.logging.log4j.LogManager.getLogger(ApplicationTests.class);
    private static final java.util.logging.Logger JUL = java.util.logging.Logger.getLogger(ApplicationTests.class.getName());

    @Test
    public void log_with_Jul() {
        JUL.finest("Logging in a test scope with jul");
        assertTrue(true);
    }

    @Test
    public void log_with_Log4j() {
        LOG4J.info("Logging in a test scope with log4j");
        assertTrue(true);
    }
}

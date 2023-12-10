package org.flamaral256;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTests {

    static {
        if (!System.getProperties().containsKey("java.util.logging.config.file")) {
            try (InputStream julConfigFile = Main.class.getResourceAsStream("/logging.properties")) {
                requireNonNull(julConfigFile, "logging.properties not founded in classpath");
                LogManager.getLogManager().readConfiguration(julConfigFile);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    private static final org.apache.logging.log4j.Logger LOG4J = org.apache.logging.log4j.LogManager.getLogger(ApplicationTests.class);
    private static final java.util.logging.Logger JUL = java.util.logging.Logger.getLogger(ApplicationTests.class.getName());

    @Test
    public void logWithJul() {
        JUL.finest("Logging in a test scope with jul");
        assertTrue(true);
    }

    @Test
    public void logWithLog4j() {
        LOG4J.info("Logging in a test scope with log4j");
        assertTrue(true);
    }
}

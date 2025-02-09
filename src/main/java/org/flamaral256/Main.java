package org.flamaral256;

import org.flamaral256.app.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

public class Main {

    public static void configureJul() {
        if (System.getProperty("java.util.logging.manager") == null) {
            System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager"); // routes JUL to log4j
        }

        // if a logging.properties file was not informed via -D, uses resources/logging.properties as default
        if (System.getProperty("java.util.logging.config.file") == null) {
            try (InputStream julConfigFile = Main.class.getResourceAsStream("/logging.properties")) {
                requireNonNull(julConfigFile, "logging.properties not founded in classpath");
                LogManager.getLogManager().readConfiguration(julConfigFile);
            } catch (IOException e) {
                Logger.getGlobal().log(Level.SEVERE, "IOException getting resources/logging.properties", e);
            }
        }
    }

    static {
        configureJul(); // no Logger or LogManager call can be made before this method call!
    }

    public static void main(String[] args) {
        final Application app = new Application();
        app.run();
    }
}

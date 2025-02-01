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
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager"); // routes JUL to log4j

        // if a -D parameter was not defined with a logging.properties at java -jar command, use the default file in resources
        if (!System.getProperties().containsKey("java.util.logging.config.file")) {
            try (InputStream julConfigFile = Main.class.getResourceAsStream("/logging.properties")) {
                requireNonNull(julConfigFile, "logging.properties not founded in classpath");
                LogManager.getLogManager().readConfiguration(julConfigFile);
            } catch (IOException e) {
                Logger.getGlobal().log(Level.WARNING, "IOException getting resource logging.properties", e);
                System.exit(-1);
            }
        }
    }

    static {
        configureJul();
    }

    public static void main(String[] args) {
        final Application app = new Application();
        app.run();
        System.exit(0);
    }
}

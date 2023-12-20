package org.flamaral256;

import org.flamaral256.app.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import static java.util.Objects.requireNonNull;

public class Main {

    public static void configureJul() {
        // if a -D parameter was not defined with a logging.properties at java -jar, use the default file in resources
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

    static {
        configureJul();
    }

    public static void main(String[] args) {
        final Application app = new Application();
        app.run();
        System.exit(0);
    }
}

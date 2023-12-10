package org.flamaral256;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import static java.util.Objects.requireNonNull;

public class Main {

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

    public static void main(String[] args) {
        final Application app = new Application();
        app.run();
        System.exit(0);
    }
}

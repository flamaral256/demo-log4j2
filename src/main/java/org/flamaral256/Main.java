package org.flamaral256;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) {
        if (!System.getProperties().containsKey("java.util.logging.config.file")) {
            try (InputStream julConfigFile = Main.class.getResourceAsStream("/logging.properties")) {
                LogManager.getLogManager().readConfiguration(julConfigFile);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        final Application app = new Application();
        app.run();
        System.exit(0);
    }
}

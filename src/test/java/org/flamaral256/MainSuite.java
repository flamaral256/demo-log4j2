package org.flamaral256;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.LauncherSession;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.LogManager;

import static java.util.Objects.requireNonNull;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectPackages("org.flamaral256.app")
@IncludeClassNamePatterns(".*Tests")
public class MainSuite {

    static {
        // if a -D parameter was not defined with a logging.properties at java -jar, use the default file here
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
        final LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(MainSuite.class))
                .build();

        final SummaryGeneratingListener listener = new SummaryGeneratingListener();

        try (LauncherSession session = LauncherFactory.openSession()) {
            final Launcher launcher = session.getLauncher();
            // Register a listener of your choice
            launcher.registerTestExecutionListeners(listener);
            // Discover tests and build a test plan
            final TestPlan testPlan = launcher.discover(request);
            // Execute test plan or alternatively, execute the request directly with launcher.execute(request);
            launcher.execute(testPlan);
        }

        final TestExecutionSummary summary = listener.getSummary();
        summary.printTo(new PrintWriter(System.out));

        System.exit(0);
    }
}

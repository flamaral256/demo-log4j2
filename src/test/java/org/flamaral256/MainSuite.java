package org.flamaral256;

import org.flamaral256.app.ApplicationTests;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.LauncherSession;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.suite.api.*;

import java.io.PrintWriter;

import static org.flamaral256.Main.configureJul;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectPackages("org.flamaral256.app")
@IncludeClassNamePatterns(".*Tests")
public class MainSuite {

    private static final org.apache.logging.log4j.Logger LOG4J = org.apache.logging.log4j.LogManager.getLogger(ApplicationTests.class);

    static {
        configureJul(); // only called when executing tests through main method bellow
    }

    @BeforeSuite
    static void beforeSuite() {
        LOG4J.info("beforeSuite");
    }

    @AfterSuite
    static void afterSuite() {
        LOG4J.info("afterSuite");
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
    }
}

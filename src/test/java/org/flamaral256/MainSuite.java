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

import java.io.PrintWriter;

import static org.flamaral256.Main.configureJul;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectPackages("org.flamaral256.app")
@IncludeClassNamePatterns(".*Tests")
public class MainSuite { // if you run tests using IDE integration you should set up jul file properties as a -D parameter

    static {
        // only called when executing tests through main method bellow
        configureJul();
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

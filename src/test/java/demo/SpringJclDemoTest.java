package demo;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class SpringJclDemoTest {

	private static final Logger logger = LogManager.getLogger(SpringJclDemoTest.class);

	@Test
	public void foo() {
		logger.info("Logging in a test scope");
		assertTrue(true);
	}
}

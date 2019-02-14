package demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpringJclDemo {

	private static final Log logWithCustomApacheCommonsSpringJcl = LogFactory.getLog(SpringJclDemo.class);
	private static final Logger loggerWithLog4jAPI = LogManager.getLogger(SpringJclDemo.class);
	private static final org.apache.logging.log4j.core.Logger loggerWithLog4jCORE = (org.apache.logging.log4j.core.Logger) LogManager
			.getLogger(SpringJclDemo.class);

	public static void main(String[] args) {
		logWithCustomApacheCommonsSpringJcl.error("Are you programming a new framework without log dependencies?");
		loggerWithLog4jCORE.warn("You have coupled the application's code with a log implementation");
		loggerWithLog4jAPI.info("Ok, it is an interface! You can change the log implementation later");
	}
}

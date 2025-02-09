### There are two principals approaches for logging in applications:

1. Log4j api + Log4j Core implementation <= (my choice due to better documentation)
2. SL4J api + Logback implementation <= (not my choice due to bad documentation)

This project is a demo to concentrate all logging's apis (including JUL and SL4J) into the log4j, my chosen log framework.
Also, this project uses apache-commons-logging to demonstrate its use in libraries that needs to be agnostic from log dependencies.
The use of JUL (java.util.logging), a native java logger used in many libraries (e.g. postgres), is also demonstrated.

### There are two ways to redirect all foreign logging calls (SL4J, JUL etc) into the log4j:

1. Bridge all logging APIs directly to Log4j API <= (the recommended way and my choice)
2. Bridge all logging APIs to SLF4J, and bridge SLF4J to Log4j API <= (not my choice due to the need to cross multiple bridges)

### The setup of JUL (java.util.logging) to redirect to log4j: 

At startup, the JUL LogManager class is located using the java.util.logging.manager system property.
To use the log4j-jul, this property must point to org.apache.logging.log4j.jul.LogManager. There are two ways here:

1. Use System.setProperty() in main class before any calls to LogManager or Logger <= (my choice to force the log4j-jul use)
2. Set it in command line with the -Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager

By default, the LogManager reads its initial configuration from a properties file "lib/logging.properties" in the JRE directory.
If you edit that property file you can change the default logging configuration for all uses of that JRE. Bad idea!
To allow more control over reading the initial configuration we have three options:

1. Loads src/main/resources/logging.properties as default configuration <= (my choice for general proposes and practice)
2. Set -Djava.util.logging.config.file property <= (not my choice but useful if we need to override item 1)
3. Set -Djava.util.logging.config.class property <= (not my choice to configure JUL in a programmable way)

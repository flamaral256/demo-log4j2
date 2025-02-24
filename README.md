# General log4j2 setup 

## Set up the log4j2 as the central log library and bridges SL4J and JUL to it

### There are two principals approaches for logging:

1. Log4j api + Log4j Core implementation <= (my choice due to better documentation)
2. SL4J api + Logback implementation <= (not my choice due to bad documentation)

This project is a demo to concentrate all logging's apis (including JUL and SL4J) into the log4j, my chosen log framework.

Ref: https://logging.apache.org/log4j/2.x/index.html <= the current version of this demo

Ref: https://logging.apache.org/log4j/3.x/index.html <= the next future version

Also, this project uses apache-commons-logging to demonstrate its use in libraries that needs to be agnostic from log dependencies.
The use of JUL (java.util.logging), a native java logger used in many libraries (e.g. postgres), is also demonstrated.

### There are two ways to redirect all foreign logging calls (SL4J, JUL etc) into the log4j:

1. Bridge all logging APIs (including SLF4J calls) directly to Log4j API <= (the recommended way and my choice)
2. Bridge all logging APIs to SLF4J, and bridge SLF4J to Log4j API <= (not my choice due to the need to cross multiple bridges)

### The setup of JUL (java.util.logging) to redirect to log4j: 

This project doesn't use the java.util.logging.manager system property pointing it to org.apache.logging.log4j.jul.LogManager
The reason is that JUL global logger and JUL anonymous logger don't print messages when using the log4j2.jul.LogManager
Instead, this project set the Log4jBridgeHandler in logging.properties to route all the jul events into the log4j2.
There is also a Log4jBridgeHandler.install(), but for some reason, using it makes the JUL anonymous log don't appear.

By default, the LogManager reads its initial configuration from "lib/logging.properties" in the JRE directory.
If you edit this file, you may change the default logging configuration for all users of that JRE. Bad idea!
To allow more control over reading the initial configuration we have three options:

1. Loads src/main/resources/logging.properties as default configuration <= (my choice for general proposes and practice)
2. Set -Djava.util.logging.config.file property <= (not my choice but useful to override item 1 and use in mvn cli surefire)
3. Set -Djava.util.logging.config.class property <= (not my choice to configure JUL in a programmatic way)

## Configuring the entire log4j ecosystem

There are too many properties in log4j2 framework divided in groups of configuration, for better understanding and organization.

### Group 1: Status logger properties

It is the logging system used by Log4j2 for reporting status of its internals.
Basically we set the log level status to see the bootstrap of log4j2 framework.
Its configuration file is log4j2.StatusLogger.properties to be more explicit.

### Group 2: Framework system properties

It is the global properties that log4j2 expose for its general working.
Basically we force the configuration file to be in properties format and set the root log level.
Also, we can change the file location URI to externalize the configuration in the environment.
Its configuration file is log4j2.system.properties to be more explicit.

### Group 3: User logging definitions properties

For the user perspective it is the only file needed, where we set de appenders, loggers and layouts.
Its configuration file is log4j2.properties to be more explicit.

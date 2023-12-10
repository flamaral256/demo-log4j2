Esse projeto usa o spring-boot-starter-parent como gerenciador de dependencias somente e não o contexto do spring framework diretamente e menos ainda o spring boot.
Somente alguns módulos de suporte do vasto ecossistema do spring framework são utilizados aqui e não o IoC container propriamente.
A ideia é que a aplicação seja o mais puro java quanto possível, mas com algumas funcionalidades core como logging e jdbc facilitadas pelo spring.
O spring-boot-maven-plugin é usado para criar um jar executável com algumas classes de suporte para loader que no total somam apenas 219K de tamanho final.

The Apache Commons Logging API is an ultra-thin bridge between different logging implementations. A library that uses the commons-logging API can be used with any logging implementation at runtime.
Commons Logging comes with support for a number of popular logging implementations, and writing adapters for others is a reasonably simple task. Spring-jcl is a minimum implementation of Apache Commons Logging.

This project is a demo for the use of JUL (java.util.logging) (due to many frameworks (e.g. spring and postgres) use it), together with log4j2 (focused for the application itself).
At startup, the JUL LogManager class is located using the java.util.logging.manager system property.
By default, the LogManager reads its initial configuration from a properties file "lib/logging.properties" in the JRE directory.
If you edit that property file you can change the default logging configuration for all uses of that JRE.
In addition, the LogManager uses two optional system properties that allow more control over reading the initial configuration:

"java.util.logging.config.class"
"java.util.logging.config.file"

We set up an initial static constructor in main class where we load the src/main/resources/logging.properties packaged in classpath
, only if the java.util.logging.config.file property was NOT set, allowing to override with an alternative logging.properties file outside the jar using -D option.

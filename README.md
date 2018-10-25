# REST API with OSGi

A REST API example with following technologies,

1. Java
1. OSGi framework
1. OSGi annotations
1. Apache Karaf
1. Apache Felix
1. Apache CXF
1. JAX-RS
1. Eclipse Jetty
1. Log4J

### How to build

```bash
mvn clean install
```

### How to run

1. Navigate to `osgi-cxf-karaf-example/server/target` directory.
1. Unzip `server-<version>.zip` file.
1. Navigate to bin directory 
1. Use following commands to run;
    1. To start with the Karaf shell use: `./karaf`
    1. To start in background use: `./start`
    1. To check the status use: `./status`
    1. To stop the background service use: `./stop`

### How to test

Use following CURL command,

```bash
curl -v -k -0 -H "Content-Type: application/json" -d "{\"username\": \"hello\", \"password\": \"foo\"}" -X POST http://localhost:7005/cxf/api/example

```

Or simply run `./sample.curl.sh`

### How to debug

* The default log level is `INFO`. 
* If you want to change the log level, you can change `log4j2.rootLogger.level = INFO` parameter in `osgi-cxf-karaf-example/server/src/main/resources/etc/org.ops4j.pax.logging.cfg` file.
* You can check/tail `server-1.0-SNAPSHOT/data/log/karaf.log` file for logs. 

### How to change the port

* This service will start at port no `7005`
* If you want to change the port, you can change `org.osgi.service.http.port=7005` parameter in `osgi-cxf-karaf-example/server/src/main/resources/etc/org.ops4j.pax.web.cfg` file.

### For a quick customization

Have a look on following modules,

1. core/api - Contains POJO classes.
1. core/rest - Implemented REST API and routes.
1. core/service - Implemented a sample service to process REST API requests.



























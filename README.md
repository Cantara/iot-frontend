# IotFrontend

![Build Status](https://jenkins.capraconsulting.no/buildStatus/icon?job=iot-frontend) - [![Project Status: Active – The project has reached a stable, usable state and is being actively developed.](http://www.repostatus.org/badges/latest/active.svg)](http://www.repostatus.org/#active)  

[![Known Vulnerabilities](https://snyk.io/test/github/Cantara/iot-frontend/badge.svg)](https://snyk.io/test/github/Cantara/iot-frontend)


Access IoT Devices api. Subscribe to updates from devices.

## Install

```
mvn install
```

## Run
```
java -jar target/iot-frontend-0.1-SNAPSHOT.jar
or 
./run.sh 
or 
run.bat
```

## Enter webclient

* https://localhost:8080/frontend


## Healthcheck
```
http://localhost:8081/IotFrontend/healthcheck
```

## Hystrix

We recomend to enhance your remote http calls within Hystrix Commands. 
It is quite simple, have a look at the ProxyExampleResource.

To generate example data use http://<host>:<port>/IotFrontend/proxy?url=<some_host_to_get_data_from>



This application will forward Hystrix statistics and metrics on http://<host>:<adminPort>/hystrix.stream.
Use a Hystrix dashboard to view these data. See https://github.com/Netflix/Hystrix/tree/master/hystrix-dashboard
 
 Read more about Hystrix at:
 * https://github.com/Netflix/Hystrix/wiki/Getting-Started
 * https://github.com/zapodot/hystrix-dropwizard-bundle
 
 ## Deployment
 
 ### Static content
 http://localhost:8080/frontend/
 
 ### Dynamic content and api
  http://localhost:8080/IotFrontend/


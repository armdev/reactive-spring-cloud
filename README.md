# reactive-spring-cloud
reactive-spring-cloud, hystrix, turbine, eureka

Simple run on localhost


Execute hystrix command http://localhost:7001/api/v2/actions/find

Hystrix stream on the same host http://localhost:7001/actuator/hystrix.stream

Hystrix monitor dashboard: http://localhost:8081/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A7001%2Factuator%2Fhystrix.stream

///// old
Turbine stream http://localhost:8082/turbine.stream

Hystrix http://localhost:8081/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8082%2Fturbine.stream

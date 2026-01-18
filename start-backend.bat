@echo off
echo Starting all InsureFlowX Services...

start "Gateway (8080)" mvn spring-boot:run -pl integration-gateway
timeout /t 5

start "Policy Service (8081)" mvn spring-boot:run -pl policy-service
start "Underwriting Service (8082)" mvn spring-boot:run -pl underwriting-service
start "Claims Service (8083)" mvn spring-boot:run -pl claims-service
start "Billing Service (8084)" mvn spring-boot:run -pl billing-service

echo All services are starting in separate windows.
pause

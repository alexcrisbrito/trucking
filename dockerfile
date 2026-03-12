FROM eclipse-temurin:21-alpine
RUN mkdir /opt/app
COPY /target/truckingApp.jar /opt/app
CMD '["java","-jar","/opt/app/app.jar"]'


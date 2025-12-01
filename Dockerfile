FROM eclipse-temurin:21
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 7050
ENTRYPOINT ["java","-jar","/app.jar"]
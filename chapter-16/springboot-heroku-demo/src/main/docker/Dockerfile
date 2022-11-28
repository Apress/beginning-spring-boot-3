FROM java:8
ADD springboot-heroku-demo.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]

## Stage 1
#FROM eclipse-temurin:17-jre-focal as builder
#WORKDIR extracted
#ADD ./target/*.jar app.jar
#RUN java -Djarmode=layertools -jar app.jar extract
##Stage 2
#FROM eclipse-temurin:17-jre-focal
#WORKDIR application
#COPY --from=builder extracted/dependencies/ ./
#COPY --from=builder extracted/spring-boot-loader/ ./
#COPY --from=builder extracted/snapshot-dependencies/ ./
#COPY --from=builder extracted/application/ ./
#EXPOSE 8080
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

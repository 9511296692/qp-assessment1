FROM openjdk:17-jdk

COPY target/qp-assessment1-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT [ "java","-jar","qp-assessment1-0.0.1-SNAPSHOT.jar"]
FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY ./target/na-java-maven-app-*.jar /usr/app/
WORKDIR /usr/app

CMD java -jar na-java-maven-app-*.jar

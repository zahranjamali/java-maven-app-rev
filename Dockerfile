FROM openjdk:8-jre-alpine
EXPOSE 8080
RUN mkdir -p /usr/app
COPY ./target/java-maven-app* /usr/app/
WORKDIR /usr/app/
ENTRYPOINT [ "java","-jar"]
CMD java-maven-app*.jar
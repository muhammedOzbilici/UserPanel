FROM openjdk:8
ADD target/user-panel.jar user-panel.jar
EXPOSE 8484
ENTRYPOINT ["java","-jar","user-panel.jar"]
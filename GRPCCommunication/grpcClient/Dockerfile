FROM openjdk:17
COPY target/grpcClient-*.jar /src/java/grpcClient/grpcclient.jar
WORKDIR /src/java/grpcClient
EXPOSE 8888
CMD ["java","-jar","/src/java/grpcClient/grpcclient.jar"]
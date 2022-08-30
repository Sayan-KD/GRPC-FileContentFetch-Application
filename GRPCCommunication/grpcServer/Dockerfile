FROM openjdk:17
COPY files /src/java/grpcServer/
COPY target/grpcServer-*.jar /src/java/grpcServer/grpcserver.jar
WORKDIR /src/java/grpcServer
EXPOSE 8888
CMD ["java","-jar","/src/java/grpcServer/grpcserver.jar"]
Docker Steps::

Step1:
	Created Two Docker Images:
		1. Server:>   docker build -t grpc-server .
		2. Client:>   docker build -t grpc-client .
Step2:
	Created a Docker Network:
		 > docker network create --driver bridge --subnet 172.18.0.0/16 --gateway 172.18.0.1 grpc-network
Step3:
	Run The Docker Containers for Server and Client under this Docker Network:
		1. docker run --net grpc-network -it --rm --name server-container grpc-server
		2. docker run --net grpc-network -it --rm --name client-container grpc-client

**IMP**
Name of the Images here :
	1. Server: grpc-server
	2. Client: grpc-client

Name of the Docker Network Created:
	grpc-network

Name of the Containers Created:
	1. Server: server-container
	2. Client: client-container

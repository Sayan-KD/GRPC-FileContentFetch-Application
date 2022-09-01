import com.services.grpc.FileService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

	public static void main(String[] args) {
		System.out.println("Starting GRPC Server...");
		try {
			Server server = ServerBuilder.forPort(8888).addService(new FileService()).build();	//The GRPC Server Listens to Port '8888'
			server.start();
			System.out.println("SERVER Started at PORT: "+server.getPort());
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

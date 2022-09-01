import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.javastubs.grpc.filesGrpc;
import com.javastubs.grpc.Files.FetchRequest;
import com.javastubs.grpc.Files.FetchResponse;
import com.javastubs.grpc.filesGrpc.filesBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("172.18.0.2", 8888).usePlaintext().build();  // '172.18.0.2' is the IP Address of the Server Container.
		filesBlockingStub fileStubs= filesGrpc.newBlockingStub(channel);
		String fetchagain="no";
		try {
			do {
				System.out.print("Enter Filepath: ");
				String filepath= bufferedReader.readLine();
				System.out.print("Enter Filename: ");
				String filename= bufferedReader.readLine();
				
				FetchRequest request=FetchRequest.newBuilder().setFilepath(filepath).setFilename(filename).build();	
				FetchResponse response = fileStubs.fetchcontents(request);
				System.out.println("SERVER : \n"+response.getFilecontent());
				System.out.print("Fetch Other Files? ['yes'] OR ['no']: ");
				fetchagain=bufferedReader.readLine();
			}while(fetchagain.equalsIgnoreCase("yes"));
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}

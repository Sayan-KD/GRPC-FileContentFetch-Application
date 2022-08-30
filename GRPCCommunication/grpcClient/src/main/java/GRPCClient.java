import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.javastubs.grpc.filesGrpc;
import com.javastubs.grpc.Files.APIResponse;
import com.javastubs.grpc.Files.FetchRequest;
import com.javastubs.grpc.filesGrpc.filesBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("172.18.0.2", 8888).usePlaintext().build();
		filesBlockingStub fileStubs= filesGrpc.newBlockingStub(channel);
		String again="no";
		try {
			do {
				System.out.print("Enter Filepath: ");
				String filepath= bufferedReader.readLine();
				System.out.print("Enter Filename: ");
				String filename= bufferedReader.readLine();
				
				FetchRequest fetchRequest=FetchRequest.newBuilder().setFilepath(filepath).setFilename(filename).build();
				APIResponse fetchresponse = fileStubs.fetchcontents(fetchRequest);
				System.out.println("SERVER : \n"+fetchresponse.getFilecontent());
				System.out.print("Fetch Other Files? ['yes'] OR ['no']: ");
				again=bufferedReader.readLine();
			}while(again.equalsIgnoreCase("yes"));
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

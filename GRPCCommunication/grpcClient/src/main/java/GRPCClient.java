import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.telaverge.client.filesGrpc;
import com.telaverge.client.Files.FetchRequest;
import com.telaverge.client.Files.FetchResponse;
import com.telaverge.client.filesGrpc.filesBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
  private static final String LOG_FILE = "./property/log4j.properties";
  public static void main(String[] args) throws IOException {
    Logger logger = loggerInfo();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    ManagedChannel channel = ManagedChannelBuilder.forAddress("172.18.0.2", 8888).usePlaintext().build(); // '172.18.0.2' is the IP Address of the Server Container.
    filesBlockingStub fileStubs = filesGrpc.newBlockingStub(channel);
    String fetchagain = "no";
    do {
      FetchResponse response = fileInfo(bufferedReader, fileStubs);
      logger.info("SERVER : \n" + response.getFilecontent());
      logger.debug("Fetch Other Files? ['yes'] OR ['no']: ");
      fetchagain = bufferedReader.readLine();
    } while (fetchagain.equalsIgnoreCase("yes"));
  }
  public static Logger loggerInfo() {
    Logger logger = LogManager.getLogger(GRPCClient.class);
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream(LOG_FILE));
      PropertyConfigurator.configure(properties);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return logger;
  }
  public static FetchResponse fileInfo(BufferedReader bufferedReader, filesBlockingStub fileStubs) {
    FetchRequest request;
    FetchResponse response = null;
    try {
      System.out.print("Enter Filepath: ");
      String filepath = bufferedReader.readLine();
      System.out.print("Enter Filename: ");
      String filename = bufferedReader.readLine();
      request = FetchRequest.newBuilder().setFilepath(filepath).setFilename(filename).build();
      response = fileStubs.fetchcontents(request);;

    } catch (Exception e) {
      System.out.println(e);
    }
    return response;
  }
}
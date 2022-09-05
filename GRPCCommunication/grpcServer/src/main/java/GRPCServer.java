import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.services.grpc.FileService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {
  private static final String LOG_FILE = "./property/log4j.properties";
  public static void main(String[] args) {
    Logger logger = LogManager.getLogger(GRPCServer.class);
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream(LOG_FILE));
      PropertyConfigurator.configure(properties);
      logger.debug("Starting GRPC Server...");
      Server server = ServerBuilder.forPort(8888).addService(new FileService()).build(); //The GRPC Server Listens to Port '8888'
      server.start();
      logger.info("SERVER Started at PORT: " + server.getPort());
      server.awaitTermination();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
package com.services.grpc;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.telaverge.server.filesGrpc.filesImplBase;
import com.telaverge.server.Files.FetchRequest;
import com.telaverge.server.Files.FetchResponse;
import io.grpc.stub.StreamObserver;

public class FileService extends filesImplBase {
  @Override
  public void fetchcontents(FetchRequest request, StreamObserver < FetchResponse > responseObserver) {
    String filepath = request.getFilepath();
    String filename = request.getFilename();
    FetchResponse.Builder response = FetchResponse.newBuilder();
    Scanner scanner = null;
    StringBuilder stringbuilder = new StringBuilder();;
    if (filename.equals("")) {
      File allfiles = new File(filepath);
      String[] fileList = allfiles.list();
      stringbuilder.append("Available Files and Directories: ");
      for (String files: fileList) {
        stringbuilder.append("[" + files + "] ");
      }
      for (String files: fileList) {
        File file = new File(allfiles, files);
        if (file.isFile()) {
          try {
            scanner = new Scanner(file);
            stringbuilder.append("\n--------------[ " + files + " ]--------------\n");
            while (scanner.hasNextLine()) {
              stringbuilder.append(scanner.nextLine() + "\n");
            }
            stringbuilder.append("<---------------[ END OF " + files + " ]--------------->\n");
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          } finally {
            scanner.close();
          }
        }
      }
      response.setResponsecode(0).setFilecontent(stringbuilder.toString());
    } else {
      File file = new File(filepath, filename);
      if (file.isFile()) {
        try {
          scanner = new Scanner(file);
          stringbuilder = new StringBuilder();
          while (scanner.hasNextLine()) {
            stringbuilder.append(scanner.nextLine() + "\n");
          }
          response.setResponsecode(0).setFilecontent(filename + "\n" + stringbuilder.toString());

        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } finally {
          scanner.close();
        }
      } else {
        response.setResponsecode(100).setFilecontent("INCORRECT FILENAME " + filename + " !");
      }
    }
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }
}
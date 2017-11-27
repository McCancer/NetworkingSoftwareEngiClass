import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
Matthew Kunzer
Web Get server
 */
public class GetServer
{
    public static void main(String[] args) throws IOException{
      final int PORT = 8080;
      ServerSocket server = new ServerSocket(PORT);
      System.out.println("Waiting for a connection");
    
      while(true){
        try(Socket s  = server.accept()){
            System.out.println("Client Connected");
            GetService service = new GetService(s);
            Thread t = new Thread(service);
            t.start();
        }
        
      }
  }
}

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
Matthew Kunzer
Chat Server
 */
public class ChatServer
{
    public static void main(String[] args) throws IOException{
       final int CHAT_PORT = 8989;
       ServerSocket Server = new ServerSocket(CHAT_PORT);
       System.out.println("Server Created waiting for connection");
    
       while(true){
         try(Socket S = Server.accept()){
            System.out.println("Client Connected");
            ChatService service = new ChatService(S);
            Thread t = new Thread(service);
            t.start();
            System.out.println("waiting for another Connection");
         }
        }
    }
}
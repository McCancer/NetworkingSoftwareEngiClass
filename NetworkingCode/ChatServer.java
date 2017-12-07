import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;

/**
Matthew Kunzer
Chat Server
 */
public class ChatServer
{
    public static void main(String[] args) throws IOException{
       ChatRoom Room = new ChatRoom();
       final int CHAT_PORT = 8989;
       PrintWriter pass;
       ServerSocket Server = new ServerSocket(CHAT_PORT);
       System.out.println("Server Created waiting for connection");
       
       while(true){
         try(Socket S = Server.accept()){
            System.out.println("Client Connected");
            ChatService service = new ChatService(S , Room);
            pass = new PrintWriter(S.getOutputStream());
            Room.addClient(pass);
            Thread t = new Thread(service);
            t.start();
            System.out.println("waiting for another Connection");
         }
        }
    }
}
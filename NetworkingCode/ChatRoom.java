import java.net.*;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * Write a description of class ChatRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChatRoom
{
    private PrintWriter[] Clients = new PrintWriter[15];
    
    private int i = 0;
    
    public ChatRoom(){
        
    }
    
    public void sendMessage(String message) throws IOException{
        PrintWriter out;
        for(int t = 0; t < Clients.length; t++){
            out = Clients[t];
                out.println(message);
                out.flush();
        }
    }
    
    public void addClient(PrintWriter b){
        Clients[i] = b;
        i++;
    }
}

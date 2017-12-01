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
    private Socket[] Clients = new Socket[15];
    
    private int i = 0;
    
    public ChatRoom(){
        
    }
    
    public void sendMessage(String message) throws IOException{
        PrintWriter out;
        Socket temp; 
        for(i = 0; i < Clients.length; i++){
            temp = Clients[i];
            try{
                out = new PrintWriter(temp.getOutputStream());
                out.println(message);
                out.flush();
            }
            catch(IOException exception){
                System.out.println("error sending message");
            }
        }
    }
    
    public void addClient(Socket b){
        Clients[i] = b;
        i++;
    }
}

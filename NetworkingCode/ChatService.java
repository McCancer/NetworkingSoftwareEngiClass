import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 * Write a description of class ChatService here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChatService implements Runnable
{
    private Socket s;
    private InputStream instream;
    private Scanner in;
    private ChatRoom room;
    private String name = "NoName";
    private String message = "";
    
    public ChatService(Socket aSocket, ChatRoom aroom) throws java.io.IOException{
        s = aSocket;
        room = aroom;
        instream = s.getInputStream();
    }
    
    public void run(){
        try{
            in = new Scanner(instream);
            doService();
        }
        catch(IOException exception){
            System.out.println("Error code HoneyBee");
        }
    }
    
    public void doService() throws IOException{
        while(true){
            String command = "";
            if(!in.hasNext()){command = "";}
            if(in.hasNext()){command = in.nextLine();
            System.out.println("2");}
            if(command.equals("quit")){
                return;
            }
            executeCommand(command);
        }
    }
    
    public void executeCommand(String command) throws IOException { 
        if(command.equals("send")){
            message = name + ": " ;
            while(in.hasNext()){
                message = message + in.nextLine(); 
            }
            room.sendMessage(message);
            message = ""; 
        }
        else if(command.equals("Login")){
           name = ""; 
           while(in.hasNext()){
            name = name + in.nextLine();
           }
            
        }
    }
}

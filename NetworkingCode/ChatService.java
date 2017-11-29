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
    private Scanner in;
    private PrintWriter out;
    
    public ChatService(Socket aSocket){
        s = aSocket;
    }
    
    public void run(){
        try{
            in = new Scanner(s.getInputStream());
            out = new PrintWriter(s.getOutputStream());
            doService();
        }
        catch(IOException exception){
            Exception.printStackTrace();
        }
    }
}
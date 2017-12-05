import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.InputStream;
import java.io.IOException;
/**
 * Write a description of class ChatClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChatClient
{
    public static void main(String args[]) throws IOException{
        boolean exit = false;
        InputStream inStream;
        OutputStream outStream;
        Scanner in;
        Scanner ClientInput = new Scanner(System.in);
        PrintWriter out;
        String input = "";
        try(Socket s = new Socket("localhost", 8989)){
            inStream = s.getInputStream();
            outStream = s.getOutputStream();
            in = new Scanner(inStream);
            out = new PrintWriter(outStream);
            while(exit!= true){
                System.out.println("S - send message, L-login  Q-Quit");
                input = ClientInput.next();
                if(in.hasNext()){
                    while(in.hasNext()){
                    System.out.print(in.next());
                   }
                }
                if(input.equals("S")){
                
                }
                if(input.equals("L")){
                
                }
                if(input.equals("Q")){exit = true;}
            }
        }
        catch(IOException Exception){
            System.out.println("SERVER NOT FOUND");
        }
    }
}

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
        String message = "";
        try(Socket s = new Socket("localhost", 8989)){
            inStream = s.getInputStream();
            outStream = s.getOutputStream();
            in = new Scanner(inStream);
            out = new PrintWriter(outStream);
            while(exit!= true){
                System.out.println("\nS - send message, L-login  Q-Quit");
                input = ClientInput.nextLine();
                if(in.hasNext()){
                    while(in.hasNext()){
                        System.out.println("we go here");
                     String data = in.nextLine();
                    System.out.println(data);
                   }
                }
                if(input.equals("S")){
                    input = "send\n";
                    message = ClientInput.nextLine();
                    input = input + message +"\n";
                    out.print(input);
                    out.flush();
                    input = "";
                }
                if(input.equals("L")){
                    input = "login\n";
                    message = ClientInput.nextLine();
                    input = input + message + "\n";
                    out.print(input);
                    out.flush();
                    input = "";
                }
                if(input.equals("Q")){
                    out.print("quit");
                    out.flush();
                    exit = true;
                }
            }
        }
        catch(IOException Exception){
            System.out.println("SERVER NOT FOUND");
        }
    }
}

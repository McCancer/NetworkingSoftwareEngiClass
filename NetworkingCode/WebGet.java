import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Write a description of class WebGet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WebGet
{
    public static void main(String[] args)throws IOException
    {
        String host;
        String resource;
        if(args.length == 2){
            host = args[0];
            resource = args[1];
        }//end of if
        else{
            System.out.println("getting From a Local Host");
            host = "localhost"; //Enter website here
            resource = " Tester.txt"; // /
        }//end of else
        //Opens socket
        final int HTTP_PORT = 80;
        try(Socket s = new Socket(host, HTTP_PORT)){
            //Get stream
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();
            //turn streams into scanner and writers
            Scanner in = new Scanner(instream);
            PrintWriter out = new PrintWriter(outstream);
            //send command
            String Command = "GET " + resource;
            out.print(Command);
            out.flush();
            //read server response
            while(in.hasNextLine()){
                String input = in.nextLine();
                System.out.println(input);
            }//end of while loop
        }//end of try statement Closes the socket
    }//end of main
}//end of class

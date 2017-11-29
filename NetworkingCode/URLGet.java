import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Write a description of class URLGet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class URLGet
{
    public static void main(String[] args) throws IOException{
        String urlString;
        if(args.length == 1){
            urlString = args[0];
        }
        else{
            urlString = "ENTER URL HERE";
            System.out.println("using " + urlString);
        }
        URL u = new URL(urlString);
        URLConnection connection = u.openConnection();
        
        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        
        int code = httpConnection.getResponseCode();
        String message = httpConnection.getResponseMessage();
        System.out.println(code + " " + message);
        if(code != HttpURLConnection.HTTP_OK){
            return;
        }
        
        InputStream instream = connection.getInputStream();
        Scanner in = new Scanner(instream);
        
        while(in.hasNextLine()){
            String input = in.nextLine();
            System.out.println(input);
        }
    }

}

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner; 
import java.io.FileNotFoundException;
import java.io.File;
/**

 */
public class GetService implements Runnable 
{
    private Socket s; 
    private Scanner in;
    private PrintWriter out;
    
    public GetService(Socket aSocket){
        s = aSocket; 
    }
    
    public void run(){
        try{
            in = new Scanner(s.getInputStream());
            out = new PrintWriter(s.getOutputStream());
            doService();
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
    }
    
    public void doService() throws IOException{
        while(true){
            if(!in.hasNext()){return;}
            String command = in.next();
            if(command.equals("Quit")){return;}
            else{executeCommand(command);}
        }
     }
     
    public void executeCommand(String command)throws FileNotFoundException{
        if(command.equals("GET")){
            String Return  = ""; 
            String file = in.nextLine();
            File filename = new File(file);
            try(Scanner reader = new Scanner(filename)){
                out.println("HTTP/1,1 200 OK");
                while(reader.hasNext()){
                    Return = reader.next();
                    out.print(Return);                   
                }//End of While loop
                out.flush();
            }//End of try Statement 
            catch(FileNotFoundException x){
                out.println("404 File not found Error");
                out.flush();
            }
        }//End of if Statement 
    }//End of Execture command Method
}//End ocf class

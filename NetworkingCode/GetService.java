import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner; 

/**

 */
public class GetService
{
    private Socket s; 
    private Scanner in;
    private PrintWriter out;
    
    public BankService(Socket aSocket){
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
            else{executeCommand(
        }
    }
}

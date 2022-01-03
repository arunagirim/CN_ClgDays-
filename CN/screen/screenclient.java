
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class screenclient
{
    public static void main(String [] args)
    {
        try 
        {
            Socket s=new Socket("localhost",6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the filename to save the screenshot");
            String str=buf.readLine();
            dout.writeUTF("C:\\Users\\Dark-Knight\\Desktop\\"+str);
            System.out.println("File will be saved in the server.............");
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
}

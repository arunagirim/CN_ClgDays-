
import java.io.DataOutputStream;
import java.net.Socket;

public class httpclientupload 
{
    public static void main(String [] args)
	{
		 try
	        {
	            Socket s=new Socket("localhost",6666);
	            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
	            dout.writeUTF("C:\\Users\\Dark-Knight\\Desktop\\2.jpg");
	            dout.close();
	            s.close();
	            
	        }
	        catch(Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
	}
    
}

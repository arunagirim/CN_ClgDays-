

import java.io.DataInputStream;
import java.net.Socket;
public class Broadcastclient
{
     public static void main(String [] args)
    {
        try
        {
            Socket s=new Socket("192.168.56.1",3333);
            DataInputStream din=new DataInputStream(s.getInputStream());
            String str=(String)din.readUTF();
            System.out.println("Message recieved: "+str);
            s.close();
            din.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
}

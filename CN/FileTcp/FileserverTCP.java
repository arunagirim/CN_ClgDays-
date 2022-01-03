package cnlab;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileserverTCP 
{
    public static void main(String [] args)
    {
        try
        {
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();

            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF("C:\\Users\\Cs Koushik\\Desktop\\sample.txt");
            System.out.println("File transferred");
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}

package cnlab;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Echoserver 
{
    public static void main(String [] args)
    {
        try 
        {
            ServerSocket sok=new ServerSocket(6666);
            Socket s=sok.accept();
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            String str="";
            while(!str.equals("bye"))
            {
                str=dis.readUTF();
                System.out.println("Received message: "+str);
                dout.writeUTF("Received message: "+str);
            }
            s.close();
            sok.close();
        } 
        catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
}

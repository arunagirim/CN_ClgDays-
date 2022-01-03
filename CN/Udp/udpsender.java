package cnlab;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpsender 
{
    public static void main(String [] args)
    {
        try
        {
           
            DatagramSocket ds=new DatagramSocket();
           
            String str="C:\\Users\\Cs Koushik\\Desktop\\sample.txt";
            System.out.println("File transfer is being carried out..........");
            InetAddress ip=InetAddress.getByName("127.0.0.1");
            DatagramPacket dp=new DatagramPacket(str.getBytes(), str.length(),ip,3000);
            ds.send(dp);
            ds.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

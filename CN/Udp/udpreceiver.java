package cnlab;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udpreceiver 
{
    public static void main(String [] args)
    {
        try
        {
            BufferedReader buf1=new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket ds=new DatagramSocket(3000);
            byte [] buf=new byte[1024];
            String str1=buf1.readLine();
            if(str1.equals("sample.txt"))
            {
                DatagramPacket dp=new DatagramPacket(buf, 1024);
            ds.receive(dp);
            String str=new String(dp.getData(),0,dp.getLength());
            
                System.out.println("File received.......");
                FileInputStream fin=new FileInputStream(str);
                int i;
                System.out.println("File contents are: ");
                while((i=fin.read())!=-1)
                {
                    System.out.print((char)i);
                }
                System.out.println();
                fin.close();
            }
            else
            {
                System.out.println("File name error");
            }
            ds.close();
            //fin.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

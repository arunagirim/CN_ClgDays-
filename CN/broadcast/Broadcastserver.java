
import java.io.DataOutputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.DatagramChannel;
import java.util.Random;
import java.util.Scanner;

public class Broadcastserver 
{
    public static void main(String [] args)
    {
	Random r=new Random();
        Scanner x=new Scanner(System.in);
        System.out.print("Enter the number of systems needed to be connected: ");
        int n=x.nextInt();
        System.out.println("Enter the message to be sent : hello");  
       // String y = x.nextLine();
        try
        {
            
            
            ServerSocket ss=new ServerSocket(3333);
            Socket s[]=new Socket[n];
            for(int i=0;i<n;i++)
            {
                s[i]=ss.accept();
                System.out.println("System "+(i+1)+" connected");
            }
            for(int i=0;i<n;i++)
            {
                DataOutputStream dout=new DataOutputStream(s[i].getOutputStream());
             
                dout.writeUTF("hello");
                dout.close();
                s[i].close();
            }
            System.out.println("Message sent to systems");
                
                
        }
        catch(Exception e)
        {
            
        }
    }
    
}

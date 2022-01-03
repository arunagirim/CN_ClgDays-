
package cnlab;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class slidingwindowsender
{
    
    public static void main(String [] args)
    {
        try
        {
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();
            String inp[]=new String [10];
            System.out.print("Enter the number of frames: ");
            int n=Integer.parseInt(buf.readLine());
            int i;
            System.out.println("Enter the message to be passed: ");
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            DataInputStream din=new DataInputStream(s.getInputStream());
            for(i=0;i<n;i++)
            {
                inp[i]=buf.readLine();
                dout.writeUTF(inp[i]);
            }
            
            //dout.writeUTF(String.valueOf(n));
            //for(i=0;i<n;i++)
            //{
                
            //}
            dout.writeUTF("");
            String str=(String)din.readUTF();
            System.out.println(str);
            dout.close();
            din.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}

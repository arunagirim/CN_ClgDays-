package cnlab;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class remoteclient 
{
    public static void main(String [] args)
    {
        try
        {
            Socket s=new Socket("localhost",6666);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the command to be executed: ");
            String str=buf.readLine();
            dout.writeUTF(str);
            String line;
            DataInputStream din=new DataInputStream(s.getInputStream());
            while(true)
            {
                line=(String)din.readUTF();
                if(line==null)
                {
                    break;
                }
                
                System.out.println(line);
            }
        }
        catch(Exception e)
        {
            
        }
        
    }
    
}

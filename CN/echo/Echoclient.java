package cnlab;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Echoclient 
{
    public static void main(String [] args)
    {
        try
        {
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            Socket s=new Socket("localhost",6666);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            DataInputStream din=new DataInputStream(s.getInputStream());
            String str="";
            while(!str.equals("bye"))
            {
                str=buf.readLine();
                dout.writeUTF(str);
                String str1=(String)din.readUTF();
                System.out.println(str1);
            }
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

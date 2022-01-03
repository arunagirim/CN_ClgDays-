package cnlab;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class FileclientTCP 
{
    public static void main(String [] args)
    {
        try
        {
            Socket s=new Socket("localhost",6666);
            //DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            String str=buf.readLine();
            if(str.equals("sample.txt"))
            {
                DataInputStream din=new DataInputStream(s.getInputStream());
                str=(String)din.readUTF();
                FileInputStream fin=new FileInputStream(str);
                int i;
                while((i=fin.read())!=-1)
                {
                    System.out.print((char)i);
                }
            }
            else
            {
                System.out.println("File name error and File is not found");
            }
            
            //System.out.println("The file transferred is sample.txt and the contents are ");
            //System.out.println(str);
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

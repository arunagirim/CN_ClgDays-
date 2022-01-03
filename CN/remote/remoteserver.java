package cnlab;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class remoteserver 
{
    public static void main(String [] args)
    {
        try
        {
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();
            DataInputStream din=new DataInputStream(s.getInputStream());
            String str=(String)din.readUTF();
            System.out.println("Command is executed");
            Runtime r=Runtime.getRuntime();
            Process p=r.exec(str);
            BufferedReader buf=new BufferedReader(new InputStreamReader(p.getInputStream()));
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            String line;
            while(true)
            {
                line=buf.readLine();
                if(line==null){
                    break;
                }
                dout.writeUTF(line);
                System.out.println(line);
            }
            din.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

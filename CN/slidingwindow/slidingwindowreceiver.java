
package cnlab;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class slidingwindowreceiver 
{
    public static void main(String [] args)
    {
        try
        {
            
            Socket s=new Socket("localhost",6666);
            DataInputStream din=new DataInputStream(s.getInputStream());
            String out[]=new String [10];
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            int i=0;
            //int n=Integer.parseInt((String)din.readUTF());
            while(true)
            {
                out[i]=(String)din.readUTF();
                if(out[i].equals(""))
                    break;
                if(i==0 || i==1)
                    System.out.println("The received frame "+i+" : "+out[i]);
                else
                    System.out.println("The received frame "+(i%2)+" : "+out[i]);
                i++;
                
            }
            System.out.println("Acknowlegement sent");
            //i--;
            dout.writeUTF("Acknowlegement received for "+i+" frames");
            din.close();
            dout.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

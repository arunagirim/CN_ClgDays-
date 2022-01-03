
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
public class arp 
{
    public static void main(String [] args)
    {
        try
        {
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the name of the system: ");
            String str=buf.readLine();
            InetAddress in=InetAddress.getByName(str);
            System.out.println(in);
            NetworkInterface net=NetworkInterface.getByInetAddress(in);
            byte [] mac=net.getHardwareAddress();
            int i;
            if(mac!=null)
            {
                System.out.print("MAC address is : ");
                for(i=0;i<mac.length;i++)
                {
                    System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                }
                System.out.println();
            }
            else
            {
                System.out.println("MAC address not found");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

public class screenserver 
{
    public static void main(String [] args)
    {
        try
        {
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();
            DataInputStream din=new DataInputStream(s.getInputStream());
            String str=(String)din.readUTF();
            System.out.println("Screenshot is being taken............");
            Robot rb=new Robot();
            Rectangle sct=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage img=rb.createScreenCapture(sct);
            ImageIO.write(img, "jpg", new File(str+".jpg"));
            System.out.println("Screenshot taken and saved........");
        }
        catch(Exception e)
        {
            
        }
    }
}

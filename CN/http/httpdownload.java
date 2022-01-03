import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class httpdownload 
{
    public static void main(String [] args)
    {
        String file="marvel-avengers-wallpapers-for-android-For-Desktop-Wallpaper.jpg";
        try
        {
            System.setProperty("http.agent", "Chrome");
            URL url=new URL("http://longwallpapers.com/Desktop-Wallpaper/"
                    + "marvel-avengers-wallpapers-for-android-For-Desktop-Wallpaper.jpg");
            byte [] buf=new byte[2048];
            InputStream in = url.openStream();
            OutputStream out = new FileOutputStream(file);
            int i=0;
            System.out.println("Downloading image from the website http://longwallpapers.com/Desktop-Wallpaper/");
            while((i=in.read(buf))!=-1)
            {
                out.write(buf,0,i);
            }
            in.close();
            out.close();
            System.out.println("Image successfully downloaded");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

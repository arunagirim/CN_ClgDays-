/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Cs Koushik
 */
public class httpserverupload extends JFrame
{
    public ImageIcon ic=null;
	public String loc;
	public httpserverupload()
	{
		getContentPane().setLayout(null);
		try
		{
                    ServerSocket ss=new ServerSocket(6666);
                    Socket s=ss.accept();
                    DataInputStream din=new DataInputStream(s.getInputStream());
                    loc=(String)din.readUTF();

            din.close();
            s.close();
            
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		JLabel l = new JLabel("");
                System.out.println(loc);
		l.setIcon(new ImageIcon(loc));
		l.setBounds(0, 0, 1366, 768);
		
		getContentPane().add(l);
		
		
	}
	public static void main(String [] args)
	{
            httpserverupload hp=new httpserverupload();
            try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(httpserverupload.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(hp, "Upload Successfull","Success",JOptionPane.INFORMATION_MESSAGE);
		
		hp.setSize(1366, 768);
		hp.setVisible(true);
                
	}
    
}

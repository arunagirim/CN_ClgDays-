package cnlab;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hammingcode 
{
    //7 bit hamming code is most frequently used
    public static void main(String [] args)
    {
        try
        {
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            String str=buf.readLine();
            char [] s=str.toCharArray();
            char d11,d10,d9,d7,d6,d5,d3;
            d11=s[0];
            d10=s[1];
            d9=s[2];
            d7=s[3];
            d6=s[4];
            d5=s[5];
            d3=s[6];
            char p1,p2,p4,p8;
            p1=' ';
            p2=' ';
            p4=' ';
            p8=' ';
            char [] te=new char[10];
            te[0]=d11;
            te[1]=d9;
            te[2]=d7;
            te[3]=d5;
            te[4]=d3;
            int i,c0=0,c1=0;
            for(i=0;i<5;i++)
            {
                if(te[i]=='0')
                    c0++;
                if(te[i]=='1')
                    c1++;
            }
            if(c0%2==0)
                p1='1';
            else if(c1%2==0)
                p1='0';
            //For P2
            te[0]=d11;
            te[1]=d10;
            te[2]=d7;
            te[3]=d6;
            te[4]=d3;
            c0=0;
            c1=0;
            for(i=0;i<5;i++)
            {
                if(te[i]=='0')
                    c0++;
                if(te[i]=='1')
                    c1++;
            }
            if(c0%2==0)
                p2='1';
            else if(c1%2==0)
                p2='0';
            
            //For P4
            
            te[0]=d7;
            te[1]=d6;
            te[2]=d5;
            c0=0;
            c1=0;
            for(i=0;i<3;i++)
            {
                if(te[i]=='0')
                    c0++;
                if(te[i]=='1')
                    c1++;
            }
            if(c0%2==0)
                p4='1';
            else if(c1%2==0)
                p4='0';
            
            te[0]=d11;
            te[1]=d10;
            te[2]=d9;
            c0=0;
            c1=0;
            for(i=0;i<3;i++)
            {
                if(te[i]=='0')
                    c0++;
                if(te[i]=='1')
                    c1++;
            }
            if(c0%2==0)
                p8='1';
            else if(c1%2==0)
                p8='0';
            
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p4);
            System.out.println(p8);
            String code=Character.toString(d11)+Character.toString(d10)+Character.toString(d9)+Character.toString(p8)+Character.toString(d7)+Character.toString(d6)+Character.toString(d5)+Character.toString(p4)
                    +Character.toString(d3)+Character.toString(p2)+Character.toString(p1);
            System.out.println("The Hamming code used for sending is : "+code);
            System.out.println("Enter the received code to check: ");
            str=buf.readLine();
            s=str.toCharArray();
           
            d11=s[0];
            d10=s[1];
            d9=s[2];
            p8=s[3];
            d7=s[4];
            d6=s[5];
            d5=s[6];
            p4=s[7];
            d3=s[8];
            p2=s[9];
            p1=s[10];
            
            te[0]=p1;
            te[1]=d11;
            te[2]=d9;
            te[3]=d7;
            te[4]=d5;
            te[5]=d3;
            c0=0;
            c1=0;
            for(i=0;i<6;i++)
            {
                if(te[i]=='0')
                    c0++;
                if(te[i]=='1')
                    c1++;
            }
            if(c0%2==0 && c1%2==0)
                p1='0';
            else
                p1='1';
            
            te[0]=p2;
            te[1]=d11;
            te[2]=d10;
            te[3]=d7;
            te[4]=d6;
            te[5]=d3;
            c0=0;
            c1=0;
            for(i=0;i<6;i++)
            {
                if(te[i]=='0')
                    c0++;
                if(te[i]=='1')
                    c1++;
            }
            if(c0%2==0 && c1%2==0)
                p2='0';
            else
                p2='1';
            
            te[0]=p4;
            te[1]=d7;
            te[2]=d6;
            te[3]=d5;
            c0=0;
            c1=0;
            for(i=0;i<4;i++)
            {
                if(te[i]=='0')
                    c0++;
                if(te[i]=='1')
                    c1++;
            }
            if(c0%2==0 && c1%2==0)
                p4='0';
            else
                p4='1';
            
            te[0]=p8;
            te[1]=d11;
            te[2]=d10;
            te[3]=d9;
            c0=0;
            c1=0;
            for(i=0;i<4;i++)
            {
                if(te[i]=='0')
                    c0++;
                if(te[i]=='1')
                    c1++;
            }
            if(c0%2==0 && c1%2==0)
                p8='0';
            else
                p8='1';
            
            int sum=0;
            if(p8=='1')
                sum+=8;
            if(p4=='1')
                sum+=4;
            if(p2=='1')
                sum+=2;
            if(p1=='1')
                sum+=1;
            if(p8=='0' && p4=='0' && p2=='0' && p1=='0')
                System.out.println("No error");
            else
                System.out.println("The error is at the D"+sum+"th bit and it should be complemented");
                
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

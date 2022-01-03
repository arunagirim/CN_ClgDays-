

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class crc 
{
    public static void main(String [] args)
    {
        try
        {
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the number of bits: ");
            int n=Integer.parseInt(buf.readLine());
            String str=buf.readLine();
            if(str.length()<=n)
            {
                char [] s=str.toCharArray();
                int i;
                System.out.print("The Input is: ");
                for(i=0;i<s.length;i++)
                {
                    System.out.print(s[i]);
                }
                System.out.println();
                System.out.print("Enter the number of bits of the divisor: ");
                int n1=Integer.parseInt(buf.readLine());
                String str1=buf.readLine();
                for(i=0;i<n1-1;i++)
                {
                    str+="0";
                }
                s=str.toCharArray();
                int n2=s.length;
                char [] s1=str1.toCharArray();
                int k;
                for(i=0;i<n2;i++)
                {
                    k=0;
                    int flag=0;
                    for(int l=0;l<n;l++)
                    {
                        if(s[l]=='0')
                        {
                            flag++;
                        }
                    }
                    if(flag==n)
                    {
                        break;
                    }
                    if(s[i]=='1')
                    {
                        for(int j=i;((j<(i+s1.length))&&(j<s.length));j++)
                        {
                            
                            if((s[j]=='0' && s1[k]=='0') || (s[j]=='1' && s1[k]=='1'))
                            {
                                s[j]='0';
                                k++;
                            }
                            else if((s[j]=='0' && s1[k]=='1') || (s[j]=='1' && s1[k]=='0'))
                            {
                                s[j]='1';
                                k++;
                            }
                        }
                    }
                }
                System.out.println("The coded word is ");
                for(i=0;i<s.length;i++)
                {
                    System.out.print(s[i]);
                }
                System.out.println();
                System.out.print("Enter the value to be checked: ");
                String str3=buf.readLine();
                n=str3.length();
                String str4="";
                for(i=n;i<s.length;i++)
                {
                    str4+=s[i];
                }
                System.out.println(str4);
                str3+=str4;
                s=str3.toCharArray();
                int n3=str3.length();
                int flag=0;
                for(i=0;i<n3;i++)
                {
                    k=0;
                    flag=0;
                    
                    for(int l=0;l<n3;l++)
                    {
                        if(s[l]=='0')
                        {
                            flag++;
                        }
                    }
                    
                    if(flag==n3)
                        break;
                    if(s[i]=='1')
                    {
                        for(int j=i;((j<(i+s1.length))&&(j<s.length));j++)
                        {
                            
                            if((s[j]=='0' && s1[k]=='0') || (s[j]=='1' && s1[k]=='1'))
                            {
                                s[j]='0';
                                k++;
                            }
                            else if((s[j]=='0' && s1[k]=='1') || (s[j]=='1' && s1[k]=='0'))
                            {
                                s[j]='1';
                                k++;
                            }
                        }
                    }
                }
                if(flag==n3)
                {
                    System.out.println("The input after checking: ");
                    for(i=0;i<n3;i++)
                    {
                        System.out.print(s[i]);
                    }
                    System.out.println();
                    System.out.println("No error");
                }
                else
                {
                    System.out.println("The input after checking: ");
                    for(i=0;i<n3;i++)
                    {
                        System.out.print(s[i]);
                    }
                    System.out.println();
                    System.out.println("error is there");
                }
            }
            else
            {
                System.out.println("Bits out of range");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ListIterator;
import java.io.*;

public class mymaze
{
	public mymaze(){}
	BufferedWriter bw = null;
	public void create() throws Exception
	{
		Scanner sn =new Scanner(System.in);	
		ArrayList<Integer> r=new ArrayList<Integer>();
		ListIterator<Integer> listIterator = r.listIterator();
		int a[][]= new int[200][100];
		ArrayList<Integer> out=new ArrayList<Integer>();
		BufferedReader fin=null;
		try
		{
		fin =new BufferedReader(new FileReader("CreateMaze.txt"));
		String s=fin.readLine();
		while(s!=null)
		{ 
		   String[]z=s.split(" ");
		   int len=z.length;
		   s=fin.readLine();
		   for(int i=0;i<len;i++)
			{ 
			   r.add(Integer.parseInt(z[i]));   
			}
		}
		
		}
	
		finally
		{
		if(fin!=null)
			fin.close();
		}
		int j=0;
		int m=r.get(0)-1;
			int count=0;
			int l=j;
		while(r.size() > j)
		{
			int n=r.get(j);
			if(count>4)
			{
				m=m+1;
				count=0;
				l=0;
			}
			
			a[m][l]=n;
			count++;
		//System.out.println(a[0][1]);
			
			l++;
			j++;
			
		}
		//System.out.println(a[11][3]);
		
		BufferedReader fin1=new BufferedReader(new FileReader("TraverseMaze.txt"));
		String s1=fin1.readLine();
		ArrayList<Integer> r1=new ArrayList<Integer>();
		while(s1!=null)
		{ 
		   String[]z1=s1.split(" ");
		   s1=fin1.readLine();
		   for(int i=0;i<z1.length;i++)
			{ 
			   r1.add(Integer.parseInt(z1[i]));   
			}
			r1.add(-1);
		}//System.out.println(r1.get(10));
		
			int dd=0;
		   int input=0;
		   
		   int size=r1.size();
		  //System.out.println(size);
		 while(input<size)
		 {
			 System.out.println(input);
			 System.out.println(size);
		  int d=r1.get(input)-1;
		  int row=d;
		  int newinput=input+1;
		   while(r1.get(newinput)>=0)
		   { 
			switch(r1.get(newinput))
			   {
			   case 0:{newinput++;
			
						if(a[row][1]==0)
				   		{
				   			System.out.println("u clashed with wall");
				   									  
				   		}
						else{
								for (int i=0;i<100;i++)
								{
									if(a[row][1]==a[i][0])
									{	
									row=i; 
									break;
									}
								}
							}
					   }System.out.println("u r in "+a[row][0]);
					break;
				   		 
				   	  
				 
			   case 1:{newinput++;
					   if(a[row][2]==0)
						{
							System.out.println("u clashed with wall");
							
						}
			   		 else{
							for (int i=0;i<100;i++)
							{
								if(a[row][2]==a[i][0])
								{	
								row=i; 
								break;
								}
							}
						}
					  }System.out.println("u r in "+a[row][0]);
						break;	   	      
						
				 
			   case 2:{newinput++;
					   if(a[row][3]==0)
						{
							System.out.println("u clashed with wall");
							
						}
			   		 else{
							for (int i=0;i<100;i++)
							{
								if(a[row][3]==a[i][0])
								{	
								row=i; 
								break;
								}
							}
						}//System.out.println(row);
					  }System.out.println("u r in "+a[row][0]);
					  break;
			   	      
				   
			   case 3:{newinput++;

					   if(a[row][4]==0)
						{
							System.out.println("u clashed with wall");
						}
			   		 else{
							for (int i=0;i<100;i++)
							{
								if(a[row][4]==a[i][0])
								{	row=i;
									break;
								}
							}
						 }					   
					   }System.out.println("u r in "+a[row][0]);	
					  break;
					  
			   }
				 
		  }
		  
		  //out[dd]=a[row][0];
		  out.add(a[row][0]);
		  newinput++;
		  input=newinput;
		  
		 }
		 for(int p=0;p<out.size();p++)
		 {
			 System.out.println("finally you are in "+out.get(p));
		 }
		
		FileWriter fw = new FileWriter("Destinations.txt");
		bw = new BufferedWriter(fw);
		for(int c=0;c<out.size();c++)
		{			
			bw.write(out.get(c) + "");
			//bw.flush();
			bw.newLine();
		}
		if (bw!=null)
		bw.close();
		
        System.out.println("File written Successfully \n");

		System.out.println("Please go and check the Destination.txt file for output,Thank you");
		
		
	}

}
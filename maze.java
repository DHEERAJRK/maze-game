import java.io.*;
import java.util.Arrays;
import java.util.*;
class maze
{
private int room[][];
BufferedWriter bw = null;
public void createmaze() throws Exception
	{
		Scanner sn =new Scanner(System.in);	
		ArrayList<Integer> creation=new ArrayList<Integer>();
		BufferedReader read=new BufferedReader(new FileReader("CreateMaze.txt"));
		String s1=read.readLine();
		while(s1!=null)
		{ 
		   String[]z=s1.split(" ");
		   s1=read.readLine();
		   for(int i=0;i<z.length;i++)
			{ 
			   creation.add(Integer.parseInt(z[i]));   
			}
		}
			room=new int[((creation.size()/5))+1][4];
			int row=0,col=0;
			for(int newt=0;newt<creation.size();newt++)
			{
			if(newt%5==0)
			{
			row++;
			col=0;
			}
			else
			{
			int w=creation.get(newt);
			room[row][col++]=w;
			}	
			}
	}
	
	
	private int go[];
	public void mazetraversal()
	{
		Scanner sn =new Scanner(System.in);	
		ArrayList<Integer> traverse=new ArrayList<Integer>();
		BufferedReader read1=null;
		try
		{
		read1 =new BufferedReader(new FileReader("TraverseMaze.txt"));
		String s2=read1.readLine();
		int length=0;
		while(s2!=null)
		{ 
		   String[]z1=s2.split(" ");
		   s2=read1.readLine();
		   for(int i=0;i<z1.length;i++)
			{ 
			   traverse.add(Integer.parseInt(z1[i]));   
			}
			
		     traverse.add(-10);
			 length++;			 
		}
		
	int mi=0;
	go=new int[length];
	int start=traverse.get(0);
				for(int j=1;j<traverse.size();j++)
				{
					
				if(traverse.get(j)>=0)
			   {int y=room[start][traverse.get(j)];
				if(y>0)
				{
				start=y;
		     	}
			   }	
				else if(traverse.get(j)==-10)
     			{
				go[mi++]=start;
				if(mi!=length)
				{
				start=traverse.get(++j);
				}
				else
				{
				j++;
				}
				}	
				}
		writes();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	}
	
	public void writes() throws Exception 
	{
		
		FileWriter fw = new FileWriter("Destinations.txt");
		bw = new BufferedWriter(fw);
		for(int i=0;i<go.length;i++)
		{			
			bw.write(go[i] + "");
			//bw.flush();
			bw.newLine();
		}
		if (bw!=null)
		bw.close();
		
        System.out.println("File written Successfully \n");

		System.out.println("Please go and check the Destination.txt file for output,Thank you");
		
	
		
		
	}
}
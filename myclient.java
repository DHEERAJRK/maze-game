public class myclient
{
	
	public static void main(String []args)
	{
		mymaze m=new mymaze();
		
     try{	
	m.create();
	 }
	 catch (Exception e)
	 {System.out.println("error "+e);}
	 
	 }
}
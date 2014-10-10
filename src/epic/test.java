package fist;

public class test {

	public static void main(String[] args) {
		
		for (int i=1;i<7;i++)
		{
			System.out.println(writeSentence());
		}
	}
		public static String writeSentence()
		{
			int v1 =(int)( Math.random()*3)+1;
			String v2 = "";
			if  (v1==1)
			{
			v2 = "Anton" ; 
			
			}
			if  (v1==2)
			{
				v2 = "Kristina";	
			}
			if  (v1==3)
			{
				v2 = "Kirill";	
			}
	
			String v3 = "";
			 if (v2== "Kristina") 
			 {
				 v3 = "daughter";
			 }
			 else
			 {
				 v3 = "son";
			 }
			 String v4 = "";
			 int v6 =(int)( Math.random()*2)+1;
			 if (v6== 1) 
			 {
				 v4 = "immortal";
			 }
			 else
			 {
				 v4 = "mortal";
			 }
			 
			 
			 v1 =(int)( Math.random()*3)+1;
				String v7 = "";
				if  (v1==1)
				{
				v7 = "Anton" ; 
				
				}
				if  (v1==2)
				{
					v7 = "Kristina";	
				}
				if  (v1==3)
				{
					v7 = "Kirill";	
				}
			 
			 
			 
			return ("I am "+v2+", "+v4+" "+v3+" "+ v7 +".");
			 
			 
			}

}
package mf.im;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import mf.Data;

public class IdentityMap {
	
	private Map<String,Data> map=new HashMap<String, Data>();
	
	
	public Data getData(String id){
		if(map.containsKey(id)){
			System.out.print("RETURN   ");
			
		}else{
			System.out.print("LOAD...  ");
			map.put(id,loadData(id));
		}
		return map.get(id);
	}


	private Data loadData(String id) {
		 //reading   
	    try{
	        InputStream ips=getClass().getResourceAsStream("/mf/data");
	        InputStreamReader ipsr=new InputStreamReader(ips);
	        BufferedReader br=new BufferedReader(ipsr);
	        String line;
	        String[]array;
	       
	        while ((line=br.readLine())!=null){
	        	array = line.split(";");
	        	if(id.equals(array[0])){
	        		 return new Data(id, array[1]);	
	        	}
	        	
	        }
	        br.close(); 

	    }       
	    catch (Exception e){
	        System.out.println(e.toString());
	    } 
	     return new Data(id,null);
		
	}



	
}

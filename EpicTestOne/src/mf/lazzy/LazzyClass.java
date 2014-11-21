package mf.lazzy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LazzyClass {
	
	private List<String> list;
	
	/**
	 * the getter of the property list load the data from the file "data" only if needed
	 * @return
	 */
	public List<String> getList(){
		
		if(list == null){
			list=loadData();
		}
		return list;
		
	}

	/**
	 * Open a resource and put the content in the list
	 * @return
	 */
	private List<String> loadData() {
		
		list = new ArrayList<String>();    

	    //reading   
	    try{
	        InputStream ips=getClass().getResourceAsStream("/mf/data");
	        InputStreamReader ipsr=new InputStreamReader(ips);
	        BufferedReader br=new BufferedReader(ipsr);
	        String line;
	        while ((line=br.readLine())!=null){
	        	list.add(line);
	        }
	        br.close(); 

	    }       
	    catch (Exception e){
	        System.out.println(e.toString());
	    } 
		return list;
	}

}

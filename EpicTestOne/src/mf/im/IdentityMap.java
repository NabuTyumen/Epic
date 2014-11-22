package mf.im;

import java.util.HashMap;
import java.util.Map;

import mf.Data;
import mf.uow.UnitOfWork;

public class IdentityMap {
	
	public IdentityMap(String fileName) {
		super();
		this.uow= new UnitOfWork(fileName);
		this.map=new HashMap<String, Data>();
	}


	private Map<String,Data> map;
	private UnitOfWork uow;
	
	public Data getData(String fileName,String id){
		if(map.containsKey(id)){
			System.out.print("RETURN   ");
			
		}else{
			System.out.print("LOAD...  ");
			map.put(id,loadData(fileName,id));
		}
		return map.get(id);
	}


	private Data loadData(String fileName, String id) {
		 return uow.get(id);
	}



	
}

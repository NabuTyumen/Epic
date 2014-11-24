package mf.im;

import java.util.HashMap;
import java.util.Map;

import mf.Data;
import mf.uow.UnitOfWork;
import mf.uow.UnitOfWorkInterface;

public class IdentityMap {
	
	public IdentityMap(UnitOfWorkInterface uow) {
		super();
		this.uow= uow;
		this.map=new HashMap<String, Data>();
	}


	private Map<String,Data> map;
	private UnitOfWorkInterface uow;
	
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
		 return uow.get(id);
	}



	
}

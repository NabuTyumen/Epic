package sema.model;

import java.util.Map;


public class SemaMap {
	private Map<SId,IEntry> map;
	private IUnitOfWork uow;
	
	public IEntry getEntry(SId id){
		if(!map.containsKey(id)){
			System.out.print("LOAD...  " + id.toString());
			map.put(id,loadData(id));
		}
		return map.get(id);
	}


	private IEntry loadData(SId id) {
		 return uow.get(id);
	}

}

package mf.im;

import mf.uow.UnitOfWork;
import mf.uow.UnitOfWorkInterface;

public class IdentityMapMain {

	public static void main(String[] args) {
		//Constructor of a Unit of Work to manage the CRUD operations with the data file
		UnitOfWorkInterface uow= new UnitOfWork("C:\\Users\\Bruno\\Documents\\_\\data");
		
		//Example of IdentityMap (with Dependency Injection)
		IdentityMap im = new IdentityMap(uow);
		
		//id of the records
		String[] ids = {"1", "B", "4", "B", "C", "B", "F", "C", "Z", "10", "10", "Я"};
		
		for(String id:ids){
			System.out.println(im.getData(id).display());
			System.out.println();
		}

	}

}

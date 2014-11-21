package mf.uow;

import mf.Data;

public class UnitOfWorkMain {

	public static void main(String[] args) {

		UnitOfWork uow = new UnitOfWork();
		uow.insertData( new Data("5","charly"));
		uow.insertData( new Data("6","echo"));
		uow.updateData(new Data("1","alpha1"));
		uow.commit();

	}

}

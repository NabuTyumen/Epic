package mf.uow;

import mf.Data;

public class UnitOfWorkMain {

	public static void main(String[] args) {
		
		String fileName = "C:\\Users\\Bruno\\Documents\\_\\data";
		
		UnitOfWork uow = new UnitOfWork(fileName);
		
		uow.update( new Data("5","charly"));
		uow.update( new Data("6","echo"));
		uow.update(new Data("Ê","être"));
		uow.update(new Data("E","echo"));
		uow.update(new Data("Б","брат"));
		uow.update(new Data("Р","ребёнок"));
		uow.update(new Data("К","кузен"));
		uow.update(new Data("Д","дочь"));
		uow.update(new Data("О","отец, папа, батя"));
		uow.update(new Data("В","внучата"));
		uow.update(new Data("В","внучка"));
		uow.update(new Data("Д","дед, дедушка"));
		uow.update(new Data("Б","бабушка"));
		uow.update(new Data("Б","бабушка и дедушка"));
		uow.update(new Data("В","внук"));
		uow.update(new Data("М","муж"));
		uow.update(new Data("М","мать"));
		uow.update(new Data("П","племянник"));
		uow.update(new Data("П","племянница"));
		uow.update(new Data("Р","родитель"));
		uow.update(new Data("Р","родители"));
		uow.update(new Data("С","сын"));
		uow.delete("С");
		uow.update(new Data("С","сестра"));
		uow.update(new Data("Д","дядя"));
		uow.update(new Data("Ж","жена"));
		uow.display();
		uow.commit();

	}

}

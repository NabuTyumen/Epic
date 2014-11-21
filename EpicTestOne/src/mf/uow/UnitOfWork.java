package mf.uow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mf.Data;

public class UnitOfWork implements UnitOfWorkInterface {
	
	private final int INSERT=1;
	private final int UPDATE=2;
	private final int DELETE=3;
	private List<Operation> os = new ArrayList<Operation>();
	private List<Data> ds = new ArrayList<Data>();
	final String fileName = "C:\\Users\\Bruno\\data";

	@Override
	public void insertData(Data data) {
		os.add(new Operation(INSERT, data) );

	}

	@Override
	public void updateData(Data data) {
		os.add(new Operation(UPDATE, data) );

	}

	@Override
	public void deleteData(Data data) {
		os.add(new Operation(DELETE, data) );

	}

	@Override
	public void commit() {
		loadData();
		for(Operation o:os){
			process(o);
		}
		eraseFile();
		printFile();
		clear();
	
	}

	private void printFile() {
		   
		try{
		      PrintWriter out  = new PrintWriter(new FileWriter(fileName));
		      for (Data d:ds)
		        out.println(d.print());
		      out.close();
		    }
		    catch(Exception e){
		      e.printStackTrace();
		    }
		
	}

	private void eraseFile() {
		try {
			new FileOutputStream("fileName").close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void loadData() {
		FileReader fr = null;
		 try {
			fr = new FileReader(fileName);
		} catch (FileNotFoundException e1) {
			File nomFichier = new File("Abonnés.txt");
			try {
				nomFichier.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		 
		    try{
		   
		    	fr = new FileReader(fileName);
		      BufferedReader in  = new BufferedReader(new FileReader(fileName));
		      String line;
		      String[]array;
		        while ((line = in.readLine()) != null) {
		        array=line.split(";");
		        ds.add(new Data(array[0],array[1]));

		        }
		      in.close();
		    }
		    catch(Exception e){
		      e.printStackTrace();
		    }
		
	}

	private Data process(Operation o) {
		switch(o.getOperation()){
		case 1:return insert(o.getData());
		case 2:return update(o.getData());
		case 3:return delete(o.getData());
		default: return null;
		}
		
	}

	private Data delete(Data value) {
		ds.remove(value);
		return null;
	}

	private Data update(Data value) {
		ds.remove(value);
		ds.add(value);
		return null;
	}

	private Data insert(Data value) {
		ds.add(value);
		return null;
	}

	@Override
	public void clear() {
		os.clear();
		ds.clear();

	}

}

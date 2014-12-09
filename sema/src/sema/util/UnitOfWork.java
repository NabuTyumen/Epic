package sema.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import sema.model.IEntry;
import sema.mongodb.MEntry;
import mf.Data;
import mf.uow.DataPrintable;
import mf.uow.Operation;
import mf.uow.UnitOfWorkInterface;

public class UnitOfWork  {
	
	//UUID uuid = UUID.randomUUID();

	//implementation of a object Collator to sort the map (according to the Locale rules)
	private static final Collator collator = setCollator();


	public UnitOfWork(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	//Construct a Collator taking as parameter a Locale build by invocation of the Factory method Locale.forLanguageTag
	private static Collator setCollator() {
		Collator collator= Collator.getInstance( Locale.forLanguageTag("ru-RU"));
		collator.setStrength(Collator.SECONDARY);
		return collator;
	}

	private String fileName;

	private static final int LIST=2;

	
	//list of operation
	private List<Operation> os = new ArrayList<Operation>();
	
	//map of the data
	Map<String, IEntry> t = new TreeMap<String, IEntry>(collator);




	

	public void clear() {
		os.clear();
		t.clear();

	}


	public void display() {
		os.add(new Operation(LIST,null));
		
	}

	public List<IEntry> get() {
		if(!os.isEmpty()){
			commit();
		}
		if(loadData(null)==null) return null;
		List<IEntry> list = new ArrayList<IEntry>();
		for(Entry<String,IEntry>e:t.entrySet()){
			list.add(e.getValue());
		}
		return list;
		
	}

	public boolean commit() {
		if(loadData(null)==null) return false;
		for(Operation o:os){
			process(o);
		}
		eraseFile();
		printFile(t);
		clear();
		return true;

	}

	public void printFile(Map<String,IEntry>map) {
		try{
			
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));

			for (Entry<String,IEntry>e:map.entrySet()){
				out.write(e.getValue().print());
				out.write(System.getProperty("line.separator"));
			}	
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	private void eraseFile() {
		try {
			new FileOutputStream(fileName).close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private IEntry loadData(String id) {
		t.clear();
		File file = new File(fileName);
		if(!file.exists() || file.isDirectory()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		try{
			//BufferedReader in  = new BufferedReader(new FileReader(file));
			 BufferedReader in = new BufferedReader( new InputStreamReader( new FileInputStream(file), "UTF8"));
			String line;
			IEntry d;
			while ((line = in.readLine()) != null) {
				d=new MEntry(line);
				if(id==null){
					t.put(d.getLabel().getString(),d);	
				} else if(id.equals(d.getIdString())){
					in.close();
					return d;
				}
				
			}
			in.close();
			return new MEntry(id);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	

	private boolean process(Operation o) {
		switch(o.getOperation()){
		case 2:return _display();

		default: return false;
		}

	}


	private boolean _display() {
		for(Entry<String,IEntry>e:t.entrySet()){
			System.out.println(e.getValue().display());
		}
		return true;
	}

	


	public IEntry get(String id) {
		return loadData(id);
	}


	

}

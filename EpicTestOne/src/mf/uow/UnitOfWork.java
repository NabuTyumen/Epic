package mf.uow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;

import mf.Data;

public class UnitOfWork implements UnitOfWorkInterface {
	
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
	private static final int UPDATE=3;
	private static final int DELETE=4;
	
	//list of operation
	private List<Operation> os = new ArrayList<Operation>();
	
	//map of the data
	TreeMap<String,Data> t = new TreeMap<String, Data>(collator);



	@Override
	public void update(Data data) {
		os.add(new Operation(UPDATE, data) );

	}

	@Override
	public void delete(String id) {
		os.add(new Operation(DELETE, new Data(id,"")) );

	}
	@Override
	public void clear() {
		os.clear();
		t.clear();

	}

	@Override
	public void display() {
		os.add(new Operation(LIST,null));
		
	}

	@Override
	public List<Data> get() {
		if(!os.isEmpty()){
			commit();
		}
		if(loadData(null)==null) return null;
		List<Data> list = new ArrayList<Data>();
		for(Entry<String,Data>e:t.entrySet()){
			list.add(e.getValue());
		}
		return list;
		
	}
	@Override
	public boolean commit() {
		if(loadData(null)==null) return false;
		for(Operation o:os){
			process(o);
		}
		eraseFile();
		printFile();
		clear();
		return true;

	}

	private void printFile() {
		try{
			
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));

			for (Entry<String,Data>e:t.entrySet()){
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
	
	
	private Data loadData(String id) {
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
			BufferedReader in  = new BufferedReader(new FileReader(file));
			String line;
			Data d;
			while ((line = in.readLine()) != null) {
				d=new Data(line);
				if(id==null){
					t.put(d.getId(),d);	
				} else if(id.equals(d.getId())){
					in.close();
					return d;
				}
				
			}
			in.close();
			return new Data(id,null);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	

	private boolean process(Operation o) {
		switch(o.getOperation()){
		case 2:return _display();
		case 3:return _update(o.getData());
		case 4:return _delete(o.getData().getId());
		default: return false;
		}

	}


	private boolean _display() {
		for(Entry<String,Data>e:t.entrySet()){
			System.out.println(e.getValue().display());
		}
		return true;
	}

	private boolean _delete(String id) {
		t.remove(id);
		return true;
	}

	private boolean _update(Data data) {
		t.remove(data.getId());
		t.put(data.getId(),data);
		return true;
	}

	@Override
	public Data get(String id) {
		return loadData(id);
	}


	

}

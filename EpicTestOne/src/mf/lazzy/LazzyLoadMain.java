package mf.lazzy;

import mf.Data;

public class LazzyLoadMain {

	public static void main(String[] args) {
		
		String fileName = "C:\\Users\\Bruno\\Documents\\_\\data";
		
		LazzyClass lazzy=new LazzyClass();
		
		for(Data d:lazzy.getList(fileName)){
			System.out.println(d.display());
		}

	}

}

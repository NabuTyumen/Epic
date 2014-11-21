package mf.lazzy;

public class LazzyLoadMain {

	public static void main(String[] args) {
		LazzyClass lazzy=new LazzyClass();
		
		for(String s:lazzy.getList()){
			System.out.println(s);
		}

	}

}

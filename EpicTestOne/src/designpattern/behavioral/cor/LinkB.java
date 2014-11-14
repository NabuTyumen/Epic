package designpattern.behavioral.cor;

public class LinkB extends Link {

	@Override
	public boolean operationSpec(int pNumber) {
		 if(pNumber < 2) {
	            System.out.println("MaillonB : " + pNumber + " : < 2");
	            return true;
	        }
	        return false;
	}

}

package designpattern.behavioral.cor;

public class LinkA extends Link {

	@Override
	public boolean operationSpec(int pNumber) {
		 if(pNumber % 2 == 0) {
	            System.out.println("MaillonA : " + pNumber + " : pair");
	            return true;
	        }
	        return false;
	}

}

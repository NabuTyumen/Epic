package gof.behavioral.cor;

public class LinkB extends Link {

	@Override
	public boolean operationSpec(int pNumber) {
		 if(pNumber < 2) {
	            System.out.println("LinkB : " + pNumber + " : < 2");
	            return true;
	        }
	        return false;
	}

}

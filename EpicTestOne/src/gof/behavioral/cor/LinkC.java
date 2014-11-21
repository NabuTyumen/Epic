package gof.behavioral.cor;

public class LinkC extends Link {

	@Override
	public boolean operationSpec(int pNombre) {
		  if(pNombre > 2) {
	            System.out.println("LinkC : " + pNombre + " : > 2");
	            return true;
	        }
	        return false;
	}

}

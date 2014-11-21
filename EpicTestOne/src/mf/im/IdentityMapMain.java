package mf.im;

public class IdentityMapMain {

	public static void main(String[] args) {
		IdentityMap im = new IdentityMap();
		String[] ids = {"1", "B", "4", "B", "C", "B", "F", "C", "Z", "10", "10", "1"};
		
		for(String id:ids){
			System.out.println(im.getData(id).display());
			System.out.println();
		}

	}

}

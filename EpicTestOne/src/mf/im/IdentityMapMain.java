package mf.im;

public class IdentityMapMain {

	public static void main(String[] args) {
		
		String fileName = "C:\\Users\\Bruno\\Documents\\_\\data";
		
		IdentityMap im = new IdentityMap(fileName);
		String[] ids = {"1", "B", "4", "B", "C", "B", "F", "C", "Z", "10", "10", "Я"};
		
		for(String id:ids){
			System.out.println(im.getData(fileName,id).display());
			System.out.println();
		}

	}

}

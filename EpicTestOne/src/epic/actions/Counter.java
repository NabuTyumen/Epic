package epic.actions;

/**
 * @author Bruno
 * 
 * Static class 
 * 
 * It is static because ALL of the properties 
 * and method of the class are static, here just one property. 
 * Other way there is no mean of making a top-level class static.
 * 
 * We need a unique instance 
 * to store a number, 
 * a simple incremental counter
 * which could 
 * be used by all the instanced
 * objects of the running project 
 */

public class Counter {


	public static int counter=0;

}

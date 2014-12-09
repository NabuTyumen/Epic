package sema.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TextUtil {
	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {
		if(max<=min) max = min+1;
	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static List<Integer> randListInt(int min, int max, int n){
		List<Integer> is = new ArrayList<Integer>();
		Integer i;
		while(is.size()<n){
			i = new Integer(randInt(min,max));
			if(!is.contains(i))
			is.add(i);
		}
		return is;
	}
}

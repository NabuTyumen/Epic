package epic.characters;

import epic.actions.Pray;

/**
 * @author Bruno
 * 
 * If a Person (or anything else) 
 * have to pray
 * it should implement the method of this INTERFACE
 * 
 */

public interface Worshiper {
	
	public Pray pray(God to);

}

package epic.characters;

import epic.actions.Speak;

/**
 * @author Bruno
 * 
 * If a Person (or anything else) 
 * have to introduce himself
 * it should implement the method of this INTERFACE
 *
 */

public interface Speaker {

	public Speak introduce(Person to) ;
}

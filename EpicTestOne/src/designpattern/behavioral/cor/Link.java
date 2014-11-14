package designpattern.behavioral.cor;

public abstract class Link {

private Link next;
    
    
    /**
     *	Determine the next link in the chain
     * @param next
     */
    public void setNext(Link n) {
        next = n;
    }
    
    /**
     * Call process on the current link
     * Then ask to the next link to do the same 
     * if the current link do not manage the operation
     * @param pNumber
     * @return if operation successfull.
     */
    public boolean operation(int pNumber) {
        if(operationSpec(pNumber)) {
        	return true;
        };
        
        if(next != null) {
            return next.operation(pNumber);
        }
        return false;
        
      
}
    public abstract boolean operationSpec(int pNombre);
}

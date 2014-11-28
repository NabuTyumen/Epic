package gof.behavioral.memento;

/**
 * Object we want to save state.
 */
public class Creator {

    // State to be stored
    private int state = 2;

    /**
     * Store the saved states of a object
     * Its method are private so that only the "Creator"
     * could access to the stored informations
     */
    public class Memento {

        // State stored
        private int state;
        
        private Memento(int pEtat) {
            state = pEtat;
        }
        
        /**
         * Return the saved state
         * @return
         */
        private int getState() {
            return state;
        }
    }

    /**
     * Change the state of the object
     */
    public void next() {
        state = state * state;
    }
    
    /**
     * Store its state in a "Memento"
     * @return
     */
    public Memento saveInMemento() {
        return new Memento(state);
    }
    
    /**
     * Return its state from a "Memento"
     * @param pMemento
     */
    public void restoreFromMemento(Memento pMemento) {
        state = pMemento.getState();
    }
    
    /**
     * Display object state 
     */
    public void display() {
        System.out.println("The state is : " + state);
    }
}

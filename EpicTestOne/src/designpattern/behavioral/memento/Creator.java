package designpattern.behavioral.memento;

/**
 * Objet dont on souhaite conserver l'état.
 */
public class Creator {

    // Etat à sauvegarder
    private int state = 2;

    /**
     * Store the saved states of a object
     * Its method are private so that only the "Creator"
     * could access to the stored informations
     */
    public class Memento {

        // Etat sauvegardé
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
     * Sauvegarde son état dans un "Memento"
     * @return
     */
    public Memento saveInMemento() {
        return new Memento(state);
    }
    
    /**
     * Restitue son état depuis un "Memento"
     * @param pMemento
     */
    public void restoreFromMemento(Memento pMemento) {
        state = pMemento.getState();
    }
    
    /**
     * Affiche l'état de l'objet
     */
    public void display() {
        System.out.println("The state is : " + state);
    }
}

package designpattern.behavioral.memento;

/**
 * Objet dont on souhaite conserver l'�tat.
 */
public class Creator {

    // Etat � sauvegarder
    private int state = 2;

    /**
     * Store the saved states of a object
     * Its method are private so that only the "Creator"
     * could access to the stored informations
     */
    public class Memento {

        // Etat sauvegard�
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
     * Sauvegarde son �tat dans un "Memento"
     * @return
     */
    public Memento saveInMemento() {
        return new Memento(state);
    }
    
    /**
     * Restitue son �tat depuis un "Memento"
     * @param pMemento
     */
    public void restoreFromMemento(Memento pMemento) {
        state = pMemento.getState();
    }
    
    /**
     * Affiche l'�tat de l'objet
     */
    public void display() {
        System.out.println("The state is : " + state);
    }
}

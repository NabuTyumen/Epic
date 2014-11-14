package designpattern.creational.singleton;

public class Singleton {

    /**
     * La pr�sence d'un constructeur priv� supprime 
     * le constructeur public par d�faut.
     */
    private Singleton() {
    }

    /**
     * SingletonHolder est charg� � la premi�re ex�cution de
     * Singleton.getInstance() ou au premier acc�s � SingletonHolder.instance ,
     * pas avant.
     */
    private static class SingletonHolder {
        private final static Singleton instance = new Singleton();
    }

    /**
     * M�thode permettant d'obtenir l'instance unique.
     * @return L'instance du singleton.
     */
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
package designpattern.creational.singleton;

public class Singleton {

    /**
     * La présence d'un constructeur privé supprime 
     * le constructeur public par défaut.
     */
    private Singleton() {
    }

    /**
     * SingletonHolder est chargé à la première exécution de
     * Singleton.getInstance() ou au premier accès à SingletonHolder.instance ,
     * pas avant.
     */
    private static class SingletonHolder {
        private final static Singleton instance = new Singleton();
    }

    /**
     * Méthode permettant d'obtenir l'instance unique.
     * @return L'instance du singleton.
     */
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
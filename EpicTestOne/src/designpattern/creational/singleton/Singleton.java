package designpattern.creational.singleton;

public class Singleton {

    /**
     * The presence of a private Constructor 
     * removes the public Constructor by default.
     */
    private Singleton() {
    }

    /**
     * SingletonHolder is loaded at the first execution of
     * Singleton.getInstance() or at the first access to SingletonHolder.instance,
     * and not before.
     */
    private static class SingletonHolder {
        private final static Singleton instance = new Singleton();
    }

    /**
     * Method to get the unique instance.
     * @return instance of singleton.
     */
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
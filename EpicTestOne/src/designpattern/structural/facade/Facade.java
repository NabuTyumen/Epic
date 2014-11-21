package designpattern.structural.facade;

/**
 * Presents some features.
 * In this case, present only the method "operation2()" of "ClassA"
 * and a method "operation41()" combining  "operation4()" of "ClassB" 
 * and "operation1()" of "ClassA".
 */
public class Facade {

    private ClassA classeA = new ClassA();
    private ClassB classeB = new ClassB(); 

    /**
     * The method operation2() simply call
     * the same method in ClasseA
     */
    public void operation2() {
        System.out.println("--> Method operation2() of the class Facade : ");
        classeA.operation2();
    }
    
    /**
     * The method operation41() call
     * operation4() in ClassB
     * and operation1() in ClassA
     */
    public void operation41() {
        System.out.println("--> Method operation41() de la classeof the class Facade : ");
        classeB.operation4();
        classeA.operation1();
    }
}
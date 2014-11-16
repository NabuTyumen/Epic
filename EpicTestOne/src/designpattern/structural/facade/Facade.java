package designpattern.structural.facade;

/**
 * Pr�sente certaines fonctionnalit�s.
 * Dans ce cas, ne pr�sente que la m�thode "operation2()" de "ClasseA"
 * et la m�thode "operation41()" utilisant "operation4()" de "ClasseB" 
 * et "operation1()" de "ClasseA".
 */
public class Facade {

    private ClasseA classeA = new ClasseA();
    private ClasseB classeB = new ClasseB(); 

    /**
     * La m�thode operation2() appelle simplement 
     * la m�me m�thode de ClasseA
     */
    public void operation2() {
        System.out.println("--> M�thode operation2() de la classe Facade : ");
        classeA.operation2();
    }
    
    /**
     * La m�thode operation41() appelle  
     * operation4() de ClasseB 
     * et operation1() de ClasseA
     */
    public void operation41() {
        System.out.println("--> M�thode operation41() de la classe Facade : ");
        classeB.operation4();
        classeA.operation1();
    }
}
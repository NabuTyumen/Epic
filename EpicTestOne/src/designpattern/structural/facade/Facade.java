package designpattern.structural.facade;

/**
 * Présente certaines fonctionnalités.
 * Dans ce cas, ne présente que la méthode "operation2()" de "ClasseA"
 * et la méthode "operation41()" utilisant "operation4()" de "ClasseB" 
 * et "operation1()" de "ClasseA".
 */
public class Facade {

    private ClasseA classeA = new ClasseA();
    private ClasseB classeB = new ClasseB(); 

    /**
     * La méthode operation2() appelle simplement 
     * la même méthode de ClasseA
     */
    public void operation2() {
        System.out.println("--> Méthode operation2() de la classe Facade : ");
        classeA.operation2();
    }
    
    /**
     * La méthode operation41() appelle  
     * operation4() de ClasseB 
     * et operation1() de ClasseA
     */
    public void operation41() {
        System.out.println("--> Méthode operation41() de la classe Facade : ");
        classeB.operation4();
        classeA.operation1();
    }
}
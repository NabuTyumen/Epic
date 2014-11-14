package designpattern.creational.builder;
public class BuilderPatternMain {

    public static void main(String[] args) {
        // Instanciate the objects manager and builder
        Builder lBuilderA = new ConcreteBuilderA();
        Manager lManagerA = new Manager(lBuilderA);
        Builder lBuilderB = new ConcreteBuilderB();
        Manager lManagerB = new Manager(lBuilderB);
        
        // Appel des différentes méthodes de création
        ComplexObject lProduitA = lManagerA.createObject();
        ComplexObject lProduitB = lManagerB.createObject();
        
        // Demande l'affichage des valeurs des objets
        // pour visualiser les différences de composition
        lProduitA.display();
        lProduitB.display();
        
        // Affichage : 
        // Objet Complexe : 
        //         - attribut1 : libelle de l'objet (avec dimension en centimètre)
        //         - attribut2 : 12.0
        //         - classe de l'attribut2 : class java.lang.Float
        // Objet Complexe : 
        //         - attribut1 : libelle de l'objet (avec dimension en pouces)
        //         - attribut2 : 30.48
        //         - classe de l'attribut2 : class java.lang.Double
    }
}

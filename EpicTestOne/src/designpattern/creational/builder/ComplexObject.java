package designpattern.creational.builder;

/**
 * L'objet complexe
 * Dans l'exemple, on pourrait consid�rer 
 * l'attribut1 comme un libell�
 * et l'attribut2 comme une dimension
 * La classe de l'attribut2 peut varier selon le "Monteur"
 */
public class ComplexObject {

    // Les attributs de l'objet complexe
    private String attribut1;
    private Number attribut2;
    
    // Les m�thodes permettant de fixes les attributs
    public void setAttribut1(String pAttribut1) {
        attribut1 = pAttribut1;
    }
    
    public void setAttribut2(Number pAttribut2) {
    	attribut2 = pAttribut2;
    }
    
    /**
     * M�thode permettant d'display l'�tat de l'objet
     * afin de permettre de mettre en �vidence
     * les diff�rences de "montage". 
     */
    public void display() {
        System.out.println("Objet Complexe : ");
        System.out.println("\t- attribut1 : " + attribut1);
        System.out.println("\t- attribut2 : " + attribut2);
        System.out.println("\t- classe de l'attribut2 : " + attribut2.getClass());
    }
}

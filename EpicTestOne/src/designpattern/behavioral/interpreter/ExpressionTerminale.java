package designpattern.behavioral.interpreter;

/**
 * Implement terminal expression.
 */
public class ExpressionTerminale extends Expression {

    private String texte;

    /**
     * Constructor allowing the setting of the text elements
     * @param pTexte
     */
    public ExpressionTerminale(String pTexte) {
        texte = pTexte;
    }
    
    /**
     * Display text attribute with indentation
     */
    public void operation(int pIndentation) {
        displayIndentation(pIndentation);
        System.out.println(texte);
    }
}

package designpattern.behavioral.interpreter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implement a non terminale expression.
 */
public class ExpressionNoTerminale extends Expression {

    private String label;
    private List<Expression> list = new LinkedList<Expression>();
    
    /**
     * Constructor to set a attribute label
     * @param pTexte
     */
    public ExpressionNoTerminale(String plabel) {
        label = plabel;
    }
    
    /**
     * Permet d'add des expressions a l'expression non terminale
     * @param pExpression
     */
    public void addExpression(Expression pExpression) {
        list.add(pExpression);
    }
    
    /**
     * Display attribute label as tag open and closed
     * and the expression in the list
     * of the non terminale expression 
     */
    public void operation(int pIndentation) {
        displayIndentation(pIndentation);
        System.out.println("<" + label + ">");
        Iterator<Expression> lIterator = list.iterator();
        while(lIterator.hasNext()) {
            Expression lExpression = lIterator.next();
            lExpression.operation(pIndentation + 1);
        }
        displayIndentation(pIndentation);
        System.out.println("</" + label + ">");
    }
}

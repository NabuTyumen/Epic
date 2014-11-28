package gof.behavioral.interpreter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implement a non terminal expression.
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
     * Add expressions to non terminal expression 
     * @param pExpression
     */
    public void addExpression(Expression pExpression) {
        list.add(pExpression);
    }
    
    /**
     * Display attribute label as tag open and closed
     * and the expression in the list
     * of the non terminal expression 
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

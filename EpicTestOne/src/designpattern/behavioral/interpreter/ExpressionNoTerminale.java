package designpattern.behavioral.interpreter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implémente une expression non terminale.
 */
public class ExpressionNoTerminale extends Expression {

    private String libelle;
    private List<Expression> liste = new LinkedList<Expression>();
    
    /**
     * Constructeur permettant de fixer un attribut libelle
     * @param pTexte
     */
    public ExpressionNoTerminale(String pLibelle) {
        libelle = pLibelle;
    }
    
    /**
     * Permet d'ajouter des expressions a l'expression non terminale
     * @param pExpression
     */
    public void ajouterExpression(Expression pExpression) {
        liste.add(pExpression);
    }
    
    /**
     * Affiche l'attribut libelle sous forme de tag ouvrant et fermant
     * ainsi que les expressions contenues dans la liste
     * de l'expression non terminale
     */
    public void operation(int pIndentation) {
        displayIndentation(pIndentation);
        System.out.println("<" + libelle + ">");
        Iterator<Expression> lIterator = liste.iterator();
        while(lIterator.hasNext()) {
            Expression lExpression = lIterator.next();
            lExpression.operation(pIndentation + 1);
        }
        displayIndentation(pIndentation);
        System.out.println("</" + libelle + ">");
    }
}

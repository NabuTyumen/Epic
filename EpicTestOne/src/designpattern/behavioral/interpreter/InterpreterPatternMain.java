package designpattern.behavioral.interpreter;

public class InterpreterPatternMain {

    public static void main(String[] args) {
        // Creation des expressions non terminales
        ExpressionNoTerminale lRoot = 
                new ExpressionNoTerminale("ROOT");
        ExpressionNoTerminale lElement1 = 
                new ExpressionNoTerminale("ELEMENT1");
        ExpressionNoTerminale lElement2 = 
                new ExpressionNoTerminale("ELEMENT2");
        ExpressionNoTerminale lElement3 = 
            new ExpressionNoTerminale("ELEMENT3");
        
        // Creation des expressions terminales
        ExpressionTerminale lTexte1 = 
                new ExpressionTerminale("TEXT1");
        ExpressionTerminale lTexte2 = 
                new ExpressionTerminale("TEXT2");

        // Build tree
        lRoot.ajouterExpression(lElement1);
        lRoot.ajouterExpression(lElement2);
        lElement2.ajouterExpression(lElement3);
        lElement1.ajouterExpression(lTexte1);
        lElement3.ajouterExpression(lTexte2);
        
        // Call method of the root expression
        lRoot.operation();
        
        // Affichage : 
        // <ROOT>
        //     <ELEMENT1>
        //         TEXTE1
        //     </ELEMENT1>
        //     <ELEMENT2>
        //         <ELEMENT3>
        //             TEXTE2
        //         </ELEMENT3>
        //     </ELEMENT2>
        // </ROOT>
    }
}

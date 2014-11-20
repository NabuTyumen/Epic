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
        lRoot.addExpression(lElement1);
        lRoot.addExpression(lElement2);
        lElement2.addExpression(lElement3);
        lElement1.addExpression(lTexte1);
        lElement3.addExpression(lTexte2);
        
        // Call method of the root expression
        lRoot.operation();
        
        // Displayed : 
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

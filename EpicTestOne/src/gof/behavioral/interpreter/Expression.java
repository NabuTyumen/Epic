package gof.behavioral.interpreter;

/**
 * Define the interface of a expression
 */
public abstract class Expression {

    protected static void displayIndentation(int pIndentation) {
        for(int i=0;i<pIndentation;i++) {
            System.out.print("    ");
        }
    }
    
    public void operation() {
        operation(0);
    }
    
    public abstract void operation(int pIndentation);
}

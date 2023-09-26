package AllExpression;

import Interpretator.Expression;

public class TabExpression extends Expression {
    @Override
    public String interpret(String context) {
        return context.replaceAll("\t", "    ");
    }
}

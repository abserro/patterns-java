package AllExpression;

import Interpretator.Expression;

public class MultipleNewlinesExpression extends Expression {
    @Override
    public String interpret(String context) {
        return context.replaceAll("\\n+", "\n");
    }
}

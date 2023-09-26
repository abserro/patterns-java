package AllExpression;

import Interpretator.Expression;

public class MultipleSpacesExpression extends Expression {

    @Override
    public String interpret(String context) {
        return context.replaceAll(" {2,}", " ");
    }
}

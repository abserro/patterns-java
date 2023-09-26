package AllExpression;

import Interpretator.Expression;

public class ExtraSpaceExpression extends Expression {
    @Override
    public String interpret(String context) {
        return context.replaceAll("\\(\\s+", "(")
                .replaceAll("\\s+\\)", ")")
                .replaceAll("«\\s+", "«")
                .replaceAll("\\s+»", "»")
                .replaceAll("\\s+,", ",")
                .replaceAll("\\s+\\.", ".");
    }
}

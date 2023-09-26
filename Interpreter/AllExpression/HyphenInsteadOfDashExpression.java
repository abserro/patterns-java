package AllExpression;

import Interpretator.Expression;

public class HyphenInsteadOfDashExpression extends Expression {
    @Override
    public String interpret(String context) {
        return context.replaceAll("(?<=\\p{L})(-)(?=\\p{L})", " — ")
                .replaceAll("(?<=\\p{L})( - )(?=\\p{L})", " — ");
    }
}

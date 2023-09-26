package AllExpression;

import Interpretator.Expression;

public class QuotationMarksExpression extends Expression {
    @Override
    public String interpret(String context) {
        return context.replaceAll("\"([^\"]*)\"", "«$1»");
    }
}

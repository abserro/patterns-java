package TextEditor;

import AllExpression.*;
import Interpretator.Expression;

import java.util.ArrayList;
import java.util.List;

public class TextEditorInterpreter extends Expression {
    private final List<Expression> expressions;

    public TextEditorInterpreter() {
        expressions = new ArrayList<>();
        expressions.add(new MultipleNewlinesExpression());
        expressions.add(new QuotationMarksExpression());
        expressions.add(new MultipleSpacesExpression());
        expressions.add(new ExtraSpaceExpression());
        expressions.add(new HyphenInsteadOfDashExpression());
        expressions.add(new TabExpression());
    }

    public String interpret(String context) {
        String result = context;
        for (Expression expression : expressions) {
            result = expression.interpret(result);
        }
        return result;
    }
}

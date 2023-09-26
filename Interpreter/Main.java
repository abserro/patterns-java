import Interpretator.Expression;
import TextEditor.TextEditorInterpreter;

public class Main {
    public static void main(String[] args) {
        String context = "Это пример      текста со множественными пробелами.\n" +
                "Дефис используется неправильно - вместо тире." +
                "\n\n\" Внимание \"! Использованы неправильные кавычки. К тому же тут были лишние пробелы.\n" +
                "\tТабуляторы в тексте-не допустимы. Они заменены на пробелы!\n" +
                "Функция( аргумент1 , аргумент2 ) .   Множественные пробелы и лишние пробелы.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Лишний символ перевода строки";

        Expression expression = new TextEditorInterpreter();
        System.out.println(expression.interpret(context));
    }
}
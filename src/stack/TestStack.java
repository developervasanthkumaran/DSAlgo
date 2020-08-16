package stack;

public class TestStack {

    public static void main(String[] args) {
        Expression expression = new Expression();
        String k = "((4*(4*2))/2)";
        String postfix = expression.infixToPostfix(k);
        String prefix = expression.infixToPrefix(k);
        System.out.println("postfix : "+postfix);
        System.out.println("prefix : "+prefix);
        System.out.println(expression.postfixToInfix(postfix));
        System.out.println(expression.prefixToInfix(prefix));
        System.out.println(expression.evaluatePreFix(prefix));
        System.out.println(expression.evaluatePostFix(postfix));

    }

}

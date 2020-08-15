package stack;

public class TestStack {

    public static void main(String[] args) {
        Expression expression = new Expression();
        System.out.println(expression.infixToPostfix("A+B*C/(E-F)"));
        System.out.println(expression.infixToPrefix("A+B*C/(E-F)"));
        System.out.println(expression.evaluatePreFix("35*2+7*4-9/3"));
        System.out.println(expression.evaluatePostFix("35*2+7*4-9/3"));

    }

}

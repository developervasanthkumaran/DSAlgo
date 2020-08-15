package stack;

public class TestStack {

    public static void main(String[] args) {
        Expression expression = new Expression();
        System.out.println(expression.infixToPostfix("(((2*4)-(3/5)*((5*2)+8)))"));
        System.out.println(expression.infixToPrefix("(((2*4)-(3/5)*((5*2)+8)))"));
        System.out.println(expression.evaluatePreFix("35*2+7*4-9/3"));
        System.out.println(expression.evaluatePostFix("35*2+7*4-9/3"));

    }

}

package stack;
import java.util.HashSet;

class Expression {

    private Stack<Character> stack;
    private Stack<Double> s;
    private HashSet<Character> operators;
    private Stack<String> stringStack;
    Expression(){
        stack = new Stack<>();
        s=new Stack<>();
        stringStack = new Stack<>();
        operators = new HashSet<>();
        operators.add('*');
        operators.add('/');
        operators.add('+');
        operators.add('-');
        operators.add('^');
    }

     String infixToPostfix(String exp){
        if(exp.isEmpty())return null;
        int length = exp.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length ; i++) {
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                builder.append(c);
            }
            else if(c == '(')stack.push(c);
            else if(c==')'){
                while (!stack.isEmpty() && stack.peek()!='(' &&
                precedence(c) <= precedence(stack.peek())){
                    builder.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && stack.peek()!='(' &&
                        precedence(c) <= precedence(stack.peek())){
                    builder.append(stack.pop());
                }
                stack.push(c);
            }
        }

         while (!stack.isEmpty()){
                builder.append(stack.pop());
        }
        return builder.toString();
    }

     String infixToPrefix(String exp){
        return reverse(infixToPostfix(reverse(exp)));
    }

   private String reverse(String exp){
        char[] c = exp.toCharArray();
        for (int i = 0,j=c.length-1;i<j || j < i; i++,j--) {
            if(c[i]==')')c[i]='(';
            else if(c[i]=='(')c[i] = ')';
            if(c[j]==')')c[j]='(';
            else if(c[j]=='(')c[j] = ')';
            char t = c[i];
            c[i]=c[j];
            c[j]=t;
        }
        int mid = c.length/2;
        if(c[mid]==')')c[mid]='(';
        else if(c[mid]=='(')c[mid] = ')';

        return String.valueOf(c);
    }

    double evaluatePostFix(String exp){
        int len = exp.length();
        for (int i = 0; i < len; i++) {
            char c= exp.charAt(i);
            double n1=0,n2=0;
            if(operators.contains(c)){
                if(!s.isEmpty())
                 n2 = s.pop();
                if(!s.isEmpty())
                 n1 = s.pop();
                s.push(evaluate(c,n1,n2));
            }
            else {
                s.push((double)c - '0');
            }
        }
    return s.pop();
    }

   private double evaluate(char c,double n1,double n2){
        switch (c){
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '^':
                return (int)Math.pow(n1,n2);
        }
    return 0;
    }

    double evaluatePreFix(String exp){
        int len = exp.length();
        for (int i = len-1; i > -1; i--) {
            char c= exp.charAt(i);
            double n1=0,n2=0;
            if(operators.contains(c)){
                if(!s.isEmpty())
                    n2 = s.pop();
                if(!s.isEmpty())
                    n1 = s.pop();
                s.push(evaluate(c,n2,n1));
            }
            else s.push((double)c - '0');
        }
        return s.pop();
    }

   private int precedence(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    String prefixToPostfix(String exp){
        if(exp.isEmpty())return null;
        String k = prefixToInfix(exp);
        return infixToPostfix(k);
    }

    String prefixToInfix(String exp){
        if(exp.isEmpty())return null;
        int len = exp.length();
        for (int i = len-1; i >-1 ; i--) {
            char c = exp.charAt(i);

            if(operators.contains(c)){
                 String s1 = stringStack.pop();
                 String s2 = stringStack.pop();
                 String temp = "("+s1+c+s2+")";
                stringStack.push(temp);
            }
            else {
                stringStack.push(String.valueOf(c));
            }
        }

        return stringStack.pop();
    }

    String postfixToInfix(String exp){
        if(exp.isEmpty())return null;
        int len = exp.length();
        for (int i = 0; i <len ; i++) {
            char c = exp.charAt(i);

            if(operators.contains(c)){
                String s1 = stringStack.pop();
                String s2 = stringStack.pop();
                String temp = "("+s2+c+s1+")";
                stringStack.push(temp);
            }
            else {
                stringStack.push(String.valueOf(c));
            }
        }

        return stringStack.pop();
    }

    String postfixToPrefix(String exp){
        if(exp.isEmpty())return null;
       String k = postfixToInfix(exp);
       return infixToPrefix(k);
    }
}

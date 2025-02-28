// Question: Evaluation of Postfix Expression... 
// You are given an array of strings arr that represents a valid arithmetic expression written in Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and return an integer representing its value.
// Key Details: The valid operators are '+', '-', '*', and '/'.
// Each operand is guaranteed to be a valid integer or another expression.
// The division operation between two integers always rounds the result towards zero, discarding any fractional part.
// No division by zero will occur in the input.
// The input is a valid arithmetic expression in Reverse Polish Notation.
// The result of the expression and all intermediate calculations will fit in a 32-bit signed integer.

// Examples:
// Input: arr = ["2", "3", "1", "*", "+", "9", "-"]
// Output: -4
// Explanation: If the expression is converted into an infix expression, it will be 2 + (3 * 1) – 9 = 5 – 9 = -4.

package shreyam.gfg;

import java.util.Stack;

public class EvaluationPostfixExpression {
    public static int evaluate (String[] arr){
        Stack <Integer> stack = new Stack<>();
        for(String ch : arr){
            if(isOperator(ch)){
                            int b = stack.pop();
                            int a = stack.pop();
                            int res = apply(a,b,ch);
                            stack.push(res);
                        }else{
                            stack.push(Integer.parseInt(ch));
                            // stack.push(Integer.parseInt(ch));
                        }
                    }
                    return stack.pop();
                }
            
    static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    static int apply(int a, int b, String operator){
        return switch (operator) {
            case "+" -> a+b;
            case "-" -> a-b;
            case "*" -> a*b;
            case "/" -> a/b;
            default -> a;
        };

        // switch (operator) {
        //     case "+" : return a+b;
        //     case "-" : return a-b;
        //     case "*" : return a*b;
        //     case "/" : return a/b;
        //     default:return a;
        // }
    }

    public static void main(String[] args) {
        String [] arr = {"2", "3", "1", "*", "+", "9", "-"};
        int res = evaluate(arr);
        System.out.println(res);
    }
}

// Question: Longest valid Parentheses... 

// Given a string s consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.
// A parenthesis string is valid if:
// For every opening parenthesis, there is a closing parenthesis.
// The closing parenthesis must be after its opening parenthesis.
// Examples :

// Input: s = "((()"
// Output: 2
// Explanation: The longest valid parenthesis substring is "()".

// package shreyam.gfg;

import java.util.Stack;

public class LongestValidParentheses {
    static int maxLength(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); 
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);  
            } else {
                stack.pop();  

                if (stack.isEmpty()) {
                    stack.push(i);  
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek()); 
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "())()";
        int res = maxLength(s);
        System.out.println(res);  
    }
}

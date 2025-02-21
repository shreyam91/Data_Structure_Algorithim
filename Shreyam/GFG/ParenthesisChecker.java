// Question: Parenthesis Checker... 
// Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
// An input string is valid if:
//     1. Open brackets must be closed by the same type of brackets.
//     2. Open brackets must be closed in the correct order.

// Examples :
// Input: s = "[{()}]"
// Output: true

package shreyam.gfg;

import java.util.Stack;

public class ParenthesisChecker {
    static boolean isBalanced(String s) {
        Stack <Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; 
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || 
                    (ch == '}' && top != '{') || 
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "[{()}])";
        boolean res = isBalanced(s);
        System.out.println(res);
    }
}

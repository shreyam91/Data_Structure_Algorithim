// Question: Searching Challenge.. 
// It takes the str parameter being passed and return 1 if the brackets are correctly matched and each one is accounted for. Otherwise return 0. If str contains no brackets return 0. Only "( and )" will be used as brackets.
// Example: 
// I/p: "(coder)(byte))"
// O/p: 0

// I/p: "(c(oder))b(yte)"
// O/p: 1

package Shreyam.trickyQuestion;

import java.util.Stack;

public class searchingChallenge {
    static String searchChallenge(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch:str.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                if(stack.empty()){
                    return "0";
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? "1":"0";
    }
    public static void main(String[] args) {
        String s = "(c(oder))b(yte)";
        System.out.println(searchChallenge(s));
    }
}

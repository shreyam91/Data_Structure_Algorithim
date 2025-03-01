// Question: Decode the string... 
// Given an encoded string s, the task is to decode it. The encoding rule is :
// k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
// Note: The test cases are generated so that the length of the output string will never exceed 105 .

// Examples:
// Input: s = "1[b]"
// Output: "b"
// Explanation: "b" is present only one time.

package shreyam.gfg;

import java.util.Stack;

public class DecodeTheString {
    static String decodeString(String s) {
        Stack<Integer> count = new Stack();
        Stack<String> result = new Stack();
        char[] arr = s.toCharArray();
        int i=0, num=0;
        String curr = "";
        while(i<s.length()){
            if(Character.isDigit(arr[i])){
                num=0;
                while(Character.isDigit(arr[i])){
                    num = num*10+(arr[i]-'0');
                    i++;
                }
                count.push(num);
            }
            else if(arr[i]=='['){
                result.add(curr);
                curr="";
                i++;
            }
            else if(arr[i]==']'){
                int n=count.pop();
                StringBuilder sb = new StringBuilder(result.pop());
                for(int j=0;j<n;j++){
                    sb.append(curr);
                }
                curr=sb.toString();
                i++;
            }
            else {
                curr+=arr[i];
                i++;
            }
        }
        return curr;
    }
    public static void main(String[] args) {
        String s = "1[b]";
        String res = decodeString(s);
        System.out.println(res);
    }
}

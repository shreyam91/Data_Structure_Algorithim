// Question: All Palindromic Partitions 

// Given a string s, find all possible ways to partition it such that every substring in the partition is a palindrome.

// Examples:
// Input: s = "geeks"
// Output: [[g, e, e, k, s], [g, ee, k, s]]

package shreyam.gfg;

import java.util.ArrayList;

public class AllPalindromicPartitions{
    public static ArrayList<ArrayList<String>> palinParts(String s) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        chec(s, 0, tmp, ans);
        return ans;
    }
    static void chec(String s, int ind,  ArrayList<String> tmp, ArrayList<ArrayList<String>> ans){
        if(ind>=s.length()){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=ind+1;i<=s.length();i++){
            String curr = s.substring(ind, i);
            if(isPalin(curr)){
                tmp.add(curr);
                chec(s, i, tmp, ans);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    static boolean isPalin(String curr){
        int i=0,j=curr.length()-1;
        while(i<j){
            if(curr.charAt(i)!=curr.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
       String s = "geeks";
       System.out.println(palinParts(s));
    }
}
// Question: Valid Anagram... 
package shreyam.array;

public class ValidAnagram {

    // <!--- Brute Force Approach ---> TC: O(nlogn) SC: O(n)
    // static boolean isAnagram(String s, String t){
    //         if(s.length() != t.length()){
    //             return false;
    //         }
            
    //         char[] sArray = s.toCharArray();
    //         char[] tArray = t.toCharArray();

    //         Arrays.sort(sArray);
    //         Arrays.sort(tArray);

    //         return Arrays.equals(sArray, tArray);
    // }
    // <!--- Optimal Approach ---> TC: O(n), SC: O(1)

    static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] charCount = new int[256];

        for(int i=0; i<s.length();i++){
            charCount[s.charAt(i)]++;
            charCount[t.charAt(i)]--;
        }

        for(int count: charCount){
            if( count != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean res = isAnagram(s, t);
        System.out.println(res);
    }
}

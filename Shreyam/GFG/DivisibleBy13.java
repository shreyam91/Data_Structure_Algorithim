// Question: Divisible by 13 

// Given a number represented as a string s (which may be very large), check whether it is divisible by 13 or not.

// Examples:
// Input : s = "2911285"
// Output : true

package shreyam.gfg;

public class DivisibleBy13 {
    public static boolean divby13(String s) {
        int rem = 0;
        for (int i = 0; i < s.length(); i++) {
            rem = (rem * 10 + (s.charAt(i) - '0')) % 13;
        }
        return rem == 0;
    }
    public static void main(String[] args) {
        String s = "2911285";
        System.out.println(divby13(s));
    }
}

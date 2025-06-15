// Question: Max Difference You Can Get From Changing an Integer 

// You are given an integer num. You will apply the following steps to num two separate times:
// Pick a digit x (0 <= x <= 9).
// Pick another digit y (0 <= y <= 9). Note y can be equal to x.
// Replace all the occurrences of x in the decimal representation of num by y.
// Let a and b be the two results from applying the operation to num independently.
// Return the max difference between a and b.
// Note that neither a nor b may have any leading zeros, and must not be 0.

// Example 1:
// Input: num = 555
// Output: 888

package shreyam.leetCode;

public class Question1432 {
    public static int maxDiff(int num) {
        String str1 = Integer.toString(num);
        String str2 = str1;

        int idx = -1;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '9') {
                idx = i;
                break;
            }
        }

        if (idx != -1) {
            char ch = str1.charAt(idx);
            str1 = str1.replace(ch, '9');
        }

        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (i == 0) {
                if (ch != '1') {
                    str2 = str2.replace(ch, '1');
                    break;
                }
            } else if (ch != '0' && ch != str2.charAt(0)) {
                str2 = str2.replace(ch, '0');
                break;
            }
        }

        return Integer.parseInt(str1) - Integer.parseInt(str2);
    }
    public static void main(String[] args) {
       int num = 555;
       System.out.println(maxDiff(num));
    }
}

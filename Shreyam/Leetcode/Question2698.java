// Question:Find the Punishment Number of an Integer
// Given a positive integer n, return the punishment number of n.
// The punishment number of n is defined as the sum of the squares of all integers i such that:
// 1 <= i <= n
// The decimal representation of i * i can be partitioned into contiguous substrings such that the sum of the integer values of these substrings equals i.
 

// Example 1:
// Input: n = 10
// Output: 182
package shreyam.leetCode;

public class Question2698 {
        private boolean isValid(String sq, int pos, int sum, int val) {
            if (pos >= sq.length()) {
                return sum == val;
            }
            
            for (int i = 0; i + pos < sq.length(); ++i) {
                int currVal = Integer.parseInt(sq.substring(pos, pos + i + 1));
                if (isValid(sq, pos + i + 1, sum + currVal, val)) {
                    return true;
                }
            }
            return false;
        }
    
        public int punishmentNumber(int n) {
            int punishmentNumber = 1;
            for (int i = 2; i <= n; ++i) {
                String sq = Integer.toString(i * i);
                if (isValid(sq, 0, 0, i)) {
                    punishmentNumber += i * i;
                }
            }
            return punishmentNumber;
        }
    
        public static void main(String[] args) {
            Question2698 solution = new Question2698();
            int n = 10; // Example input
            System.out.println(solution.punishmentNumber(n));
        }
    }

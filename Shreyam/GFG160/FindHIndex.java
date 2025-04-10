// Question: Find H-Index... 
// Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.
// H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

// Examples:
// Input: citations[] = [3, 0, 5, 3, 0]
// Output: 3

package shreyam.GFG160;

public class FindHIndex {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                freq[n]++;
            } else {
                freq[citations[i]]++;
            }
        }

        int hIndex = n;
        int count = freq[n];

        while (hIndex > count) {
            hIndex--;
            count += freq[hIndex];
        }

        return hIndex;
    }
    public static void main(String[] args) {
        int citations[] = {3, 0, 5, 3, 0};
        int res = hIndex(citations);
        System.out.println(res);
    }
}

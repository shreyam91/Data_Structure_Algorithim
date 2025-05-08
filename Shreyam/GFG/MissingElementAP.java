// Question: Missing element of AP 

// Given a sorted array arr[] that represents an Arithmetic Progression (AP) with exactly one missing element, find the missing number.
// Note: An element will always exist that, upon inserting into a sequence forms Arithmetic progression. If the given sequence already forms a valid complete AP, return the (n+1)-th element that would come next in the sequence.

// Examples:
// Input: arr[] = [2, 4, 8, 10, 12, 14]
// Output: 6

package shreyam.gfg;

public class MissingElementAP{
    public static int findMissing(int[] arr) {
        int n = arr.length;
        int commonDiff = arr[1] - arr[0];
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] + commonDiff != arr[i + 1]) {
                ans = arr[i] + commonDiff;
                break;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {5, 10, 15, 20};
        System.out.println(findMissing(arr));
    }
}

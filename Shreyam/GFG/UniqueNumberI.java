// Question: Unique Number I... 
// Given a unsorted array arr[] of positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.

// Examples :
// Input: arr[] = [1, 2, 1, 5, 5]
// Output: 2

package shreyam.gfg;

public class UniqueNumberI {
    public static int findUnique(int[] arr) {
        int res = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            res = res^arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1,5,5};
        int res = findUnique(arr);
        System.out.println(res);
    }
}

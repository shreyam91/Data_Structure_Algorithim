// Questione: Police and Thieves 

// Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. 
// Keep in mind the following conditions :

// Each policeman can catch only one thief.
// A policeman cannot catch a thief who is more than k units away from him.
// Examples:
// Input: arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1
// Output: 2


package shreyam.gfg;

public class PoliceAndThieves {
    public static int catchThieves(char[] arr, int k) {
        int n = arr.length;
    int i = 0, j = 0;
    int count = 0;

    while (i < n && j < n) {
        // Find next police
        while (i < n && arr[i] != 'P') i++;
        // Find next thief
        while (j < n && arr[j] != 'T') j++;

        // Check if both indices are valid
        if (i < n && j < n) {
            if (Math.abs(i - j) <= k) {
                count++;
                i++;
                j++;
            } else if (j < i) {
                j++;
            } else {
                i++;
            }
        }
    }
        return count;
    }
    public static void main(String[] args) {
       char arr[] = {'P', 'T', 'T', 'P', 'T'};
       int k = 1;
        System.out.println(catchThieves(arr, k));
    }
}

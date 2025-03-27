// Question: Minimum Platforms... 
// You are given the arrival times arr[] and departure times dep[] of all trains that arrive at a railway station on the same day. Your task is to determine the minimum number of platforms required at the station to ensure that no train is kept waiting.
// At any given time, the same platform cannot be used for both the arrival of one train and the departure of another. Therefore, when two trains arrive at the same time, or when one arrives before another departs, additional platforms are required to accommodate both trains.

// Examples:
// Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
// Output: 3

package shreyam.gfg;

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformsNeeded = 0, maxPlatforms = 0;
        int i = 0, j = 0;

       
        while (i < n && j < n) {
            
            if (arr[i] <= dep[j]) {
                platformsNeeded++; 
                i++;
            } else {
                platformsNeeded--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        int res = findPlatform(arr, dep);
        System.out.println(res);
    }
}

// Question: Koko Eating Bananas 

// Koko is given an array arr[], where each element represents a pile of bananas. She has exactly k hours to eat all the bananas.
// Each hour, Koko can choose one pile and eat up to s bananas from it.
// If the pile has atleast s bananas, she eats exactly s bananas.
// If the pile has fewer than s bananas, she eats the entire pile in that hour.
// Koko can only eat from one pile per hour.
// Your task is to find the minimum value of s (bananas per hour) such that Koko can finish all the piles within k hours.

// Examples:
// Input: arr[] = [5, 10, 3], k = 4
// Output: 5

package shreyam.gfg;

public class KokoEatingBananas {
    public static int kokoEat(int[] arr, int k) {
        int lo =1, hi=0, ans=0;
        for(int i: arr){
            hi=Math.max(hi,i);
        }
        while(lo<=hi){
            int bananaPerHour = (lo+hi)/2;
            int totHr = 0;
            for(int i:arr){
                totHr+= i%bananaPerHour == 0 ? i/bananaPerHour : i/bananaPerHour +1;
            }
            if(totHr > k){
                lo=bananaPerHour+1;
            }
            else {
                ans=bananaPerHour;
                hi=bananaPerHour-1;
            }
        }
        return ans;        
    }
    public static void main(String[] args) {
        int arr[] = {5, 10, 3};
        int k = 4;
        System.out.println(kokoEat(arr, k));
    }
}

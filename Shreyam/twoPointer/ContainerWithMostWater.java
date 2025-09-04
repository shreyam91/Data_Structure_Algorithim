// Question: Container With Most Water 

// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

package shreyam.twoPointer;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int length = height.length;
        int maxWater = 0;

        // for(int i=0;i<length;i++){
        //     for(int j=i+1;j<length;j++){
        //         int width = j-i;
        //         int height1 = Integer.min(height[i], height[j]);
        //         int area = width * height1;
        //         maxWater = Integer.max(area,maxWater);
        //     }
        // }
        // return maxWater;

        int left  =0, right = length-1;
        while(left < right){
            int width = right-left;
            int height1 = Integer.min(height[left],height[right]);
            int area = width * height1;

            maxWater = Integer.max(area, maxWater);
            if(height[left] < height[right]){
                left++;}
                else{
                right--;
            }
        }
        return maxWater;

    }
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}

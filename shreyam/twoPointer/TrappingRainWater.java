// Question: Trapping Rain Water 

// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

package shreyam.twoPointer;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int length = height.length;

        int leftMax = 0, rightMax = 0;
        int left = 0, right = length-1;
        int ans = 0;

        while(left < right){
            leftMax = Integer.max(leftMax, height[left]);
            rightMax = Integer.max(rightMax, height[right]);

            if(leftMax < rightMax){
                ans += (leftMax - height[left]);
                left++;
            }else{
                ans += (rightMax - height[right]);
                right--;
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}

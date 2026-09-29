class Solution {
    public int removeDuplicates(int[] nums) {
        int i =0;
        int count = 0;

        for(int j =0; j<nums.length;j++){
            if(i == 0 || nums[j] != nums[i-1]){
                count = 1;
                nums[i] = nums[j];
                i++;
            }else if(count <2){
                count++;
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int score =0;
        int result = 0;
        int left = 0;
        int right = tokens.length -1;

        while(left <= right){
            if (power >= tokens[left]){
                power -= tokens[left];
                left++;
                score += 1; 
                result = Math.max(score, result);
            }else if(score > 0){
                power += tokens[right];
                right--;
                score -= 1;
            }
            else{
                break;
            }
        }
        return result;
    }
}
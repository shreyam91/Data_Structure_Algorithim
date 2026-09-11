class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];

        for (int digit: digits){
            count[digit]++;
        }

        int ans =0;

        for(int num = 100; num <= 998; num +=2){
            int a = num/100;
            int b = (num/10) %10;
            int c = num%10;

            int [] need = new int [10];
            need[a]++;
            need[b]++;
            need[c]++;

            boolean possible = true;

            for(int digit = 0; digit <10; digit++){
                if(need[digit] > count[digit]){
                    possible = false;
                    break;
                }
            }
            if(possible){
                ans++;
            }
        }
        return ans;
    }
}
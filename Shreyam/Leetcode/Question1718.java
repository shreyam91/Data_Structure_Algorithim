// Question: Construct the Lexicographically Largest Valid Sequence... 

package shreyam.leetCode;

public class Question1718 {
    static int[] constructDistancedSequence(int n) {
        boolean used[] = new boolean[n+1];
        int seq[] = new int[2*n-1];
        backtrack(0,used, seq, n);
        return seq;
    }
    static boolean backtrack(int index, boolean used[], int seq[], int n){
        while(index < seq.length && seq[index]!=0) index++;
        if(index == seq.length) return true;
        for(int i=n;i>=1;i--){
            if(used[i]) continue;
            if(i==1){
                seq[index] = i;
                used[i] = true;
                if(backtrack(index+1,used,seq,n)) return true;
                // if we cannot find answer
                seq[index]=0;
                used[i] = false;
            }else if(index + i < seq.length && seq[index+i] == 0){
                seq[index] = i;
                seq[index + i] = i;
                used[i] = true;
                if(backtrack(index+1,used,seq,n)) return true;
                // if we cannot find answer
                seq[index]=0;
                seq[index + i]=0;
                used[i] = false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n =3;
        int[] res = constructDistancedSequence(n);
        for(int ele : res){
            System.out.print(ele + " ");
        }
    }
}

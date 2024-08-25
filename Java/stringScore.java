package Java;

public class stringScore {
    public static int stringScore(String str,int ans){
        ans=0;

        for(int i=1;i<str.length();i++)
            ans += Math.abs(str.charAt(i) - str.charAt(i-1));
        
            return ans;
    }
    public static void main(String[] args) {
        String str = "Hello";
        int result=0;
        
        result = stringScore(str, result);
        // System.out.println("sum " + ans); 
    }
}

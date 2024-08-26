package Shreyam;

public class sumOfNaturalNumber {
    public static void main(String[] args) {
        int n =5;
        int sum =0;
        for(int i=1;i<=n;i++){
            if(i==n){
                System.out.print(i+"=");
            }
            else{
                System.out.print(i+"+");
            }
            sum= sum+i;
        }
        System.out.println(sum);
    }
}

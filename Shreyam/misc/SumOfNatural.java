package Shreyam.misc;

public class SumOfNatural {
    public static void main(String[] args) {
        int natural =5;
        int sum=0;

        for(int i=1; i<=natural; i++){
            if(i==natural){
                System.out.print(i+"=");
            }
            else{
                System.out.print(i + "+");
            }
            sum = sum+i;
        }
        System.out.println(sum);
    }
}

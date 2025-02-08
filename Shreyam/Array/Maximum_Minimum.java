package Shreyam.array;

public class Maximum_Minimum {
    public static void main(String[] args) {
        System.out.println("This program is intended to find maximum and minimum values in the given array...");
        int arr[] = {1,56,29,23,11,89,34,29,50,129};
        int max =0;
        int min =arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }

        System.out.println("Maximum value is: "+max);
        System.out.println("Minimum value is: "+min);
        
    }
}

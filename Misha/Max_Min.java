package Misha;

public class Max_Min {
    public static void main(String[] args) {
int arr[] = new int[]{2,7,4,110,90};
int max = arr[0];
int min = arr[0];
for(int i=0;i<arr.length;i++){
    if(arr[i]<min){
        min=arr[i];
    }
    if(arr[i]>max){
        max=arr[i];
    }
}
    System.out.println("maximum value is " + max);
    System.out.println("Minimum value is " + min);
}
    }


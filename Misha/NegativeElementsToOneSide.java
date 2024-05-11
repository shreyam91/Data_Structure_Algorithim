package Misha;

import java.util.Scanner;

public class NegativeElementsToOneSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);{
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
              arr[i] = sc.nextInt();
            }
            int j=-1;
            for(int i=0;i<n;i++){
                if(arr[i]<0){
                    j++;
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
            sc.close();
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+ " ");
            }
        }
    }
}

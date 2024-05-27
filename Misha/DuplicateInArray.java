package Misha;

public class DuplicateInArray {
    public static int findDuplicate(int arr[]){

    
    for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
            if(arr[i]==arr[j]){
                return arr[i];
            }
        }
    }
    return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,4,2,2,8,9,0};
        int duplicate = findDuplicate(arr);
        System.out.println("Duplicate no is: " + duplicate);
    }
}

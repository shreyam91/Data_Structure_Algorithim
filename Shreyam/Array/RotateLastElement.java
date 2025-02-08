package shreyam.array;

public class RotateLastElement {
    public static void main(String[] args) {
        
        int arr [] = {3,5,6,8,2};
        // System.out.println("Array "+ arr);

        int lastElement=arr[arr.length-1];

        for (int i = arr.length-1; i> 0; i--) {
            arr[i] = arr[i-1];
    }

    arr[0] = lastElement;

    for(int num:arr){
    System.out.print(num + " ");}
}
    
}

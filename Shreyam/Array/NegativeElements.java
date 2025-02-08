package shreyam.array;

public class NegativeElements {

    public static void negativeElements(int[] arr){
        int left =0;
        int right =arr.length-1;

        while (left <=right){
            if(arr[left] <0){
                left++;
            }else{
                if(arr[right] <0){
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                right--;
            }
        }
    }
    public static void main(String[] args) {
        
    int arr[] = {5,7,23,-2,-6,62,-43};
    negativeElements(arr);

    for(int num:arr) {
        System.out.print(" " + num);
    }
}
}


package Shreyam.BinarySearch;

public class RowColoumnMatrix {
    public static int[] binarySearch(int[][]arr,int target){
        int n = arr.length;
        int m = arr[0].length;

        int row=0, col = m-1;
        while(row < n && col >= 0){
            if(arr[row][col] == target){
                return new int[]{row,col};}
            else if(arr[row][col] > target)
                col--;
            else 
                row++;
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int arr[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,35,39,50}};
        int target = 29;

        int[] result = binarySearch(arr, target);

        if(result[0] == -1)
            System.out.println("Element not found");
        else    
            System.out.println("Element found at: (" + result[0] + " , " + result[1] + ")");
    }
}

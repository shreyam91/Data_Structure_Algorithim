package shreyam.misc;

public class ExcelColumn {
    public static void main(String[] args) {
        int[] input = {25,43,678,12}; 
        for (int num : input) {
            System.out.print(convertToExcelColumn(num) + " ");
        }
    }

    public static String convertToExcelColumn(int n) {
        StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            n--; 
            result.insert(0, (char) ('A' + n % 26)); 
            n /= 26; 
        }

        return result.toString();
    }
}



// input: 26, 51, 52, 80, 702, 705
// output: Z AY AZ CB ZZ AAC 


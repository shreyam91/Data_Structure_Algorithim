package shreyam.recursion;

public class Basic {
    static void print(int i,int n){
        if(i>n) return;
        System.out.println("hello Recursion...");
        print(i+1,n);
    }
        
    static void print2(int i, int n){
        if(i>n) return;
        System.out.println(i);
        print2(i+1,n);
    }

    static void print3(int i, int n){
        if(i<1) return;
        System.out.println(i);
        print3(i-1,n);
    }

    static void backtrack(int i, int n){
        if(i>n) return;
        backtrack(i+1,n);
            System.out.println(i);
    }
    
    static void backtrack2(int i, int n){
        if(i<1) return;
        backtrack2(i-1,n);
            System.out.println(i);
    }
        public static void main(String[] args) {
            // System.out.print("Enter number only:");
            // Scanner numberPattern = new Scanner(System.in);
            // int number = numberPattern.nextInt();

            print(1,5);
            print2(1,5);
            print3(5,5);
            backtrack(1,5);
            backtrack2(3,3);
    }
}

package shreyam.array;

import java.util.ArrayList;
import java.util.Arrays;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list  =  new ArrayList<>(Arrays.asList(12,34,56,78,98,26));

        int element = 11;
        int position = 3;

        list.add(position,element);

        System.out.println("updated list:" + list);

        // ******** Deleteion ****** 

        // int dltIndex =2;
        // if (dltIndex < 0 || dltIndex >= list.size()) {
        //     System.out.println("Index out of bounds");
        //     return;
        // }
        // list.remove(dltIndex);
    }
}

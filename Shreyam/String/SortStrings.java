package Shreyam.string;

import java.util.Arrays;

public class SortStrings {
    public static void main(String[] args) {
        String[] str ={"grapes","banana","mango","cat","apple"};

        Arrays.sort(str);

        for(String s:str){
            System.out.println(s);
        }
        
    }
}

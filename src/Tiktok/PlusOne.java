package Tiktok;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    static String plus_one(List<Integer> m){
        StringBuilder out = new StringBuilder();
        for(int i : m){
            out.append(i);
        }
        if(out.toString().equals("")){
            out = new StringBuilder("0");
        }
        out = new StringBuilder(String.valueOf(Integer.parseInt(out.toString()) + 1));
        return out.toString();
    }
//    public String plusOne(int[] digits) {
//
//        int n = digits.length;
//        for(int i=n-1; i>=0; i--) {
//            if(digits[i] < 9) {
//                digits[i]++;
//                out = digits;
//            }
//
//            digits[i] = 0;
//        }
//
//        int[] newNumber = new int [n+1];
//        newNumber[0] = 1;
//
//        return newNumber;
//    }
    public static void main(String[] args) {
        List<Integer> check = new ArrayList<>();
        check.add(0);
        check.add(0);
        System.out.println(plus_one(check));
    }
}

package Codelit;

import java.util.HashMap;
import java.util.Map;

public class NumToWord {
    public static String numberToWords(int num) {




        Map<Integer,String> below10=new HashMap<>();
        Map<Integer,String> below20=new HashMap<>();
        Map<Integer,String> below100=new HashMap<>();


        below10.put(1, "one");
        below10.put(2, "two");
        below10.put(3, "three");
        below10.put(4, "four");
        below10.put(5, "five");
        below10.put(6, "six");
        below10.put(7, "seven");
        below10.put(8, "eight");
        below10.put(9, "nine");

        below20.put(10, "ten");
        below20.put(11, "eleven");
        below20.put(12, "twelve");
        below20.put(13, "thirteen");
        below20.put(14, "fourteen");
        below20.put(15, "fifteen");
        below20.put(16, "sixteen");
        below20.put(17, "seventeen");
        below20.put(18, "eighteen");
        below20.put(19, "nineteen");

        below100.put(20, "twenty");
        below100.put(30, "thirty");
        below100.put(40, "forty");
        below100.put(50, "fifty");
        below100.put(60, "sixty");
        below100.put(70, "seventy");
        below100.put(80, "eighty");
        below100.put(90, "ninety");


        below100.put(100, "hundred");

        // Map number 1000
        //numberToWordMap.put(1000, "thousand");
        return "";
    }
    public static void main(String[] args) {
        numberToWords(123);
    }

}

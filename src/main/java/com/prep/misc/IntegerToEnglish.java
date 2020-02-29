package com.prep.misc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglish {

    @Test
    public void test(){
        //2,147,483,647
        int x=2147483647;
        int numberOfBillions = x/1000000000;
        x = x%1000000000;
        int numOfMillions = x/1000000;
        x=x%1000000;
        int numOfThousands = x/1000;
        x=x%1000;
        int numOfHundreds = x/100;
        x=x%100;
        int numOfTens=x/10;
        int numOfOnes = x%10;
    }

    public String englishThreeDigit(int threeDigit){
        Map<Integer, String> englishDig = new HashMap<Integer, String>();
        englishDig.put(0, "");
        englishDig.put(1, "one");
        englishDig.put(2, "two");
        englishDig.put(3, "three");
        englishDig.put(4, "four");
        englishDig.put(5, "five");
        englishDig.put(6, "six");
        englishDig.put(7, "seven");
        englishDig.put(8, "eight");
        englishDig.put(9, "nine");

        Map<Integer, String> englishTenToTwenty = new HashMap<Integer, String>();
        englishDig.put(0, "");
        englishDig.put(1, "one");
        englishDig.put(2, "two");
        englishDig.put(3, "three");
        englishDig.put(4, "four");
        englishDig.put(5, "five");
        englishDig.put(6, "six");
        englishDig.put(7, "seven");
        englishDig.put(8, "eight");
        englishDig.put(9, "nine");

        return "";
    }



}

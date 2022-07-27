package com.company.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertStringToInteger {
    public static <T> void main(String[] args) {
        String [] str = {"1", "2", "3", "4"};
        int [] results = getIntArray(str);
        List<Integer> intList = new ArrayList<>();
        for(int result : results)
            intList.add(result);
        System.out.println(intList);
    }

    private static int[] getIntArray(String[] strs) {
        int[] arr = new int[strs.length];
        for(int i = 0; i< strs.length; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        return arr;
    }
}

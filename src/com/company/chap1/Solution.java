package com.company.chap1;

import java.util.Arrays;

public class Solution {
    public String solution(String[] par, String[] com){
        // 1. 두 배열을 정렬한다.
        Arrays.sort(par);
        Arrays.sort(com);

        // 2. 두 배열이 다를 때 까지 찾는다.
        int i = 0;
        for(; i<com.length; i++){
            if(!par[i].equals(com[i]))
                break;
        }
        // 3. 여기까지 왔으면, 마지막 주자가 완주하지 못한것이다.
        return par[i];
    }

    public static void main(String[] args) {
        String[] participant = {"bbb", "aaa", "ccc"};
        String[] completion = {"bbb", "aaa"};
        Solution solution = new Solution();
        String ans = solution.solution(participant, completion);
        System.out.println("answer : " + ans);
    }
}

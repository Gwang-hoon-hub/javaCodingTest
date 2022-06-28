package com.company.chap1;

import java.util.Arrays;
import java.util.HashMap;

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

    public String solutionHash(String[] par, String[] com){
        String answer = "";
        // 1. Hash Map을 만든다.
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : par){
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 2. Hash Map을 뺀다.
        for (String player:com){
            map.put(player, map.get(player) - 1);
        }
        // 3. value가 0이 아닌 마지막 주자를 찾는다.
        for (String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"bbb", "aaa", "ccc"};
        String[] completion = {"bbb", "aaa"};
        Solution solution = new Solution();
        String ans = solution.solution(participant, completion);
        System.out.println("answer : " + ans);
        solution.solutionHash(participant, completion);

    }
}

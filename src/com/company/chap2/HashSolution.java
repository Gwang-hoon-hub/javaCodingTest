package com.company.chap2;

import java.util.HashMap;
import java.util.Iterator;

public class HashSolution {

    // 	input : [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]

    public int solution(String[][] clothes){
        // 1. 옷을 종류별로 구분하기
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes){
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 2. 입지 않은 경우를 추가하여 모든 조합 계산하기
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;

        while(it.hasNext())
            answer *= it.next().intValue() + 1; // +1 해당 type을 입지 않은 경우를 고려하기 위해서다.
        // yellow_hat, green_turban, nothing 3가지를 알려주기 위해서 +1을 해야한다.


        // 3. 아무종류의 옷을 입지 않은 경우 제외하기
        return answer - 1;
    }
}

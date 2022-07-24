package com.company.chap2;
//https://school.programmers.co.kr/learn/courses/30/lessons/42862
// 체육복 빌려주기

//        n	    lost	reserve	    return
//        5	    [2, 4]	[1, 3, 5]	5
//        5	    [2, 4]	[3]	        4
//        3	    [3]	    [1]	        2

import java.util.HashSet;

public class Greedy1 {
    HashSet<Integer> reserveSet = new HashSet<>();
    HashSet<Integer> lostSet = new HashSet<>();

    public int SetSolution(int n, int[] lost, int[] reserve){
        int answer = 0;

        // set을 생성한다.
        for(int reserveN : reserve)
            reserveSet.add(reserveN);
        for(int lostN : lost){
            if(reserveSet.contains(lostN)){
                reserveSet.remove(lostN);
            }
            lostSet.add(lostN);
        }

        // 여분의 체육복을 가진 학생을 기준으로 앞뒤로 빌려줄 수 있는지 확인한다.
            for(int i : reserveSet){
                if(lostSet.contains(i-1))
                    lostSet.remove(i-1);
                else if(lostSet.contains(i+1))
                    lostSet.remove(i+1);
            }

        // 전체 학생 수 에서 LostSet의 학생수를 뺀다.
        return n - lostSet.size();
    }

}

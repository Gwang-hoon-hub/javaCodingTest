package com.company.chap2;
//https://school.programmers.co.kr/learn/courses/30/lessons/42862
// 체육복 빌려주기

//        n	    lost	reserve	    return
//        5	    [2, 4]	[1, 3, 5]	5
//        5	    [2, 4]	[3]	        4
//        3	    [3]	    [1]	        2

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    public int ArraySolution(int n, int[] lost, int[] reserve){
        int answer = 0;

        // 학생 배열을 만든다.(0으로 모두 초기화) n+2 만큼의 길이의 배열을 만든다. --> 0과 n+1은 제외하기 위해서
        int[] stuList = new int[n+2];

        for(int i = 0; i<stuList.length; i++)
            stuList[i] = 0;

        // reserve 여분의 체육복을 갖고 있는 학생은 +1로 만든다.
        for(int i : reserve)
            stuList[i]++;

        // lost 체육복을 잃어버린 학생은 -1 해준다.
        for(int i : lost)
            stuList[i]--;

        // 여분이 있는 학생을 기준으로 앞뒤의 학생을 조사한다.
        for(int i =1; i<=n; i++)
            if(stuList[i] == 1){
                if(stuList[i-1] == -1){
                    stuList[i]--;
                    stuList[i-1]++;
                }
                else if(stuList[i+1] == -1)
                    stuList[i]--;
                    stuList[i+1]++;
            }

        // stuList의 0, 1 을 갖고있는 수를 센다.
        for(int i = 1; i<stuList.length-1; i++){
            if(stuList[i] != -1)
                answer++;
        }

        return answer;
    }

}

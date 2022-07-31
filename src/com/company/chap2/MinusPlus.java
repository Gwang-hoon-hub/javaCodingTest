package com.company.chap2;
// https://school.programmers.co.kr/learn/courses/30/lessons/76501
// 음양더하기

public class MinusPlus {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < signs.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }

}

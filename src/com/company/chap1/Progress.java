package com.company.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Progress {

    public int[] solution(int[] progresses, int[] speeds){

        List<Integer> answer = new ArrayList<>();

        for (int i =0; i<progresses.length; i++){
            // 1. 한 개 기능을 개발하는데 필요한 날짜 계산
            double days = (100 - progresses[i] / (double) speeds[i]);
            int daysUp = (int) Math.ceil(days);

            // 2. 함께 배포할 기능의 index 찾기
            int j = i + 1;
            for(; j<progresses.length; j++){
                if(progresses[j] + daysUp * speeds[j] < 100)
                    break;
            }
            // 3. 이번에 배포할 기능의 개수를 추가하기
            answer.add(j-i);
            i = j + 1;
        }
//        int[] answerArray = new int[answer.size()];
//        for (int i = 0; i< answer.size(); i++)
//            answerArray[i] = answer.get(i);
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {
        int[]   prgresses = {93, 30, 55};
        int[]   speeds = {1, 30, 5};
        Progress progress = new Progress();
        System.out.println(Arrays.toString(progress.solution(prgresses, speeds)));
    }
}

package com.company.chap2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12977
// 소수 만들기

public class MakePrimeNumber {
    class Solution{
        public int solution(int[] nums){
            int answer = 0;
            for(int i =0; i<nums.length-2; i++)
                for(int j = i+1; j< nums.length-1; j++)
                    for (int k = j+1; k<nums.length; k++){
                        int n = nums[i] + nums[j] + nums[k];
                        if (isPrime(n)) answer++;
                    }

            return answer;
        }

        public boolean isPrime(int num){
            for(int i = 2; i<num; i++){
                if(num % i == 0) return false;
            }
            return true;
        }
    }
}

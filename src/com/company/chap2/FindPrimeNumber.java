package com.company.chap2;

import com.company.chap1.Solution;

import java.util.HashSet;
import java.util.Iterator;

public class FindPrimeNumber {
    // https://programmers.co.kr/learn/courses/30/lessons/42839
    HashSet<Integer> numberSet = new HashSet<>();   // set 자료구조를 사용하여 중복을 제거한다.

    public boolean isPrime(int number) {
        // 0, 1 은 소수가 아니다.
        if(number == 0 || number == 1)
            return false;

        // 에라토스테이스의 체의 limit을 구한다.
        int lim = (int)Math.sqrt(number);

        // 에라토스테이스의 체에 따라 limit 까지만 배수인지를 확인한다.
        for(int i = 2; i<lim; i++)
            if(number % i == 0)
                return false;

        return true;
    }

    public void recursive(String comb, String others) {

        // 현재의 조합을 set에 추가한다.
        if(!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));

        // 남은 숫자 중 한개를 더 해 새로운 조합을 만든다.
        for(int i =0; i<others.length(); i++)
            recursive(comb + others.charAt(i), others.substring(0,i)+others.substring(i+1));
    }

    public int solutionPrime(String numbers){
        int answer = 0;

        // 주어진 숫자로 만들 수 있는 모든 조합의 수를 구한다.
        recursive("", numbers);

        System.out.println(numberSet);
        // 소수인지를 판별한다.
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()){
            int number = it.next();
            if(isPrime(number))
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        FindPrimeNumber sol = new FindPrimeNumber();
        System.out.println(sol.solutionPrime("17"));
    }
}


//    소수 찾기
//    문제 설명
//    한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//        각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
//        종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        numbers는 길이 1 이상 7 이하인 문자열입니다.
//        numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//        "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
//        입출력 예
//        numbers	return
//        "17"	        3
//        "011"	        2

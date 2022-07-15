package com.company.chap2;

public class NumberStringAndWord {
    class Solution{
        public int solution(String s){
            String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for(int i =0; i < words.length; i++){
                s = s.replaceAll(words[i], String.valueOf(i));
                // String -> valueOf 랑 toString 메소드 사용법
                // 두 메소드 모두 Object를 String 형태로 만들어준다.
                // toString은 NPE를 발생하고 valueOf는 NULL을 반환한다.
            }
            return Integer.parseInt(s);
            // Integer -> parseInt 사용법 : String 타입의 문자열을 숫자로 변환시켜준다.
        }
    }

    public static void main(String[] args) {

    }
}

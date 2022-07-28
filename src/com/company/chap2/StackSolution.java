package com.company.chap2;

import com.company.dataStructure.Stack;

public class StackSolution {

    public String solution(String p){
        if(p.isEmpty()) return p;

        String answer = "";
        return answer;
    }

    boolean isCorrect(String str){
        boolean ret = true;
        int left = 0, right = 0;
        Stack<Character> myStack = new Stack<>();

        for(int i=0; i<str.length(); ++i){
            if(str.charAt(i) == '('){
                left++;
                myStack.push('(');
            } else {
                right++;
                if(myStack.empty())
            }
        }
    }
}

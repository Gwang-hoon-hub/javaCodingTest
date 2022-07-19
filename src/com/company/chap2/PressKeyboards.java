package com.company.chap2;

// 키패드 누르기
// https://school.programmers.co.kr/learn/courses/30/lessons/67256
public class PressKeyboards {
    Position left;
    Position right;
    Position numPos;

    class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";

            // 1. 왼손, 오른손 위치를 초기화한다.
            left = new Position(3,0);
            right = new Position(3,2);


            for (int num : numbers){
                // 2. 숫자를 누를 손가락을 정하기
                // 행과 열에 맞는 수를 구하기 위한 하나의 규칙을 찾아내서 해당 식을 넣는다.
                numPos = new Position((num - 1) / 3, (num - 1) % 3);
                if(num == 0)
                    numPos = new Position(3,1);
                String finger = numPos.getFinger(hand);

                // 3. 정해진 손가락을 answer에 답고 손가락 위치 이동
                answer += finger;
                if(finger.equals("L"))
                    left = numPos;
                else
                    right = numPos;

            }

            return answer;
        }
    }
    class Position{
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right") ? "R" : "L";

            if(this.col == 0) finger = "L";
            else if(this.col == 2) finger = "R";
            else{
                int leftDist = left.getDistance(this);
                int rightDist = right.getDistance(this);

                if(leftDist < rightDist)
                    finger = "L";
                else if(rightDist < leftDist)
                    finger = "R";

            }
            return finger;
        }

        private int getDistance(Position position) {
            return Math.abs(this.row - position.row) + Math.abs(this.col - position.col);
        }

    }


}

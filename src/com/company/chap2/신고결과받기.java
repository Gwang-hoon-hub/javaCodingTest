package com.company.chap2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {
}

public class Solution{
    public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];

        // 1. 신고에 대한 중복 제거 --> set 자료구조 사용으로 중복제거
        HashSet<String> reportSet = new HashSet<String>();
        for(String rep : report)
            reportSet.add(rep);

        // 2. notifyListHash 만들기 (신고에 따른 유저정보 hash 만들기)
        HashMap<String, ArrayList<String>> notifyHash = new HashMap<>();
        for(String rep : report){
            // 신고를 한 사람과 신고를 당한사람을 parsing 한다.
            int blankIdx = rep.indexOf(" ");
            String reporter = rep.substring(0, blankIdx);
            String reportee = rep.substring(blankIdx+1);

            // notifyHash 에서 reportee가 있다면 해당 배열을 갖고 오고 그렇지 않으면 null을 갖고온다.
            ArrayList<String> reporterList = notifyHash.getOrDefault(reportee,null);
            if(reporterList == null)
                reporterList = new ArrayList<>();
            reporterList.add(reporter);
            notifyHash.put(reportee, reporterList);

        }

        // 3. notifyListHash를 기반으로 이메일을 보낼 reportHash 만들기
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for(ArrayList<String> notifyList : notifyHash.values())
            if(notifyList.size() >= k)
                for(String reporter : notifyList)
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);

        // 4. reportHash 를 기반으로 answer 배열을 채우기
        for(int i =0; i<id_list.length; i++)
            answer[i] = reporterHash.getOrDefault(id_list[i],0);
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] id_list = {"con", "ryan"};
//        String[] reprot = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String[] reprot = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        sol.solution(id_list, reprot, k);
    }
}


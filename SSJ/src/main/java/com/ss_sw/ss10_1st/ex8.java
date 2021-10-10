package com.ss_sw.ss10_1st;

import java.util.*;

class ex8 {

    public int balancedIndex(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count += 1;
            else count -= 1;
            if (count == 0) return i;
        }
        return -1;
    }

    public boolean checkProper(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count += 1;
            else {
                if (count == 0) {
                    return false;
                }
                count -= 1;
            }
        }
        return true;
    }
    
    public String solution(String p) {
        String answer = "";
        if (p.equals("")) return answer;
        int index = balancedIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        if (checkProper(u)) {
            answer = u + solution(v);
        } else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1); // 첫 번째와 마지막 문자를 제거
            String temp = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') temp += ")";
                else temp += "(";
            }
            answer += temp;
        }
        return answer;
    }
}
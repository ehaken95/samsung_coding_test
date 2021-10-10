package com.ss_sw.ss10_1st;
import java.util.*;

public class ex1 {
    public static String str;
    public static int summary = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        // 왼쪽
        for (int i = 0; i < str.length() / 2; i++) {
            summary += str.charAt(i) - '0';
        }

        // 오른
        for (int i = str.length() / 2; i < str.length(); i++) {
            summary -= str.charAt(i) - '0';
        }

        
        if (summary == 0) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}

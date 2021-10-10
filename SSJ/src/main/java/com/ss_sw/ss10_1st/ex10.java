package com.ss_sw.ss10_1st;
import java.util.*;

class Main {
    public static int n = 1000; // 2부터 1,000까지 소수 판별
    public static boolean[] arr = new boolean[n + 1];

    public static void main(String[] args) {
        Arrays.fill(arr, true); // 처음엔 모든 수가 소수(True)
        // 에라토스테네스의 체 알고리즘 수행

        // 2부터 n의 제곱근까지의 모든 수를 확인
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // i가 소수
            if (arr[i] == true) {
                // i 배수 지우기
                int j = 2;
                while (i * j <= n) {
                    arr[i * j] = false;
                    j += 1;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (arr[i]) System.out.print(i + " ");
        }
    }
}
package com.ss_sw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class sol7{
    public int solution(String[] order_times, int k){
        int answer = 0;
        SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);

        int time[] = new int[order_times.length-1];


        for(int i=0;i<order_times.length-1;i++){

            Date d1 = null;
            try {
                d1 = f.parse(order_times[i]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date d2 = null;
            try {
                d2 = f.parse(order_times[i+1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long diff = d2.getTime()  - d1.getTime();
            long sec = diff/1000;
            int min = (int)sec / 60;

            time[i]= min;
        }
        for(int i=0;i<time.length;i++){

            int sum = 0;
            int cnt = 0;
            while(true){
                if(sum > k){
                    break;
                }
                if(i+cnt < time.length && sum + time[i + cnt]<=k) {
                    sum += time[i + cnt];
                    cnt ++;
                }else{
                    break;
                }
            }
            if(answer<cnt) {
                answer = cnt;
            }
        }
        answer++;

        System.out.println(answer);

        return answer;
    }
}

public class ex7 {
    public static void main(String[] args) {
        String[] order_times = {"10:10", "12:20", "12:40", "12:40", "12:50", "13:00", "13:20"};
        int k = 20;


        sol7 sol = new sol7();
        sol.solution(order_times,k);

    }
}
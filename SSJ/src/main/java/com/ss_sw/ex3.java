package com.ss_sw;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ex3 {
    public static void main(String[] args){
        int[] ball = {11, 2, 9, 13, 24};
        int[] order = {9, 2, 13, 24, 11};
        int[] result = new int[ball.length];

        Queue tmp = new LinkedList();
        Queue rst = new LinkedList();
        Deque q = new LinkedList();
        for(int i=0;i<ball.length;i++){
            q.offerLast(ball[i]);
        }
        while (!q.isEmpty()){
            for(int i=0;i<ball.length;i++){
                if(order[i] != 0){
                    if(q.peekFirst().equals(order[i])){

                        q.pollFirst();
                        rst.offer(order[i]);
                        order[i] = 0;
                    }else if(q.peekLast().equals(order[i])) {
                        q.pollLast();
                        rst.offer(order[i]);
                        order[i] = 0;
                    }else{
                        tmp.offer(order[i]);
                    }

                    if(!tmp.isEmpty()){
                        int ispoll = 1;
                        while(ispoll==1) {
                            int tsize = tmp.size();
                            if(tsize == 0){
                                break;
                            }
                            for (int j = 0; j < tsize; j++) {
                                int tdata = (int) tmp.poll();

                                if (q.peekFirst().equals(tdata)) {
                                    q.pollFirst();
                                    rst.offer(tdata);
                                    ispoll=1;
                                } else if (q.peekLast().equals(tdata)) {
                                    q.pollLast();
                                    rst.offer(tdata);
                                    ispoll=1;
                                } else {
                                    tmp.offer(tdata);
                                    ispoll=0;
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<ball.length;i++){
            result[i] = (int)rst.poll();
        }
        for(int i=0;i<ball.length;i++){
            System.out.println(result[i]);
        }
    }
}

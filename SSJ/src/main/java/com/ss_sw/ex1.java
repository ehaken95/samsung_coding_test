package com.ss_sw;

import java.util.Scanner;

public class ex1 {
    //윷놀이 판 번호가 동일한곳이 있음. 숫자 임의로 변경해야 함.
    //변경된 숫자는 score를 바꿔서 저장함
    private static class Node {     //윷놀이 판을 연결리스트 구조에 담음
        int score, blue, red;
        boolean isBlue = false;//파란색 발판여부

        Node(int score, int red){
            this.score = score;
            this.red = red;
        }
    }
    private static int finScore = 0, turn[], step[], now[];
    private static boolean[] isexist;
    private static Node[] map;

    private static void turn(int x, int y){
        if (x==y){
            now = new int[4];
            isexist = new boolean[43];
            move();
            return;
        }
        for(int i=0;i<4;i++){
            turn[y] = i;
            turn(x,y+1);
            turn[y] = -1;
        }
    }
    private static void move(){
        int score = 0;
        for (int i=0;i<10;i++){
            int end = horsepos(turn[i], step[i]);
            if(end == -1) return;
            now[turn[i]] = end;
            score += map[end].score;
        }
        if(finScore<score) finScore = score;
    }
    private static int horsepos(int horse, int step){
        int temp = now[horse];

        for(int i=0;i<step;i++){
            if(i==0 && map[temp].isBlue){
                temp = map[temp].blue;
                continue;
            }
            temp = map[temp].red;
        }
        if(temp <=40 && isexist[temp]){
            return -1;
        }else{
            isexist[now[horse]] = false;
            isexist[temp] = true;
            return temp;
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        map = new Node[43];
        turn = new int[10];

        step = new int[10];
        for(int i=0;i<10;i++){
            String s = sc.next();
            step[i] = Integer.parseInt(s);
        }

        for(int i=0;i<=40;i+=2){
            map[i] = new Node(i,i+2);
        }

        map[10].blue = 11;
        map[20].blue = 17;
        map[30].blue = 31;
        map[10].isBlue = true;
        map[20].isBlue = true;
        map[30].isBlue = true;

        map[11] = new Node(13,13);
        map[13] = new Node(16,15);
        map[15] = new Node(19,25);
        map[17] = new Node(22,19);
        map[19] = new Node(24,25);
        map[25] = new Node(25,37);
        map[31] = new Node(28,33);
        map[33] = new Node(27,35);
        map[35] = new Node(26,25);
        map[37] = new Node(30,39);
        map[39] = new Node(35,40);
        map[42] = new Node(0,42);

        turn[0] = 0;
        turn(9,0);
        System.out.println(finScore);
        sc.close();
    }
}
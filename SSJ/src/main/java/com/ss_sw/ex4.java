package com.ss_sw;

class sol4{

    public double getDist(int x,int y,int a, int b){
        return Math.sqrt(Math.pow(Math.abs(a-x),2) + Math.pow(Math.abs(b-y),2));
    }//xy가 00

    public int solution(int[] target, int[][] positions){
        int sum=0;
        int a = target[0];
        int b = a+target[1];
        int c = b+target[2];
        int d = c+target[3];
        int e = d+target[4];

        for(int i=0;i<10;i++){
            double dist = getDist(0,0,positions[i][0],positions[i][1]);

            if(dist<=a){
                sum+=10;
            }else if(a<dist && dist<=b){
                sum+=8;
            }else if(b<dist && dist<=c){
                sum+=6;
            }else if(c<dist && dist<=d){
                sum+=4;
            }else if(d<dist && dist<=e){
                sum+=2;
            }else{
                sum+=0;
            }
        }

        System.out.println(sum);

        return sum;
    }
}


public class ex4 {
    public static void main(String[] args) {
        int[] target = {2, 2, 2, 2, 2};
        int[][] positions = {{0, 0}, {0, 1}, {1, 1}, {-3, 5}, {7,5}, {10, 0}, {-15, 22}, {-6, -5}, {3, 3}, {5, -5}};
        sol4 sol = new sol4();
        sol.solution(target,positions);


    }
}

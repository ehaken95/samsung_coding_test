package com.ss_sw;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ex_19_2_17822 {

    static int N;
    static int M;
    static int T;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());//T번 회전
        map = new int [N+1][M];//n은 배수찾기 편하도록
        //n 0은 원판 회전시 복사용

        //map setting
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());//x의 배수번째 원판 회전
            int D = Integer.parseInt(st.nextToken());//0:시계 1:반시계
            int K = Integer.parseInt(st.nextToken());//k칸 회전

            switch(D){
                case 0:
                    for(int x = X; x<=N; x+=X){
                        for(int k = 0; k<K; k++){
                            //>>방향
                            int temp = 0;
                            temp = map [x][M-1];
                            for(int j=M-1;j>0;j--){
                                map[x][j]=map[x][j-1];
                            }
                            map[x][0]=temp;
                        }
                    }
                break;
                case 1:
                    for(int x = X; x<=N; x+=X){
                        for(int k = 0; k<K; k++){
                            //<<방향
                            int temp = 0;
                            temp = map [x][0];
                            for(int j=0;j<M-1;j++){
                                map[x][j]=map[x][j+1];
                            }
                            map[x][M-1]=temp;
                        }
                    }
                break;
            }
            int[][] map2 = new int[N+1][M];
            for(int q = 1;q<=N;q++) {
                System.arraycopy(map[q],0,map2[q],0,M);
            }

            /*for(int q=1; q<=N; q++){
                for(int w=0; w<M;w++){
                    System.out.print(map[q][w]+" ");
                }
                System.out.println();
            } */
            System.out.println();
            //인접한 숫자 지우기&&없으면 평균구하기
            boolean issame = false;
            for(int x=1;x<=N;x++){
                for(int y=0;y<M;y++){
                    int tempar = map[x][y];
                    
                    if(tempar != 0){
                        
                        //상
                        if(x<N && map[x+1][y]==tempar){
                            map2[x+1][y]=0;
                            map2[x][y]=0;
                            issame = true;
                        }
                        //하
                        if(x>1 && map[x-1][y]==tempar){
                            map2[x-1][y]=0;
                            map2[x][y]=0;
                            issame = true;
                        }
                        //좌
                        if(y>0 && map[x][y-1]==tempar){
                            map2[x][y-1]=0;
                            map2[x][y]=0;
                            issame = true;
                        }
                        //우
                        if(y<M-1 && map[x][y+1]==tempar){
                            map2[x][y+1]=0;
                            map2[x][y]=0;
                            issame = true;
                        }
                        //양끝
                        if(y==0 && map[x][M-1]==tempar){
                            map2[x][M-1]=0;
                            map2[x][y]=0;
                            issame = true;
                        }
                        if(y==M-1 && map[x][0]==tempar){
                            map2[x][0]=0;
                            map2[x][y]=0;
                            issame = true;
                        }
                    }
                }
            }
            map = map2;
            /* for(int q=1; q<=N; q++){
                for(int w=0; w<M;w++){
                    System.out.print(map[q][w]+" ");
                }
                System.out.println();
            } */
            //평균
            if(!issame){
                int sum = 0;
                int cnt = 0;
                
                for(int x=1;x<=N;x++){
                    for(int y=0;y<M;y++){
                        if(map[x][y]!=0){
                            sum += map[x][y];
                            cnt ++;
                        }
                    }
                }
                double avg = (float)sum/(float)cnt;
                for(int x =1; x<=N; x++) { 
                    for(int y =0; y<M;y++) {
                        if(map[x][y]==0)continue;
                        else if(map[x][y]<avg)map[x][y]++;
                        else if(map[x][y]>avg)map[x][y]--;
                    }
                }

            }
        }
        int ans = 0;
        for(int i=1; i<=N; i++){
            for(int j=0; j<M;j++){
                ans += map[i][j];
            }
        }
        System.out.println(ans);

        
       

    }

    
}

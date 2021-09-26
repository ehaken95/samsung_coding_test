package com.ss_sw;

class sol5 {
    private int node;//노드 개수
    private int air[][];
    private int mile[][];


    public int[] solution(int n, int k, int[][] paths) {
        int[] answer = {};

        this.node = n;
        air = new int[node+1][node+1];
        mile = new int[node+1][node+1];

        for(int i=0;i<paths.length;i++){
            air[paths[i][0] ] [paths[i][1]] = paths[i][2];
            air[paths[i][1] ] [paths[i][0]] = paths[i][2];

            mile[paths[i][0] ] [paths[i][1]] = paths[i][3];
            mile[paths[i][1] ] [paths[i][0]] = paths[i][3];
        }

        int dist[] = new int[node+1];
        int milesum[] = new int[node +1];

        boolean[] chk = new boolean[node+1];

        for(int i=1;i<n+1;i++){
            dist[i] = 9999;
        }
        //milesum[1]=9999;
        dist[1]=0;
        chk[1] = true;

        for(int i=1;i<n+1;i++){
            if(!chk[i] && air[1][i] != 0){
                dist[i] = air[1][i];
                milesum[i] = mile[1][i];
            }
        }

        for(int j=0;j<n-1;j++){
            int min = 9999;
            int min_index = -1;


            for(int i=1;i<n+1;i++){
                if(!chk[i] && dist[i]!=9999){
                    if(dist[i]<min){
                        min=dist[i];
                        min_index=i;

                    }
                }
            }

            chk[min_index] = true;
            for(int i=1;i<n+1;i++){
                if(!chk[i] && air[min_index][i]!=0){
                    if(dist[i]>dist[min_index]+air[min_index][i]    ){
                        dist[i] = dist[min_index]+air[min_index][i];
                        milesum[i] = milesum[min_index]+mile[min_index][i];
                    }
                }
            }
        }

        for(int i=1;i<n+1;i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
        for(int i=1;i<n+1;i++){
            System.out.print(milesum[i] + " ");
        }
        return answer;
    }

}


public class ex5 {
    public static void main(String[] args) {
        int n = 5;//점의 개수
        int k = 4;//목적지
        int[][] paths = {{1,5,1,1},{1,2,4,3},{1,3,3,2},{2,5,2,1},{2,4,2,3},{3,4,2,2}};
        //마지막이 마일리지임
        //path개수는 path.length, 간선개수임임

        sol5 sol = new sol5();
       sol.solution(n,k,paths);

    }



}

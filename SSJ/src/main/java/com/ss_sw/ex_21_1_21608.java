package com.ss_sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class ex_21_1_21608 {

    static int N;
    static int[][] map, nearEmptySeatCnt;
    static int[] dx = {-1,1,0,0};//인접 거리계산용
    static int[] dy = {0,0,-1,1};
    static Map<Integer, Student> list = new HashMap<>();

    static class Student{// 좋아하는 친구 저장 class
        int x;
        int y;
        int[] like_list;

        public Student(int x, int y, int[] like_list){
            this.x = x;
            this.y = y;
            this.like_list = like_list;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        //Scanner sc = new Scanner(System.in);
        //N = Integer.parseInt(sc.nextLine());
        
        N = Integer.valueOf(br.readLine());
        map = new int [N][N];
        int answer = 0;
        fillNearEmptySeat();

        for(int i=0; i<N*N ; i++){
            /* int snum = Integer.parseInt(sc.next());
            int f1 = Integer.parseInt(sc.next());
            int f2 = Integer.parseInt(sc.next());
            int f3 = Integer.parseInt(sc.next());
            int f4 = Integer.parseInt(sc.next()); */

            st = new StringTokenizer(br.readLine(), " ");
			int snum = Integer.valueOf(st.nextToken());
			int f1 = Integer.valueOf(st.nextToken());
			int f2 = Integer.valueOf(st.nextToken());
			int f3 = Integer.valueOf(st.nextToken());
			int f4 = Integer.valueOf(st.nextToken());
            
            int[] n4list = new int[] {f1,f2,f3,f4};
            findSeat(snum, n4list);
        }

        for(int i=1; i<=N*N; i++) {
            Student student = list.get(i);
            int cnt = 0;
            for(int friend : student.like_list) {
                if(Math.abs(list.get(friend).x -student.x) + Math.abs(list.get(friend).y - student.y) == 1) {
                    cnt++;
                }
            }

            if(cnt==1) answer+=1;
            else if(cnt==2) answer+=10;
            else if(cnt==3) answer+=100;
            else if(cnt==4) answer+=1000;
        }

        System.out.println(answer);
        //sc.close();
    }

    private static void findSeat(int num, int[] friends) {
        int[][] nearfrend = new int[N][N]; //4방향 친한 친구 찾기
        for(int friend : friends) {
            if(list.containsKey(friend)) {
                Student student = list.get(friend);
                int x = student.x;
                int y = student.y;

                for(int i=0; i<4; i++) {
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(nx>=0 && nx <N && ny >=0 && ny < N && map[nx][ny] == 0) {
                        nearfrend[nx][ny]++;
                    }
                }
            }
        }

        int emptyCntMax = -1;
        int nearScoreMax = -1;
        int choiceX = -1;
        int choiceY = -1;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != 0) continue;
                if(nearScoreMax < nearfrend[i][j]) {
                    choiceX = i;
                    choiceY = j;
                    nearScoreMax = nearfrend[i][j];
                    emptyCntMax = nearEmptySeatCnt[i][j];
                } else if(nearScoreMax == nearfrend[i][j] && emptyCntMax < nearEmptySeatCnt[i][j]) {
                    emptyCntMax = nearEmptySeatCnt[i][j];
                    choiceX = i;
                    choiceY = j;
                }
            }
        }

        map[choiceX][choiceY] = num;
        list.put(num, new Student(choiceX,choiceY, friends));

        for(int i=0; i<4; i++) {
            int nx = choiceX+dx[i];
            int ny = choiceY+dy[i];
            if(nx>=0 && nx <N && ny >=0 && ny < N && map[nx][ny] == 0) {
                nearEmptySeatCnt[nx][ny]--;
            }
        }
    }
    private static void fillNearEmptySeat() {
        nearEmptySeatCnt = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int cnt = 4;
                if(i==0 || i==N-1) cnt--;
                if(j==0 || j==N-1) cnt--;
                nearEmptySeatCnt[i][j] = cnt;
            }
        }
    }
}

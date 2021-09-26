package com.ss_sw;


class sol6{
    public int solution(int[] vote){
        if(vote.length==2){
            return 0;
        }

        int answer = 0;

        for(int i=0;i<vote.length;i++){
            if(vote[i]!=0){
                if(vote[vote[i]-1]!=0){
                    if(vote[vote[vote[i]-1]-1]!=0 && i+1==vote[vote[vote[i]-1]-1]){
                        answer++;
                        vote[i]=0;
                        vote[vote[i]]=0;
                        vote[vote[vote[i]]]=0;
                    }
                }
            }
        }

        System.out.println(answer);


        return answer;
    }



}
public class ex6 {
    public static void main(String[] args) {
        int vote[] = {5,4,2,3,1};


        sol6 sol = new sol6();
        sol.solution(vote);

    }
}

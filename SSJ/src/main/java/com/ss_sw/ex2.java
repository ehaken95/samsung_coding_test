package com.ss_sw;

public class ex2 {
    public static void main(String[] args){
        int n = 73425;
        int[] splitn = new int[(int)Math.log10(n)+1];
        int[] answer = new int[2];
        String strint = String.valueOf(n);
        for(int i=0;i<splitn.length;i++){
            splitn[i] = strint.charAt(i)-'0';
        }
        int sum = 0;
        for(int i=0;i<splitn.length;i++){
            sum = sum + splitn[i];
            if(sum>=10) {
                sum = sum % 10 + sum / 10;
            }
        }

        int result=n;
        int cnt = 0;
        int new_n;
        while (result > 10) {
            int hsplitn = splitn.length/2;
            if(splitn.length%2!=0){
                int sum1 = 0;
                int sum2 = 0;

                while(splitn[hsplitn]==0){
                    hsplitn++;
                }
                for(int i=0;i<hsplitn;i++){
                    sum1 = sum1*10 + splitn[i];
                }
                for(int i=hsplitn;i<splitn.length;i++){
                    sum2 = sum2*10 + splitn[i];
                }
                new_n = sum1+sum2;
                int[] splitnewn = new int[(int)Math.log10(new_n)+1];
                String splitnewnint = String.valueOf(new_n);
                for(int i=0;i<splitnewn.length;i++){
                    splitnewn[i] = splitnewnint.charAt(i)-'0';
                }
                splitn = splitnewn;
                cnt ++;
                result = new_n;
            }else{
                int sum1 = 0;
                int sum2 = 0;
                while(splitn[hsplitn]==0){
                    hsplitn++;
                }
                for(int i=0;i<hsplitn;i++){
                    sum1 = sum1*10 + splitn[i];
                }
                for(int i=hsplitn;i<splitn.length;i++){
                    sum2 = sum2*10 + splitn[i];
                }
                new_n = sum1+sum2;
                int[] splitnewn = new int[(int)Math.log10(new_n)+1];
                String splitnewnint = String.valueOf(new_n);
                for(int i=0;i<splitnewn.length;i++){
                    splitnewn[i] = splitnewnint.charAt(i)-'0';
                }
                splitn = splitnewn;
                cnt ++;
                result = new_n;
            }
        }

    }
}

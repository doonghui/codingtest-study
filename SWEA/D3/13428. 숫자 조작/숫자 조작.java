import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1;t<=T;t++) {
            String str =br.readLine();

            if(str.length() == 1) {

                bw.write("#"+t+" "+str+" "+str+"\n");
                continue;
            }

            int num =0;
            // max 구하기
            boolean flag = false;
            String max = "";
            for(int i =0;i<str.length();i++) {
                num = str.charAt(i) - '0';
                int maxIdx = i;
                for(int j =str.length()-1;j>=i+1;j--) {

                    if(num < str.charAt(j) - '0' && str.charAt(j)-'0' > str.charAt(maxIdx)-'0') {
                        maxIdx = j ;
                        flag = true;

                    }
                }
                if(flag){
                    max += str.substring(0,i);
                    max += String.valueOf(str.charAt(maxIdx));
                    max += str.substring(i+1,maxIdx);
                    max += String.valueOf(str.charAt(i));
                    max += str.substring(maxIdx+1,str.length());

                    break;}
            }

            if(!flag) max = str;

            // 최소 구하기
            flag = false;
            String min = "";
            for(int i =0;i<str.length();i++) {
                num = str.charAt(i) - '0';
                int minIdx = i;
                for(int j =str.length()-1;j>=i+1;j--) {

                    if(num > str.charAt(j) - '0' && str.charAt(j)-'0' <str.charAt(minIdx)-'0' ) {
                        if(i == 0 && str.charAt(j)-'0' == 0) continue;
                        minIdx = j;

                        flag = true;
                    }


                }
                if(flag){
                    min += str.substring(0,i);
                    min += String.valueOf(str.charAt(minIdx));
                    min += str.substring(i+1,minIdx);
                    min += String.valueOf(str.charAt(i));
                    min += str.substring(minIdx+1,str.length());



                    break;}
            }

            if(!flag) min = str;


            bw.write("#"+t+" "+min+" "+max+"\n");



        }
        bw.flush();
        br.close();
        bw.close();

    }
}
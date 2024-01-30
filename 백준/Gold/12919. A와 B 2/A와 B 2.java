import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

class Main {

    static String S, T;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        S = br.readLine();
        T = br.readLine();

        if (S.length() > T.length()) bw.write("0");
        else if (S.equals(T)) bw.write("1");
        else {
            change(S.length(), T.length(),T);
            if(flag) bw.write("1");
            else
                bw.write("0");


        }


        br.close();
        bw.flush();
        br.close();
    }

    static void change(int sLen,int tLen,String t) {
        if(flag) return;
        if (tLen == sLen) {
            if (t.equals(S)) {
                flag = true;
                return;
            }

            return;
        }


            if(t.charAt(t.length()-1) == 'A') {
                change(sLen,tLen-1, t.substring(0,t.length()-1));
            }

            if(t.charAt(0) == 'B') {
                t = t.substring(1);
               String tmp = "";
               for(int k = t.length()-1;k>=0;k--) {
                   tmp += t.charAt(k);
               }
                t = tmp;
                change(sLen,tLen-1,t);
            }

    }


}

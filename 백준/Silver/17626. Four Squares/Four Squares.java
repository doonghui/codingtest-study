import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static int[] dp;
    static int n, m;
    static int cnt = 4;
    static int sum = 0;

    static void Sol(int L,int end) {
        if(cnt == end)
            return;
        if(L == end) {
            if(sum == n)
                cnt = end;
            return;
        }

        for(int i = m;i>=1;i--) {
            sum += Math.pow(i,2);
            Sol(L+1,end);
            sum -= Math.pow(i,2);
        }


    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        m = (int) Math.sqrt(n);
        dp = new int[5];
        for(int i=1; i<4;i++) {
            Sol(0,i);
            if(cnt == i)
                break;
        }
        if(cnt == 4)
            bw.write(cnt+" ");
        else
            bw.write(cnt+" ");

        br.close();
        bw.flush();
        bw.close();
    }
}



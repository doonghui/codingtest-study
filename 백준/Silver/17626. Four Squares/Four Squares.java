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
    static int min;

    static void Sol(int i) {


        for(int j =1;j*j <= i;j++) {
            int tmp = i - j*j;
            min = Math.min(dp[tmp],min);
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n;i++) {
            min = Integer.MAX_VALUE;
            Sol(i);
            dp[i] = min +1;
        }


        bw.write(dp[n]+" ");
        br.close();
        bw.flush();
        bw.close();
    }
}



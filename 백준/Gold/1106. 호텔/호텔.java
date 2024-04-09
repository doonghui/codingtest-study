import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int C, N;
    static int[] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[C + 101];

        Arrays.fill(dp, 100000000);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            for (int j = p; j < C + 101; j++) {             // 최소 C명이니깐 최대 C+100명까지
                dp[j] = Math.min(dp[j], dp[j - p] + m);
            }

        }

        int min = Integer.MAX_VALUE;
        for (int person = C; person < C + 101; person++) {
            min = Math.min(min, dp[person]);
        }


        bw.write(min + "");
        bw.flush();
        bw.close();
    }


}



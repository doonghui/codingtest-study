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
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            for (int j = person; j < C + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j - person] + money);

            }
        }


        int max = Integer.MAX_VALUE;
        for (int k = C; k < C + 101; k++) {
            max = Math.min(max, dp[k]);
        }


        br.close();
        bw.write(max + "");
        bw.flush();
        bw.close();
    }


}



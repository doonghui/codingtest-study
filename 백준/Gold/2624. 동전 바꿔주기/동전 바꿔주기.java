import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int T, N;
    static char[] cn, cm;
    static int[] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());


        dp = new int[T + 1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int money = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for (int j = T; j >= money; j--) {
                for (int n = 1; n <= num; n++) {
                    if (j - money * n < 0) break;
                    dp[j] = dp[j] + dp[j - money * n];
                }
            }


        }

        bw.write(dp[T] + "");
        bw.flush();
        bw.close();
    }
}
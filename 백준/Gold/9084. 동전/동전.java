import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int T, N, M;
    static int[][] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[10001];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
//                dp[arr[j]] = 1;
            }
            int money = Integer.parseInt(br.readLine());

            dp[0] = 1;


            for (int x = 0; x < N; x++) {
                for (int k = arr[x]; k <= money; k++) {
                    dp[k] += dp[k - arr[x]];

                }
            }


            bw.write(dp[money] + "\n");


        }


        bw.flush();
        bw.close();
    }


}



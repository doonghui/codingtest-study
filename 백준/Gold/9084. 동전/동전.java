import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int total = Integer.parseInt(br.readLine());

            int[] dp = new int[total+1];

            for(int coin : coins) {
                for(int i = coin; i<=total; i++) {
                    dp[i] = dp[i] + dp[i-coin];
                    if (i == coin) {
                        dp[i] += 1;
                    }
                }
            }

            System.out.println(dp[total]);
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int N, K;
    static long[] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new long[10001];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        // 83%에서 틀림 뭐지?
//        Arrays.sort(arr);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 0; j < N; j++) {

            for (int x = arr[j]; x <= K; x++) {
                dp[x] = Math.min(dp[x], dp[x - arr[j]] + 1);
            }


        }


        br.close();
        if (dp[K] == Integer.MAX_VALUE) bw.write("-1");
        else
            bw.write(dp[K] + "");
        bw.flush();
        bw.close();
    }


}



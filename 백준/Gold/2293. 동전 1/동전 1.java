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
        // 1 -> 1: 1
        // 2 -> 2 :11 2
        // 3 -> 2 : 111 , 12
        // 4 -> 3:  1111, 112, 22
        // 5 -> 4 :11111, 1112, 221, 5
        // 6 -> 5 : 111111, 11112, 222, 2211, 51
        dp[0] = 1;
        for (int j = 0; j < N; j++) {

            for (int x = arr[j]; x <= K; x++) {
                dp[x] += dp[x - arr[j]];
            }


        }


        br.close();
        bw.write(dp[K] + "");
        bw.flush();
        bw.close();
    }


}



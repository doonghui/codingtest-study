import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int N;
    static int[] arr;
    static long[] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        if (N == 2) {
            dp[1] = arr[0] + arr[1];
        } else if(N == 3) {
          dp[1] = arr[0] + arr[1];
          dp[2] = Math.max(arr[0],arr[1]) + arr[2];
          dp[2] = Math.max(dp[1],dp[2]);
        } else if(N > 3){
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max(arr[0],arr[1]) + arr[2];
            dp[2] = Math.max(dp[1],dp[2]);
            for (int j = 3; j < N; j++) {
                dp[j] = Math.max(dp[j - 2], arr[j - 1] + dp[j - 3]) + arr[j];       // 포도주 먹을 때
                dp[j] = Math.max(dp[j],dp[j-1]);                                    // 포도주 안먹었을 때랑 한번더 비교
            }
        }


        bw.write(dp[N - 1] + "");
        bw.flush();
        bw.close();
    }


}



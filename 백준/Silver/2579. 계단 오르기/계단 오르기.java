import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
        dp[1] = arr[1];
        if (N > 1) {
            dp[2] = arr[1] + arr[2];
            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];
            }
        }

        bw.write(dp[N] + "");
        br.close();
        bw.flush();
        bw.close();
    }


}

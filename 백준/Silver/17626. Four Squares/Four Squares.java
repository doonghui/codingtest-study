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

        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int num = i - j * j;
                min = Math.min(dp[num], min);
            }
            dp[i] = min + 1;
        }

        bw.write(dp[N] + "");
        br.close();
        bw.flush();
        bw.close();
    }


}

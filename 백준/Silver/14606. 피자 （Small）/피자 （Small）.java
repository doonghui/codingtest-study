import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[] dp;

    static int Sol(int n) {
        if (dp[n] != 0) return 1;
        if (n == 1) return dp[n] = 0;
        else if (n == 2) return dp[n] = 1;

        return dp[n] = Sol(n - 1) + (n - 1);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];


        Sol(n);
        br.close();
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}
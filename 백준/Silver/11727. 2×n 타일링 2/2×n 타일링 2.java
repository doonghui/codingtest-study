import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static long[] dp;

    static long Sol(int n) {
        if (dp[n] != 0) return dp[n];
        if (n == 1) return dp[n] = 1;
        if (n == 2) return dp[n] = 3;

        return dp[n] =( Sol(n - 1) + Sol(n - 2) * 2)%10007;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        dp = new long[1001];

//        for (int i = 0; i < n; i++) {
//            int k = Integer.parseInt(br.readLine());
//        }

        br.close();
        bw.write(Sol(n)+"");
        bw.flush();
        bw.close();
    }
}



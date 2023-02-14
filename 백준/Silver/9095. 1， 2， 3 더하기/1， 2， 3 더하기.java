import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] dp;
    static int[] ch;

    static int Sol(int n) {
        if(n == 1) return dp[n] = 1;
        if(n == 2) return dp[n] = 2;
        if(n == 3) return dp[n] = 4;

        return dp[n] = Sol(n-1) + Sol(n-2) + Sol(n-3);
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            bw.write(Sol(k)+"\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
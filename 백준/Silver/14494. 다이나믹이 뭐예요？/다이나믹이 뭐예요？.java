import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger sol;


    static long[][] dp;
    static int n, m;
    static long tmp = 1000000007;

    static long Sol(int x, int y) {
        if (x < 1 || y < 1) return 0;
        if (dp[x][y] != 0) return dp[x][y];


        return dp[x][y] = (Sol(x - 1, y) + Sol(x, y - 1) + Sol(x - 1, y - 1))%tmp;


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new long[n + 1][m + 1];
        dp[1][1] = 1;



        bw.write( Sol(n, m) + "");
        br.close();
        bw.flush();
        bw.close();
    }
}



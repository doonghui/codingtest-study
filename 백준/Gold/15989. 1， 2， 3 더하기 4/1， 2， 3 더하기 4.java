import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
//        dp[4] = dp[1] + 3;
//        dp[5] = dp[2] + 3;
//        dp[6] = dp[3] + 4;
//        dp[7] = dp[4] + 4;
//        dp[8] = dp[5] + 5;
        int count = 0;
        int plus = 3;
        for (int i = 4; i < 10001; i++) {
            dp[i] = dp[i - 3] + plus;
            count++;
            if (count == 2) {
                count = 0;
                plus++;
            }
        }

        for (int j = 0; j < N; j++) {
            bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
        }


        br.close();
        bw.flush();
        br.close();
    }


}

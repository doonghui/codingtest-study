import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];
        dp[1] = 0;
        if(N == 1) bw.write(0+"");
        else {
            dp[2] = 2;
            for (int j = 3; j <= N; j++) {
                dp[j] = (dp[j-1] * 3) % 1000000009;
            }
            bw.write(dp[N]+"");

        }





    
        br.close();
        bw.flush();
        br.close();
    }


}

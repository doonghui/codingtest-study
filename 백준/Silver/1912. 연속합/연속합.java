import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static int N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = arr[i];
            if (dp[i - 1] > 0) dp[i] += dp[i - 1];

        }

        Arrays.sort(dp);


        bw.write(dp[N - 1] + "");
        br.close();
        bw.flush();
        bw.close();
    }


}


import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T,N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i =4;i<=10;i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }


        for(int j =0;j<T;j++) {
            N = Integer.parseInt(br.readLine());
            bw.write(dp[N]+"\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }


}

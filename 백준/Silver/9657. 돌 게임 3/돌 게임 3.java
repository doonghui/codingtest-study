import java.io.*;

public class Main {


    static int[] dp;
    static void Sol(int n) {
        if(n <6)
            return;

       for(int i = 6; i <=n;i++) {
           if(dp[i-1]+dp[i-3]+dp[i-4] <3)
               dp[i] = 1;
           else
               dp[i] = 0;
       }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;
        dp[5] = 1;

        Sol(n);
        if(dp[n] == 1)
            bw.write("SK");
        else
            bw.write("CY");
        br.close();
        bw.flush();
        bw.close();
    }
}



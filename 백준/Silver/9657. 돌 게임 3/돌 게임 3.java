import java.io.*;

public class Main {


    static boolean[] dp;
    static void Sol(int n) {
        if(n <6)
            return;

       for(int i = 6; i <=n;i++) {
           if(dp[i-1] && dp[i-3] && dp[i-4])
               dp[i] = false;
           else
               dp[i] = true;
       }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        dp[5] = true;

        Sol(n);
        if(dp[n])
            bw.write("SK");
        else
            bw.write("CY");
        br.close();
        bw.flush();
        bw.close();
    }
}



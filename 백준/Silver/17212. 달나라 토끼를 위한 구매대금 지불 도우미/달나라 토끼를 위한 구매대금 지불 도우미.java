import java.io.*;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] dp;
    static int[] money = {1,2,5,7};

    static int Sol(int n) {

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i =0;i<=n;i++) {
            for(int j=0;j<4;j++){
                if(i-money[j] < 0) continue;
                dp[i] = Math.min(dp[i],dp[i-money[j]]+1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];


        br.close();
        bw.write(Sol(n)+"");
        bw.flush();
        bw.close();





    }

        }
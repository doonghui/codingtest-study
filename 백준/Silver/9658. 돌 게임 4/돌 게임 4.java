import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int n;
    static boolean[] dp;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        // true : 상근 짐, false : 창영 짐
        dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = false;      // 3 1


        if(n > 4) {
            for(int i =5;i<=n;i++) {
                if(dp[i-1] || dp[i-3] || dp[i-4]) dp[i] = false;
                else
                    dp[i] = true;
            }
        }

        String ans = "";
        if(dp[n]) ans += "CY";
        else ans += "SK";



        bw.write(ans);
        br.close();
        bw.flush();
        bw.close();

    }





}
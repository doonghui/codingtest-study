import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n + 1];
        String ans = "";

//        if(n % 2 == 1) ans = "SK";
//        else
//            ans = "CY";

        dp[1] = true;
        for (int i = 3; i <= n; i++) {
            dp[i] = !dp[i - 1];
        }
        if (dp[n]) ans = "SK";
        else
            ans = "CY";


        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();


    }


}

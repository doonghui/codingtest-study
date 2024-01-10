import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;



        // 1 ~ 250
        BigInteger[] dp = new BigInteger[250 + 1];

        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for(int i = 3; i<= 250;i++) {
          dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
        }

        String str = "";
        while ((str = br.readLine()) !=null) {
            int n = Integer.parseInt(str);
            bw.write(dp[n] + "\n");
        }


        br.close();
        bw.flush();
        br.close();
    }



}

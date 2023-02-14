import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dp;
    static int[] ch;

    static void Sol(int n) {
        int min = ch[0];
        for (int i = 1; i < n; i++) {
            if (min > ch[i]) {
                min = ch[i];
            }
           dp[i] = Math.max(dp[i-1],ch[i] - min);
        }
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;


        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        ch = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i< n;i++)
            ch[i] = Integer.parseInt(st.nextToken());

        Sol(n);
        br.close();
        for(int x : dp){
            bw.write(x + " ");
        }
        bw.flush();
        bw.close();
    }
}
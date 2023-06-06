import java.io.*;
import java.util.*;



public class Main {
    static int n;
    static int[] arr;
    static int[] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for(int i = 1;i<n;i++) {
            dp[i] = Math.max(dp[i-1] + arr[i],arr[i]);
        }

        Arrays.sort(dp);



        br.close();
        bw.write(dp[n-1]+"");
        bw.flush();
        bw.close();


    }
}


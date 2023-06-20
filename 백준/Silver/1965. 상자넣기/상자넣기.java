import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int[] arr;
    static int[] dp;


    public static void Sol() {
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }

            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Sol();
        Arrays.sort(dp);




        br.close();
        bw.write(dp[n-1] + "");
        bw.flush();
        bw.close();


    }
}


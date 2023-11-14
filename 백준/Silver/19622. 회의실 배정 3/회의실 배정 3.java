import java.io.*;
import java.util.*;


class Main {


    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0][2];
        if(n >1) dp[1] = Math.max(dp[0],arr[1][2]);
        for (int j = 2; j < n; j++) {
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + arr[j][2]);
        }


        bw.write(dp[n - 1] + "");
        bw.flush();
        br.close();
        bw.close();

    }


}






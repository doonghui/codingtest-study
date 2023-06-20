import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int[][] arr;
    static int[][] dp;


    public static void Sol() {
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3;j++) {            // 현재 비교
                for(int k =0;k<3;k++){
                    if (k != j) {                   // 전의 집과 색이 같으면 안되니 같은 값은 제외
                        if(dp[i][j] == 0)
                            dp[i][j] = arr[i][j] + dp[i-1][k];
                        else if(arr[i][j] + dp[i-1][k] < dp[i][j]){
                            dp[i][j] = arr[i][j] + dp[i-1][k];
                        }
                    }


                    }


            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        Sol();
        Arrays.sort(dp[n-1]);


        br.close();
        bw.write(dp[n-1][0] + "");
        bw.flush();
        bw.close();


    }
}


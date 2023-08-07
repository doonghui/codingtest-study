import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Work {
    int day;
    int cost;

    public Work(int day, int cost) {
        this.day = day;
        this.cost = cost;
    }
}

public class Main {

    static int n;
    static int[] dp;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        Work[] date = new Work[n + 1];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            date[i] = new Work(a, b);
        }

        dp = new int[n + 2];

        sol(date);



        bw.write(dp[1] + "");
        br.close();
        bw.flush();
        bw.close();

    }

    static void sol(Work[] date) {

        for (int i = n; i >= 1; i--) {
            int tmp = i + date[i].day;          // i일 + i일차에 걸리는 기간

            if (tmp > n + 1) {
                dp[i] = dp[i + 1];

            } else {
                if (date[i].cost + dp[tmp] > dp[i + 1]) {
                    dp[i] = date[i].cost + dp[tmp];
                } else
                    dp[i] = dp[i + 1];
            }


        }

    }


}

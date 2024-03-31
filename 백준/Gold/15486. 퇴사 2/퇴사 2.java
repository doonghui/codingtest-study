import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.math.BigInteger;
        import java.util.*;

class Day {
    int date;
    int cost;

    public Day(int date,int cost) {
        this.date = date;
        this.cost = cost;
    }
}

public class Main {

    static int N;
    static int[] dp;
    static  ArrayList<Day> arr;
    static int max;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        arr = new ArrayList<>();
        max = 0;
        arr.add(new Day(0,0));     // 더미
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Day(a,b));
        }

//        if(arr.get(N).date + N == N+1) dp[N] = arr.get(N).cost;

        for(int i =N;i>=1;i--) solution(i);

        bw.write(max+"");
        bw.flush();
        bw.close();
    }

    // 1,6,8 = 50 + 10 + 30
    // 34퍼에서 틀림..
    static void solution(int n) {
        Day day = arr.get(n);

        // 상담했을때와 안했을 때
        if(day.date + n -1<= N) {
            if(n+day.date -1== N)  dp[n] = Math.max(max,dp[n]+day.cost);
            else
                dp[n] = Math.max(max,dp[n+day.date]+day.cost);

            max =dp[n];
        } else {
            dp[n] = max;
        }
    }

}


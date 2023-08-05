import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class ask{
    int day;
    int cost;

    ask(int day,int cost){
        this.day = day;
        this.cost = cost;
    }
}

public class Main {

    static int[] dp;
    static ArrayList<ask> arr;

    static long Sol(int n) {

        int max = 0;
        for(int k = n; k>0;k--){
            if(arr.get(k).day+k-1 > n)
                dp[k] = dp[k+1];
            else {
                if(arr.get(k).cost + dp[arr.get(k).day+k] > dp[k+1]){
                    dp[k] = arr.get(k).cost + dp[arr.get(k).day+k];
                } else
                    dp[k] = dp[k+1];
            }
        }

        return dp[1];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+2];
        arr = new ArrayList<>();
        arr.add(new ask(0,0));
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            arr.add(new ask(a,b));
        }

        br.close();
        bw.write(Sol(n)+"");
        bw.flush();
        bw.close();
    }
}



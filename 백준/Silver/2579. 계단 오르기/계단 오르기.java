import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        
        if(N == 1) {
            bw.write(arr[1]+"");
        } else if(N == 2) {
            bw.write(arr[1]+arr[2]+"");
        } else {
            dp[0] = 0;
            dp[1] = arr[1];
            dp[2] = arr[1]+arr[2];

            for(int j = 3;j<=N;j++) {
                dp[j] = Math.max(arr[j]+dp[j-2],arr[j]+arr[j-1]+dp[j-3]);
            }
            bw.write(dp[N] + ""); 

        }
     




        br.close();
        bw.flush();
        bw.close();
    }



}


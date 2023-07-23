import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[] dp;

    static int solution() {
        int max;
        int answer =1;
        dp[0] = 1;

        for(int i=1;i<n;i++){
            max = 0;
            for(int j = i-1;j>=0;j--) {
                if(arr[i] > arr[j] && max < dp[j]) {
                    max = dp[j];
                }

            }
            dp[i] = max + 1;
            answer = Math.max(answer,dp[i]);
        }



    return answer;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }





        br.close();
        bw.write( solution()+ "");
        bw.flush();
        bw.close();

    }


}
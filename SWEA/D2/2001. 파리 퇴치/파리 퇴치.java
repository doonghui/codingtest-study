import java.util.*;
import java.io.*;
class Solution
{
    static int T,N,M;
    static int[][] dp;
    public static void main(String args[]) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int idx = 1; idx<=T;idx++) {

            st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt (st.nextToken());
            M = Integer.parseInt (st.nextToken());
            int[][] map = new int[N][N];
            dp = new int[N][N];
            for(int i =0;i<N;i++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int j =0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = map[i][j];

                }
            }

            for(int i =0;i<N;i++) {
                for(int j =0;j<N;j++) {
                    if(i == 0 && j ==0) continue;
                    else if(i == 0) dp[i][j] += dp[i][j-1];
                    else if(j == 0) dp[i][j] += dp[i-1][j];
                    else dp[i][j] += dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
                }
            }



            int answer = solve(map);

            bw.write("#"+idx+" "+answer+"\n");

        }

        bw.flush();
        br.close();
        bw.close();



    }
    static int solve(int[][] map) {
        int max = 0;

        for(int x = M-1;x<N;x++) {
            int count =0;
            for(int y = M-1;y<N;y++) {
                if(x -M <0 && y -M <0) count = dp[x][y];
                else if(x-M < 0) count = dp[x][y] - dp[x][y-M];
                else if(y-M < 0) count = dp[x][y] - dp[x-M][y];
                else count = dp[x][y] -dp[x-M][y] - dp[x][y-M] + dp[x-M][y-M];
                max = Math.max(max,count);
            }

        }

        return max;
    }

}
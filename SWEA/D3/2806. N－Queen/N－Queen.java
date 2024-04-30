import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    static int ans;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test =1;test<=T;test++) {
            N = Integer.parseInt(br.readLine());
        int[] map = new int[N];
        Arrays.fill(map, -1);
            ans = 0;

        dfs(0, map);

            bw.write("#"+test+" "+ans+"\n");
        }



        bw.flush();
        br.close();
        bw.close();
    }

 static void dfs(int cnt, int[] map) {

        if (cnt == N) {
            ans++;
            return;
        }

        for (int x = 0; x < N; x++) {
            map[cnt] = x;
            if (checking(cnt, map)) {

                dfs(cnt + 1, map);

            }
        }

    }

 static boolean checking(int idx, int[] map) {

        // 같은 행에 있을 경우
        for (int x = 0; x < idx; x++) {
            if (map[idx] == map[x]) return false;

            if (idx - x == Math.abs(map[idx] - map[x])) return false;

        }


        return true;
    }


}
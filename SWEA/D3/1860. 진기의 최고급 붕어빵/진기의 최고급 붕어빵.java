import java.io.*;
import java.util.*;

class Solution {
    static int N, M, K;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int[] person = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) person[j] = Integer.parseInt(st.nextToken());


            Arrays.sort(person);
            if (solve(person)) bw.write("#" + t + " Possible" + "\n");
            else
                bw.write("#" + t + " Impossible" + "\n");

        }
        bw.flush();
        br.close();
        bw.close();

    }

    static boolean solve(int[] person) {
        if (M > person[0]) return false;        // 붕빵 0 개인데 맨 앞사람이 나오는 시간보다 빨라서 붕빵 못먹을 때

        int fish = 0;
        int idx = 0;
        int time = 0;
        while (true) {
            time += M;
            fish += K;
            if(time > person[idx]) return false;        // 붕빵이 0 개라 시간 추가했는데 사람이 붕빵 못받을 때

            while (fish > 0) {
                fish -= 1;
                idx++;
                if (idx >= N) return true;
            }

        }

    }


}



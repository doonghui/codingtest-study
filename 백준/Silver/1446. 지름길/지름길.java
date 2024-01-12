import java.beans.ConstructorProperties;
import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int s;
    int e;
    int len;

    public Point(int s, int e, int len) {
        this.s = s;
        this.e = e;
        this.len = len;
    }

    @Override
    public int compareTo(Point o) {
        if (this.s == o.s) return this.e - o.e;
        return this.s - o.s;
    }

}

class Main {

    static int N, D;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dp = new int[D + 1];
        ArrayList<Point> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if (e - s < len || s > D || e > D) continue;
            arr.add(new Point(s, e, len));
        }

        for(int k = 0;k<=D;k++) dp[k] = k;

        Collections.sort(arr);
        int move = 0;
        int idx = 0;
        while(move < D) {
            while(idx < arr.size()&& arr.get(idx).s == move) {
                Point p = arr.get(idx);
//                if (dp[p.e] > dp[p.s] + p.len) {
//                    dp[p.e] = dp[p.s] + p.len;
//                }
                dp[p.e] = Math.min(dp[p.e],dp[p.s] + p.len);

                idx++;
            }

            dp[move+1] = Math.min(dp[move+1],dp[move] +1);
            move++;
        }
//        for (int j = 0; j <D; j++) {
//            if(p.s == j) {
//                if (dp[p.e] > dp[p.s] + p.len) {
//                    dp[p.e] = dp[p.s] + p.len;
//                    if(j != 0) j = p.s -1;
//                }
//                idx++;
//                if(idx == arr.size()) idx = 0;
//                p = arr.get(idx);
//
//            }
//                if (dp[j + 1] > dp[j] + 1) dp[j + 1] = dp[j] + 1;
//
//        }

//        int idx = 0;
//        while(!q.isEmpty()) {
//            Point p = q.poll();
//            if(dp[p.s] + p.len < dp[p.e]) {
//                    idx = dp[p.s] + p.len;
//                }
//
//            if(dp[idx +1] > dp[idx] +1) dp[idx+1] = dp[idx] +1;
//
//        }
        bw.write(dp[D] + "");
        br.close();
        bw.flush();
        br.close();
    }


}

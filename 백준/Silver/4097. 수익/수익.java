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
        return this.s - o.s;
    }

}

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int[] arr = new int[N];
            long[] dp = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                dp[i] = arr[i];
            }
            for (int j = 0; j < N - 1; j++) {
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + dp[j + 1]);
            }

            Arrays.sort(dp);
            bw.write(dp[N - 1] + "\n");


        }

        br.close();
        bw.flush();
        br.close();
    }


}

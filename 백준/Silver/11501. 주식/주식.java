import java.awt.*;
import java.io.*;
import java.util.*;


class Point implements Comparable<Point> {
    int idx;
    int value;

    public Point(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    @Override
    public int compareTo(Point po) {
        return po.value - this.value;
    }


}


class Main {


    static int T, N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;


        T = Integer.parseInt(br.readLine());

        
        long[] answer = new long[T];
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            answer[i] = solution(arr);


        }


        for (long ans : answer) {
            bw.write(ans + "\n");
        }


        br.close();
        bw.flush();
        br.close();
    }

    static long solution(int[] arr) {
        long answer = 0;
        int maxValue = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] <= maxValue) {
                answer += maxValue - arr[i];
            } else
                maxValue = arr[i];
        }
        return answer;
    }
}

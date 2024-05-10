import java.io.*;
import java.util.*;


class Main {
    static int N, M;
    static int max;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());


        Arrays.sort(arr);
        bw.write(binary(arr) + "");
        bw.flush();
        br.close();
        bw.close();

    }


    static int binary(int[] arr) {
        if (M == 1) return arr[arr.length - 1];
        int lt = 1;
        int rt = 1000000000;
        int mid = 0;
        max = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(mid == 0) return rt;
                cnt += arr[i] / mid;
            }

            if (cnt >= M) {
                lt = mid + 1;


            } else if (cnt < M) {
                rt = mid - 1;
            }

        }

        return rt;
    }


}
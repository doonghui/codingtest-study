import java.io.*;
import java.util.*;


class Main {
    static int N, K;
    static int max;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];


        for (int i = 0; i < K; i++) arr[i] = Long.parseLong(br.readLine());


        // N개 ~ sort 해서 제일 작은 수까지

        Arrays.sort(arr);



        bw.write(binary(arr[arr.length-1], arr) + "");
        bw.flush();
        br.close();
        bw.close();

    }


    static int binary(long num, long[] arr) {
        long lt = 1;
        long rt = num;
        long mid = 0;
        max = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) {
//                if (mid > arr[i]) cnt += 1;
//                else
                    cnt += arr[i] / mid;
            }

            if (cnt >= N) {
                lt = mid + 1;

            } else if (cnt < N) {
                rt = mid - 1;
            }

        }

        return (int)rt;
    }


}
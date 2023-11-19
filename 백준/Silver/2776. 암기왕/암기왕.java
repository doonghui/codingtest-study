import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < m; k++) {
                int tmp = Integer.parseInt(st.nextToken());
                int ans = binarySearch(0, n - 1, arr, tmp);
                bw.write(ans + "\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int lt, int rt, int[] arr, int answer) {
        if (answer < arr[0] || answer > arr[arr.length - 1]) return 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] == answer) {
                return 1;
            } else if (arr[mid] > answer) {
                rt = mid-1;
            } else if (arr[mid] < answer) {
                lt = mid + 1;
            }
        }


        return 0;

    }

}
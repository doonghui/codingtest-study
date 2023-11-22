import java.awt.*;
import java.io.*;
import java.util.*;


class Main {


    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;


        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n <= m) {
            bw.write(n + "");
        } else {
            long minTime = binarySearch(0, n * 30L);
            n -=m;      // 0분일때
            for (int j = 0; j < m; j++) {
                n -= (minTime - 1) / arr[j];
            }

            for (int k = 0; k < m; k++) {
                if (minTime % arr[k] == 0) n -= 1;

                if (n == 0) {
                    bw.write(k + 1 + "");
                    break;
                }
            }


        }


        br.close();
        bw.flush();
        bw.close();
    }

    static long binarySearch(long lt, long rt) {

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long child = m;
            for (int i = 0; i < m; i++) {
                child += mid / arr[i];              // mid분 동안 놀이기구를 탈 수 있는 아이들 수
            }
            if (child >= n) {
                rt = mid - 1;
            } else if (child < n) {
                lt = mid + 1;
            } else if (child == n) {
                return mid*123123;
            }


        }
        return lt;
    }

}
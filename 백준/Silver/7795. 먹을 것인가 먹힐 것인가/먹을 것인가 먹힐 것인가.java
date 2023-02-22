import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int cnt;

    static int BinarySearch(int A, Integer[] B, int x, int y) {

            int start = 0;
            int end = y;
            int count = 0;
            while (start <= end) {
               int mid = (start + end) / 2;
                if (A > B[mid]) {
                    start = mid+1;
                    count = mid +1;
                } else {
                    end = mid-1;

                }
            }


        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Integer[] A = new Integer[x];
            Integer[] B = new Integer[y];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++)
                A[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < y; k++)
                B[k] = Integer.parseInt(st.nextToken());

            Arrays.sort(B);

            int ans = 0;
            for(int l =0;l<x;l++) {
                ans += BinarySearch(A[l],B,x,y-1);
            }

            bw.write(ans+ "\n");
        }


        br.close();
        bw.flush();
        bw.close();


    }

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static int N, K;
    static int[] dp;
    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int count = 0;
        int delete = 0;
        int max = 0;
        int lt = 0;
        int rt = 0;
        while (true) {
            if (rt == N) break;
            if (arr[rt] % 2 == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                delete += 1;
                while (delete > K) {
                    if (arr[lt] % 2 == 0) count--;
                    else
                        delete--;
                    lt++;
                }
            }
            rt++;
        }


        bw.write(max + "");
        bw.flush();
        bw.close();
    }

}


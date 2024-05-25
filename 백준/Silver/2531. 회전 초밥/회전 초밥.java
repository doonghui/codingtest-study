import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int N, D, K, C;
    static ArrayList<ArrayList<Point>> gragh;
    static boolean[] infection;
    static int[] sushi;
    static int max;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        int[] dist = new int[D + 1];

        for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());

        int count = 0;
        for (int j = 0; j < K; j++) {
            if (dist[sushi[j]] == 0) count++;
            dist[sushi[j]]++;
        }

        int max = count;


        int rt = K - 1;
        for (int lt = 1; lt<=N;lt++) {
            rt++;
            if (rt == N) rt = 0;

            if (max <= count) {
                if (dist[C] == 0) max = count + 1;
                else
                    max = count;
            }

            dist[sushi[lt - 1]]--;
            if (dist[sushi[lt - 1]] == 0) count--;
            if (dist[sushi[rt]] == 0) count++;
            dist[sushi[rt]]++;


        }


//        while (true) {
//            lt++;
//            rt++;
//            if (lt == N) break;
//            if (rt == N) rt = 0;
//
//            if (max <= count) {
//                if (dist[C] == 0) max = count + 1;
//                else
//                    max = count;
//            }
//
//            dist[sushi[lt - 1]]--;
//            if (dist[sushi[lt - 1]] == 0) count--;
//            if (dist[sushi[rt]] == 0) count++;
//            dist[sushi[rt]]++;
//
//
//        }

        bw.write(max + "");


        bw.flush();
        br.close();
        bw.close();

    }


}


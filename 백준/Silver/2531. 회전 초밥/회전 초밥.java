import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int N, D, K, C;

    static int[] sushi;


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
        int max = 0;
        for (int j = 0; j < K; j++) {
            if (dist[sushi[j]] == 0) count++;
            dist[sushi[j]]++;
        }

        max = count;


        for (int lt = 1; lt <= N; lt++) {


            if (max <= count) {
                if (dist[C] == 0) max = count + 1;
                else
                    max = count;
            }


            dist[sushi[lt - 1]]--;
            if (dist[sushi[lt - 1]] == 0) count--;
            if (dist[sushi[(lt + K - 1) % N]] == 0) count++;
            dist[sushi[(lt + K - 1) % N]]++;
        }


        bw.write(max + "");


        bw.flush();
        br.close();
        bw.close();

    }


}


import java.io.*;
import java.util.*;

class Main {
    static int H, W, N;
    static int max;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        int[][] sticker = new int[N][2];

        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sticker[j][0] = r;
            sticker[j][1] = c;
        }

        max = 0;
        for (int m = 0; m < N - 1; m++) {

            check(sticker, sticker[m][0], sticker[m][1], m);
            check(sticker, sticker[m][1], sticker[m][0], m);

        }


        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();

    }

    static void check(int[][] sticker, int r, int c, int idx) {

        for (int i = idx + 1; i < N; i++) {
            int row = sticker[i][0];
            int column = sticker[i][1];
            if (r + row <= H && c <= W && column <= W) {
                max = Math.max(max, (r * c) + (row * column));
            } else if (column + c <= W && r <= H && row <= H) {
                max = Math.max(max, (r * c) + (row * column));
            }

            row = sticker[i][1];
            column = sticker[i][0];

            if (r + row <= H && c <= W && column <= W) {
                max = Math.max(max, (r * c) + (row * column));
            } else if (column + c <= W && r <= H && row <= H) {
                max = Math.max(max, (r * c) + (row * column));
            }

        }


    }


}



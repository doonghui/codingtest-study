import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static int N;
    static int[][] map;
    static int[] color;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        color = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        divide(0, 0, N);


        bw.write(color[0] + "\n" + color[1] + "\n" + color[2]);

        br.close();
        bw.flush();
        bw.close();
    }


    static void divide(int r, int c, int size) {
        if (check(r, c, size, -1)) color[0]++;
        else if (check(r, c, size, 0)) color[1]++;
        else if (check(r, c, size, 1)) color[2]++;
        else {

            int resize = size / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(r + resize * i, c + resize * j, resize);
                }
            }


        }


    }

    static boolean check(int r, int c, int size, int color) {

        for (int x = r; x < r + size; x++) {
            for (int y = c; y < c + size; y++) {
                if (map[x][y] != color) return false;
            }
        }

        return true;
    }

}


import java.io.*;
import java.util.*;


class Main {

    static int n;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        sb = new StringBuilder();

        resize(0, 0, n);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void resize(int x, int y, int size) {
        if (check(x, y, size)) {
            sb.append(map[x][y] + "");
            return;
        }
        sb.append("(");

        int resize = size / 2;
        resize(x, y, resize);
        resize(x, y + resize, resize);
        resize(x + resize, y, resize);
        resize(x + resize, y + resize, resize);
        sb.append(")");

    }

    static boolean check(int x, int y, int size) {
        int v = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (v != map[i][j]) return false;
            }
        }
        return true;
    }


}
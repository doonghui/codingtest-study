import java.io.*;
import java.util.*;
 
 
public class Main {
    static int[][] map; // 배추 심는 곳
    static int d, c, min = Integer.MAX_VALUE;
    static int where;
    static int temp;
    static int[] x = {0, 0, 1, -1}, y = {1, -1, 0, 0}; // 상하좌우 이동으로 사용될 배열
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            c = Integer.parseInt(s[0]);
            d = Integer.parseInt(s[1]);
            where = Integer.parseInt(s[2]);
            map = new int[c][d];
            for (int j = 0; j < where; j++) {
                int a, b;
                String[] s1 = br.readLine().split(" ");
                a = Integer.parseInt(s1[0]);
                b = Integer.parseInt(s1[1]);
                map[a][b] = 1;
            }
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < d; k++) {
                    if (map[j][k] == 1) {
                        dfs(j, k);
                        temp++;
                    }
                }
            }
            min = temp;
            temp = 0;
            System.out.println(min);
        }
    }
 
    public static void dfs(int c1, int d1) {
        if (map[c1][d1] == 0) {
            return;
        }
        map[c1][d1]=0;
 
        for (int i = 0; i < 4; i++) {
            int i1 = c1 + x[i];
            int i2 = d1 + y[i];
            if (i1 >= 0 && i1 < c && i2 >= 0 && i2 < d) {
                dfs(i1, i2);
            }
        }
    }
}
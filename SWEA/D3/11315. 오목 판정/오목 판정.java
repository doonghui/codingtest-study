import java.io.*;
import java.util.*;


class Solution {
    static int N;
    static int[][] map;
    //   static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    //   static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 0, 1, 1, 1};
    static int[] dy = {-1, 1, 1, 0, -1};


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];


            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    if (s.charAt(j) == 'o') map[i][j] = 1;


                }
            }

            if (check()) bw.write("#" + t + " YES\n");
            else
                bw.write("#" + t + " NO\n");

        }


        bw.flush();
        br.close();
        bw.close();

    }


    static boolean check() {


        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] == 0) continue;            // 돌일 경우만 아래 로직 돌기
                for (int i = 0; i < 5; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    int cnt = 1;
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {

                        while (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                            cnt += 1;

                            if (cnt >= 5) return true;

                            nx += dx[i];
                            ny += dy[i];
                        }

                    }


                }


            }

        }

        return false;


    }


}
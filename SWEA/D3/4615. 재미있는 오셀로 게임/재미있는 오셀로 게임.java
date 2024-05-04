import java.io.*;
import java.util.*;


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}


class Solution {
    static int N, M;
    static int[][] map;
    static int[][] dot;
    static int[] color;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N + 1][N + 1];
            color = new int[3];
            dot = new int[M][3];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                dot[i][0] = Integer.parseInt(st.nextToken());
                dot[i][1] = Integer.parseInt(st.nextToken());
                dot[i][2] = Integer.parseInt(st.nextToken());
            }


            check();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == 1) color[1]++;
                    else if (map[i][j] == 2) color[2]++;
                }
            }


            bw.write("#" + t + " " + color[1] + " " + color[2] + "\n");
        }


        bw.flush();
        br.close();
        bw.close();

    }


    static void check() {

        int idx = N / 2;

        // 초방 세팅
        map[idx][idx] = 2;
        map[idx + 1][idx + 1] = 2;
        map[idx + 1][idx] = 1;
        map[idx][idx + 1] = 1;
        // 흑,백 돌 개수
//        color[1] = 2;
//        color[2] = 2;

        for (int k = 0; k < M; k++) {
            int x = dot[k][0];
            int y = dot[k][1];
            int co = dot[k][2];

            // 놓을 자리가 맵 범위 벗어날 때
//            if(x <1 || x >N || y <1 || y >N) continue;
            // 놓을 돌인데 다른 색 돌이 있을 때
//            if(co == 1 && map[x][y] == 2) continue;
//            else if(co == 2 && map[x][y] == 1) continue;


            // 내 자리에 이미 돌이 있을 때
//            if (map[x][y] != 0) continue;

            // 나랑 다른색 돌을 8군데 탐색하면서 찾기
            for (int n = 0; n < 8; n++) {
                int nx = x + dx[n];
                int ny = y + dy[n];

                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                if (map[nx][ny] == 0) continue;

                Queue<Point> q = new LinkedList<>();
                if (map[nx][ny] != co) {
                    while (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                        if (map[nx][ny] == co) {
                            map[x][y] = co;
                            while (!q.isEmpty()) {
                                Point p = q.poll();
                                map[p.x][p.y] = co;
                            }

                            break;
                        } else if (map[nx][ny] == 0) break;
                        else {
                            q.add(new Point(nx, ny));
                        }

                        nx += dx[n];
                        ny += dy[n];
                    }


                }

//                boolean flag = false;
//                boolean flag2 = false;
//                if (co == 1) {
//                    while (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
//                        if (map[nx][ny] == 2) flag = true;            // 있을 때 그 방향으로 계속가면서 내 돌과 같은 돌이 있는지 찾기
//                        else if (map[nx][ny] == 1) {                   // 만약 있으면 그 사이에 있던 다른 돌들 다 나랑 같은 돌로 바꾸기 + 내 자리에 돌 놔두기
//                            flag2 = true;
//                            break;
//                        } else
//                            break;
//
//                        // 다음 방향으로 계속 가기
//                        nx += dx[n];
//                        ny += dy[n];
//                    }
//
//                    if (flag && flag2) {            // 이 때가 내가 놓을 돌 주변에 다른 색 돌 있고 + 그 담에 나랑 같은 돌 있는 경우.
//                        map[x][y] = 1;
//                        color[1]++;
//                        while (true) {
//                            nx -= dx[n];
//                            ny -= dy[n];
//
//                            if (nx == x && ny == y) break;
//
//                            map[nx][ny] = 1;
//                            color[2]--;
//                            color[1]++;
//
//                        }
//
//                    }
//
//
//                } else {
//                    while (nx >= 1 && nx <= N && ny >= 1 && ny <= N && map[nx][ny] != 0) {
//                        if (map[nx][ny] == 1) flag = true;
//                        else if (map[nx][ny] == 2) {
//                            flag2 = true;
//                            break;
//                        } else break;
//
//                        nx += dx[n];
//                        ny += dy[n];
//                    }
//
//                    if (flag && flag2) {
//                        map[x][y] = 2;
//                        color[2]++;
//                        while (true) {
//                            nx -= dx[n];
//                            ny -= dy[n];
//
//                            if (nx == x && ny == y) break;
//                            map[nx][ny] = 2;
//                            color[1]--;
//                            color[2]++;
//
//                        }
//
//                    }
//                }


//                if (color[1] + color[2] == N * N) return;
            }

//            if (color[1] + color[2] == N * N) return;

        }


        return;
    }
}
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Shark {
    int speed;
    int dir;
    int size;

    public Shark(int speed, int dir, int size) {
        this.speed = speed;
        this.dir = dir;
        this.size = size;
    }
}


class Point {
    int fromX;
    int fromY;
    int toX;
    int toY;

    public Point(int fromX, int fromY, int toX, int toY) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }
}

class Main {

    static int r, c, m;
    static Shark[][] map;
    static int[] dx = {0, -1, 1, 0, 0};      // 위 아래 오른쪽 왼쪽
    static int[] dy = {0, 0, 0, 1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new Shark[r + 1][c + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if(d <=2)
                s = s % ((r-1)*2);
            else
                s = s % ((c-1)*2);

            map[row][column] = new Shark(s, d, z);

        }
        int ans = 0;
        for (int man = 1; man <= c; man++) {
            for (int j = 1; j <= r; j++) {            // 상어 잡기
                if (map[j][man] != null) {
                    ans += map[j][man].size;
                    map[j][man] = null;
                    break;
                }
            }

            map = move();

        }


        br.close();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }

    static Shark[][] move() {
        Shark[][] tmpMap = new Shark[r + 1][c + 1];
        Queue<Point> q = new LinkedList<>();



        for (int x = 1; x <= r; x++) {
            for (int y = 1; y <= c; y++) {
                if (map[x][y] != null) {
                    int tmpX = x;
                    int tmpY = y;
                    int speed = map[x][y].speed;
                    while (speed-- > 0) {
                        int nx = tmpX + dx[map[x][y].dir];
                        int ny = tmpY + dy[map[x][y].dir];

                        if (nx > r|| ny <= 0) {
                            map[x][y].dir--;
                            nx = tmpX + dx[map[x][y].dir];
                            ny = tmpY + dy[map[x][y].dir];
                        } else if (nx <= 0 || ny > c) {
                            map[x][y].dir++;
                            nx = tmpX + dx[map[x][y].dir];
                            ny = tmpY + dy[map[x][y].dir];
                        }
                        tmpX = nx;
                        tmpY = ny;
                    }


                    q.add(new Point(x, y, tmpX, tmpY));
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (tmpMap[p.toX][p.toY] == null) {
                tmpMap[p.toX][p.toY] = map[p.fromX][p.fromY];
            } else {
                if (map[p.fromX][p.fromY].size > tmpMap[p.toX][p.toY].size) {
                    tmpMap[p.toX][p.toY] = map[p.fromX][p.fromY];
                }
            }
            map[p.fromX][p.fromY] = null;
        }
        return tmpMap;

    }


}






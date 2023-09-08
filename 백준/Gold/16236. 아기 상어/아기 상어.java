import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Point implements Comparable<Point> {
    int x;
    int y;
    int dist;

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Point po) {
        if (this.dist == po.dist) {
            if (this.x == po.x) {
                return this.y - po.y;
            } else
                return this.x - po.x;
        } else
            return this.dist - po.dist;
    }
}

class Main {

    static int n;
    static int[][] map;
    static int fishNum = 0;
    static int count = 0;
    static Point shark = null;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Point(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        int sharkSize = 2;

        // 물고기를 못 먹을 때까지 계속 반복
        while (true) {
            if (bfs(sharkSize)) break;
            if(sharkSize == fishNum){
                sharkSize++;
                fishNum =0;
            }
        }


        br.close();
        bw.write(count + "");
        bw.flush();
        bw.close();

    }

    static boolean bfs( int sharkSize) {
        PriorityQueue<Point> pQ = new PriorityQueue<>();           // 이동거리 짧은순 -> 가장 위에 있는 물고기 -> 가장 왼쪽에 있는 물고기

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (map[x][y] > 0 && map[x][y] < sharkSize) {
                    int distance = distance(shark.x,shark.y,x,y,sharkSize);
                    if(distance != 0)
                        pQ.add(new Point(x, y, distance));
                }
            }
        }


        if (pQ.isEmpty()) return true;              // 먹을 수 있는 물고기가 없을 때

        Point fish = pQ.poll();
        map[fish.x][fish.y] = 0;
        shark.x = fish.x;
        shark.y = fish.y;
        count += fish.dist;
        fishNum++;


        return false;


    }
    static int distance(int startX,int startY, int endX, int endY,int sharkSize) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new Point(startX,startY,0));
        visited[startX][startY] = true;

        while(!q.isEmpty()) {
            Point fish = q.poll();

            for(int i= 0; i<4;i++) {
                int nx = fish.x + dx[i];
                int ny = fish.y + dy[i];
                if(nx < 0 || nx >= n || ny <0 || ny >=n) continue;
                if(map[nx][ny] > sharkSize) continue;
                if(visited[nx][ny]) continue;

                if(nx == endX && ny == endY) return fish.dist+1;
                visited[nx][ny] = true;
                q.add(new Point(nx,ny,fish.dist+1));
            }
        }


    return 0;
    }

}


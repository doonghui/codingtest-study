import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    public Point(int x,int y ){
        this.x = x;
        this.y =y;
    }
}



class Main {


    static int N,M;
    static int[][] map;
    static int[][] newMap;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        newMap = new int[N][M];
        visited = new boolean[N][M];
        int idxX = 0;
        int idxY = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    idxX = i;
                    idxY = j;
                }
                if(map[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                }
            }
        }

       bfs(idxX,idxY);

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
             if(!visited[i][j]) newMap[i][j] = -1;
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                bw.write(newMap[i][j]+" ");
            }
            bw.write("\n");
        }


        br.close();
        bw.flush();
        br.close();
    }

    static void bfs(int idxX,int idxY) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(idxX,idxY));
        visited[idxX][idxY] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i =0; i<4;i++) {
                int nx = p.x+dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || nx >= N || ny <0 || ny >= M) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx,ny));
                    newMap[nx][ny] = newMap[p.x][p.y] +1;
                }

            }

        }






    }


}

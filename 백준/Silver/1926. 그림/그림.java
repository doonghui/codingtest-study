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

public class Main {

    static int[][] gragh;
    static int n, m;
    static int max =1;
    static int count =0;
    static int tmp;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x,y));

        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i =0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny  = temp.y + dy[i];
                if(nx >=0 && nx<n && ny >=0 && ny < m && gragh[nx][ny] == 1) {
                    gragh[nx][ny] = 0;
                    q.add(new Point(nx,ny));
                    tmp += 1;
                }
            }
        }




    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        gragh = new int[n][m];


        for(int i =0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j =0;j<m;j++)
                gragh[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i =0;i<n;i++) {
            for(int j =0;j<m;j++) {
                if(gragh[i][j] == 1){
                    tmp = 0;
                    bfs(i,j);
                    count++;
                    max = Math.max(max,tmp);

                }
            }
        }

        if(count == 0)
            max = 0;





        br.close();
        bw.write(count +"\n"+max);
        bw.flush();
        bw.close();


    }
}


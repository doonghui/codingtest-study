import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = Integer.MIN_VALUE;
    static int[][] fuDx = {{0,1,0,-1},{0,1,0,0},{0,1,-1,0},{0,0,0,-1}};
    static int[][] fuDy = {{0,0,-1,0},{0,0,-1,1},{0,0,0,1},{0,1,-1,0}};



    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);

                fuDfs(i,j);
            }
        }


        bw.write(max + "");
        br.close();
        bw.flush();
        bw.close();

    }


    static void dfs(int x, int y, int count, int sum) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx <n && ny >=0 && ny < m) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx,ny,count + 1, sum + map[nx][ny]);
                    visited[nx][ny] = false;
                }
            }



        }
    }

    static void fuDfs(int x, int y) {

        for(int i=0;i<4;i++) {
            int count = 0;
            int sum = 0;
            for(int j=0;j<4;j++) {
                int nx = x + fuDx[i][j];
                int ny = y + fuDy[i][j];

                if(nx >= 0 && nx<n && ny >=0 && ny<m) {
                    count++;
                    sum += map[nx][ny];
                }
            }
            if(count == 4) {
                max = Math.max(max,sum);
            }
        }
    }


}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                solution(i, j, 0,map[i][j],-1);
            }
        }

        br.close();
        bw.write(min+"");
        bw.flush();
        bw.close();


    }

    static void solution(int x, int y, int level,int sum,int dir) {
        if (n-1 == level) {
           min = Math.min(min,sum);
            return;
        } else {


            for (int l = 0; l < 3; l++) {
                if(l == dir) continue;

                int nx = x + dx[l];
                int ny = y + dy[l];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                    if(sum + map[nx][ny] > min) continue;
                    solution(nx,ny,level+1,sum+map[nx][ny],l);
                }


            }


        }


    }


}
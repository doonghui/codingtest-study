import java.io.*;
import java.util.*;

class Po {
    int x;
    int y;

    Po(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
    static int[][] arr;
    static int[][] ch;              // 방문처리를 위한 배열
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static void Sol(int x, int y,int p) {
        Queue<Po> Q = new LinkedList<>();
        Q.offer(new Po(x, y));
        ch[x][y] = 1;
        while (!Q.isEmpty()) {
            Po now = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)            // 배열의 인덱스를 넘어서는 곳은 넘기기
                    continue;
                if (arr[nx][ny] > p && ch[nx][ny] == 0) {            // 상하좌우 탐색하면서 집 :1 이 있고 방문한적 없는 곳 : 0 찾기
                    ch[nx][ny] = 1;
                    Q.offer(new Po(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min,arr[i][j]);
                max = Math.max(max,arr[i][j]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int p = min-1; p<max;p++) {
            int cnt = 0;
            ch = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (arr[x][y] > p && ch[x][y] == 0) {
                        Sol(x, y,p);
                        cnt++;
                    }
                }

            }
            ans = Math.max(ans,cnt);
        }


        bw.write(ans + "\n");


        br.close();
        bw.flush();
        bw.close();


    }
}

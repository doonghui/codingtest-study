import java.io.*;
import java.util.*;


public class Main {

    static int[][] gragh;
    static int n;
    static boolean[][] visited;
    static int count = 0;
    static String str = "Hing";


    static void dfs(int x, int y) {

        if (x == n-1 && y == n-1){
            str = "HaruHaru";
            return;
        }


        int nx = x + gragh[x][y];
        int ny = y + gragh[x][y];
        if (nx < n && visited[nx][y] == false) {
            visited[nx][y] = true;
            dfs(nx, y);
        }
        if (ny < n && visited[x][ny] == false) {
            visited[x][ny] = true;
            dfs(x, ny);
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        gragh = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++)
                gragh[i][j] = Integer.parseInt(st.nextToken());
        }


        visited = new boolean[n][n];
        visited[0][0] = true;              // 노드 1 은 방문을 하고 시작하게 만들기
        dfs(0, 0);

        bw.write(str);

        br.close();
        bw.flush();
        bw.close();


    }
}


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

    static char[][] gragh;
    static int[] enemy;
    static boolean[][] white;
    static boolean[][] blue;
    static int tmp = 0;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void DFS(int x, int y, String bo) {

        if (bo.equals("W")){
            white[x][y] = true;
            tmp += 1;
        }
        else{
            blue[x][y] = true;
            tmp += 1;
        }


        for (int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if (nx > 0 && nx <= m && ny > 0 && ny <= n) {
                if(gragh[nx][ny]=='W' && white[nx][ny] == false &&bo.equals("W") ){
                    DFS(nx,ny,"W");

                } else if(gragh[nx][ny]=='B' && blue[nx][ny] == false && bo.equals("B")){
                    DFS(nx,ny,"B");
                }

            }
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        gragh = new char[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            String str = br.readLine();
            for(int j = 1; j<=n;j++) {
                gragh[i][j] = str.charAt(j-1);
            }
        }

        enemy = new int[2];
        white = new boolean[m + 1][n + 1];
        blue = new boolean[m + 1][n + 1];


        for (int x = 1; x < m + 1; x++) {
            for (int y = 1; y < n + 1; y++) {
                if (gragh[x][y] == 'W' && white[x][y] == false) {
                    DFS(x, y, "W");
                    int pow = (int)Math.pow(tmp,2);
                    enemy[0] += pow;
                    tmp = 0;
                }


            }
        }

        for (int x = 1; x < m + 1; x++) {
            for (int y = 1; y < n + 1; y++) {
                if (gragh[x][y] == 'B' && blue[x][y] == false) {
                    DFS(x, y,"B");
                    int pow = (int)Math.pow(tmp,2);
                    enemy[1] += pow;
                    tmp = 0;
                }


            }
        }


        br.close();
        bw.write(enemy[0] + " "+enemy[1]);
        bw.flush();
        bw.close();


    }
}


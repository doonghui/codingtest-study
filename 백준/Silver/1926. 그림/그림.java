import java.io.*;
import java.util.*;


public class Main {

    static int[][] gragh;
    static int n, m;
    static int max =1;
    static int count =0;
    static int tmp;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y) {

        for(int i =0;i<4;i++) {
            int nx = x + dx[i];
            int ny  = y + dy[i];
            if(nx >=0 && nx<n && ny >=0 && ny < m && gragh[nx][ny] == 1) {
                gragh[nx][ny] = 0;
                tmp += 1;
                dfs(nx,ny);
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
                    dfs(i,j);
                    count++;
                   max = Math.max(max,tmp);

                }
            }
        }

        if(count == 0 )
            max = 0;





        br.close();
        bw.write(count +"\n"+max);
        bw.flush();
        bw.close();


    }
}


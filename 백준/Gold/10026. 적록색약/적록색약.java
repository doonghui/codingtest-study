import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static boolean[][] blindVisited;
    static int normalCnt = 0;
    static int blindCnt = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void Normal(int x,int y) {

        for(int i =0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx <n&& ny >=0 && ny < n && arr[nx][ny]==arr[x][y]  && !visited[nx][ny]) {
                visited[nx][ny] = true;
                Normal(nx,ny);
            }
        }
    }


    static void ColorBlind(int x,int y) {

        for(int i =0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx <n&& ny >=0 && ny < n   && !blindVisited[nx][ny]) {
                if(arr[x][y] =='R' || arr[x][y] =='G'){
                    if(arr[nx][ny]=='R' || arr[nx][ny] =='G'){
                        blindVisited[nx][ny] = true;
                        ColorBlind(nx,ny);
                    }
                } else if(arr[nx][ny]==arr[x][y]){
                    blindVisited[nx][ny] = true;
                    ColorBlind(nx,ny);
                }

            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        blindVisited = new boolean[n][n];
        String str = "";

        for(int i =0;i<n;i++) {
            str = br.readLine();
            for(int j = 0;j<n;j++)
                arr[i][j] = str.charAt(j);
        }

        for(int x =0;x<n;x++) {
            for(int y = 0;y<n;y++) {
                if(!visited[x][y]){
                    Normal(x,y);
                    normalCnt++;

                }
                if(!blindVisited[x][y]) {
                    ColorBlind(x,y);
                    blindCnt++;
                }
            }
        }


        br.close();
        bw.write(normalCnt+" "+blindCnt);
        bw.flush();
        bw.close();


    }
}


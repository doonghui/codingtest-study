import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class TurnCnt{
    int cnt;
    char turn;
    public TurnCnt(int cnt,char turn) {
        this.cnt = cnt;
        this.turn = turn;
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


}

public class Main {

    static int n,k,l;
    static int[][] arr;
    static ArrayList<TurnCnt> list;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int idx;

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        arr[1][1] = 1;
        q.offer(new Point(1,1));
        int count = 0;
        idx = 0;
        int nx = 1;
        int ny = 1;

        while(!q.isEmpty()) {
            count++;
             nx += dx[idx];
             ny += dy[idx];

            if(nx <1 || ny < 1 || nx > n || ny > n || arr[nx][ny] == 1) return count;

            if(arr[nx][ny] == 2) {
                arr[nx][ny] = 1;
                q.add(new Point(nx,ny));

            } else {
                arr[nx][ny] = 1;
                q.add(new Point(nx,ny));
                Point po = q.poll();
                arr[po.x][po.y] = 0;
            }


            for(TurnCnt tc : list) {
                if(tc.cnt == count) {
                    if(tc.turn == 'D') {
                        if(idx == 3) idx = 0;
                        else
                            idx++;
                    } else {
                        if(idx == 0) idx = 3;
                        else
                            idx--;
                    }

                }
            }

        }

        return count;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];

        for(int i = 0;i<k;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b][a] = 2;
        }

        l = Integer.parseInt(br.readLine());

         list = new ArrayList<>();
        for(int i = 0;i<l;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            list.add(new TurnCnt(t,c));
        }



        br.close();
        bw.write(        bfs()+ "");
        bw.flush();
        bw.close();

    }


}
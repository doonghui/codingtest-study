
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n != 0) {
            cnt += 1;
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
            }

            bw.write("Problem " + cnt + ": " + sol(arr, n) + "\n");


            n = Integer.parseInt(br.readLine());
        }

        br.close();
        bw.flush();
        bw.close();
    }


    static int sol(int[][] arr, int n) {
        int[][] newArr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.add(new int[]{0, 0, arr[0][0]});
        newArr[0][0] = arr[0][0];
        visited[0][0] = true;


        while (!q.isEmpty()) {
            int[] po = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = po[0] + dx[i];
                int ny = po[1] + dy[i];

                if (nx >= n || nx < 0 || ny >= n || ny < 0) continue;     // 범위 벗어났을 때

//                if(newArr[nx][ny] != 0 &&po[2] > newArr[nx][ny]) continue;

                if (!visited[nx][ny] || (visited[nx][ny] && po[2] + arr[nx][ny] < newArr[nx][ny])) {

                    visited[nx][ny] = true;
                    newArr[nx][ny] = po[2] + arr[nx][ny];
                    q.add(new int[]{nx, ny, po[2] + arr[nx][ny]});
                }


            }
        }


        return newArr[n - 1][n - 1];

    }


}




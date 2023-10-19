import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node {
    int x;
    int y;
    int value;
    public Node(int x, int y,int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

class Main {

    static int n, m, t;
    static int[][] map;
    static int[][] rotate;
    static int[]dx = {-1,0,1,0};
    static int[]dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());           // t번 회전

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate = new int[t][3];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            rotate[i][0] = Integer.parseInt(st.nextToken());       // x의 배수
            rotate[i][1] = Integer.parseInt(st.nextToken());
            rotate[i][2] = Integer.parseInt(st.nextToken());
        }


        for(int[] ro : rotate) {
            rotation(ro[0],ro[1],ro[2]);
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] ==0) continue;
                   if(find(i,j)) flag= true;
                }
            }

            if(!flag) {                                 // 평균구해서~..
                average();
            }

        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += map[i][j];
                }
            }

        br.close();
        bw.write(ans+"");
        bw.flush();
        bw.close();




    }

    static void rotation(int x, int d, int k) {
        if(d == 0) {                                    // 시계방향
                for(int i=x;i<=n;i+=x) {                 // x의 배수만큼
                    for(int z = 0;z<k;z++) {            // k 회전한다.
                        int tmp = map[i-1][m-1];
                        for(int j = m-1;j>0;j--) {
                            map[i-1][j] = map[i-1][j-1];
                        }
                        map[i-1][0] = tmp;
                    }
                }

        } else {                                        // 반시계방향
            for(int i=x;i<=n;i+=x) {                 // x의 배수만큼
                for(int z = 0;z<k;z++) {            // k 회전한다.
                    int tmp = map[i-1][0];
                    for(int j = 0;j<m-1;j++) {
                        map[i-1][j] = map[i-1][j+1];
                    }
                    map[i-1][m-1] = tmp;
                }
            }


        }

    }

    static boolean find(int x, int y) {
      Queue<Node> q= new LinkedList<>();
      boolean[][] visited = new boolean[n][m];
      q.add(new Node(x,y,map[x][y]));
      visited[x][y] = true;
      int tmp = map[x][y];
      map[x][y] = 0;

      boolean flag = false;
      while(!q.isEmpty()) {
          Node node = q.poll();

          for(int z =0;z<4;z++) {
              int nx = node.x + dx[z];
              int ny = node.y + dy[z];

              if(nx <0) continue;
              if(nx >=n) continue;
              if(ny <0) ny = m-1;
              if(ny >=m) ny = 0;


              if(visited[nx][ny]) continue;

              if(map[nx][ny] == node.value) {
                  flag = true;
                  visited[nx][ny] = true;
                  map[nx][ny] = 0;
                  q.add(new Node(nx,ny,node.value));

              }

          }

      }
      if(!flag) {
          map[x][y] = tmp;
      }

      return flag;
    }
    // 47
    static void average() {
        double num = 0;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += map[i][j];
                if(map[i][j] !=0)num++;
            }
        }

        double ave = sum / num;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] !=0){
                    if(map[i][j] > ave) map[i][j] -=1;
                    else if((map[i][j] < ave)) map[i][j] += 1;
                }
            }
        }



    }


}
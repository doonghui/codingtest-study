import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());


        map = new int[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x =  Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(y,x,d,g);           // r,c 으로 하기때문에 x,y 반대로
        }


        int ans = 0;
        for (int x = 0; x < 100 ; x++) {
            for(int y = 0; y < 100;y++) {
                if(map[x][y] == 1 && map[x+1][y] == 1 && map[x][y+1] == 1 && map[x+1][y+1] ==1)
                    ans++;
            }
        }



        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }


    static void dragonCurve(int x, int y,int d, int g) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(d);
        map[x][y] = 1;

        // 1~ d 세대까지의 총 방향 찾기
        for(int i =1;i<=g;i++) {
                for(int j = arr.size()-1;j>=0;j--) {
                int direction = (arr.get(j) +1) %4;
                arr.add(direction);
            }

        }

        // 그리기
        for(int k=0; k<arr.size();k++) {
            x += dx[arr.get(k)];
            y += dy[arr.get(k)];
            map[x][y] = 1;

        }




    }




}


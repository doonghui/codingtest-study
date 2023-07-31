import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m, x, y, k;
    static int[][] map;
    static int[] dice;
    static int[] dx = {0, 0, 0, -1, 1};       // 동,서,북,남
    static int[] dy = {0, 1, -1, 0, 0};


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;


        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        /* 
        *   dice[0] = 무시
        *   dice[1] = 아랫면
        *   dice[6] = 윗면
        *   1 3 6 4    동,서
        *   1 2 6 5    북,남
        * */
        dice = new int[7];
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int l = 0; l < k; l++) {
            int move = Integer.parseInt(st.nextToken());

            int nx = x + dx[move];
            int ny = y + dy[move];


            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                rollDice(move);
                x = nx;
                y = ny;

                if(map[x][y] == 0) {
                    map[x][y] = dice[1];
                } else {
                    dice[1] = map[x][y];
                    map[x][y] = 0;
                }

                bw.write(dice[6]+"\n");
            }



        }

        br.close();
        bw.flush();
        bw.close();

    }
    
    static void rollDice( int move) {
        int tmp = dice[1];      // 아랫면
        if (move == 1) {
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = tmp;
        } else if (move == 2) {
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = tmp;
        } else if (move == 3) {
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = tmp;
        } else if (move == 4) {
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = tmp;
        }


    }


}
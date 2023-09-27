import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Chess {
    int num;
    int x;
    int y;
    int dir;

    public Chess(int num, int x, int y, int dir) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

public class Main {

    static int n, k;
    static int[][] map;
    static ArrayList<Chess> chessValue;
    static ArrayList<Chess>[][] chessBoard;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        chessBoard = new ArrayList[n + 1][n + 1];
        chessValue = new ArrayList<>();


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                chessBoard[i][j] = new ArrayList<>();
            }
        }

        for (int l = 1; l <= k; l++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            chessValue.add(new Chess(l, a, b, c));
            chessBoard[a][b].add(chessValue.get(l - 1));
        }

        int turn = 0;

        while (true) {
            turn++;
            if (game()) {
                break;
            }

            if (turn > 1000) {
                turn = -1;
                break;
            }
        }


        bw.write(turn + "");
        bw.flush();     // 출력
        br.close();
        bw.close();


    }

    static boolean game() {

        for (Chess chess : chessValue) {
            int nowX = chess.x;
            int nowY = chess.y;
            int nx = nowX + dx[chess.dir];
            int ny = nowY + dy[chess.dir];
            int idx = chessBoard[nowX][nowY].indexOf(chess);

            if (nx <= 0 || nx > n || ny <= 0 || ny > n || map[nx][ny] == 2) {                 // 파란색일 때
                if (chess.dir == 1 || chess.dir == 3) chess.dir++;
                else if (chess.dir == 2 || chess.dir == 4) chess.dir--;

                nx = nowX + dx[chess.dir];
                ny = nowY + dy[chess.dir];
                if (nx > 0 && nx <= n && ny > 0 && ny <= n && map[nx][ny] != 2) {
                    idx = chessBoard[nowX][nowY].indexOf(chess);
                    if (map[nx][ny] == 1) {
                        red(nowX, nowY, nx, ny, idx);
                        if (chessBoard[nx][ny].size() >= 4) return true;
                    } else {
                        for (int i = idx; i < chessBoard[nowX][nowY].size(); i++) {
                            Chess c = chessBoard[nowX][nowY].get(i);
                            c.x = nx;
                            c.y = ny;
                            chessBoard[nx][ny].add(c);
                        }
                        for (int i = chessBoard[nowX][nowY].size() - 1; i >= idx; i--) {
                            Chess c = chessBoard[nowX][nowY].get(i);
                            chessBoard[nowX][nowY].remove(c);
                        }
                    }
                    if (chessBoard[nx][ny].size() >= 4) return true;

                }

            } else if (map[nx][ny] == 1) {                                                  // 빨간색일 때
                red(nowX, nowY, nx, ny, idx);
                if (chessBoard[nx][ny].size() >= 4) return true;

            } else {                                                                         // 흰 색일 때
                for (int i = idx; i < chessBoard[nowX][nowY].size(); i++) {
                    Chess c = chessBoard[nowX][nowY].get(i);
                    c.x = nx;
                    c.y = ny;
                    chessBoard[nx][ny].add(c);
                }
                for (int i = chessBoard[nowX][nowY].size() - 1; i >= idx; i--) {
                    Chess c = chessBoard[nowX][nowY].get(i);
                    chessBoard[nowX][nowY].remove(c);
                }


                if (chessBoard[nx][ny].size() >= 4) return true;

            }


        }
        return false;
    }

    static void red(int nowX, int nowY, int nx, int ny, int idx) {

        for (int i = chessBoard[nowX][nowY].size() - 1; i >= idx; i--) {
            Chess c = chessBoard[nowX][nowY].get(i);
            c.x = nx;
            c.y = ny;
            chessBoard[nx][ny].add(c);
        }

        for (int i = chessBoard[nowX][nowY].size() - 1; i >= idx; i--) {
            Chess c = chessBoard[nowX][nowY].get(i);
            chessBoard[nowX][nowY].remove(c);
        }


    }

}

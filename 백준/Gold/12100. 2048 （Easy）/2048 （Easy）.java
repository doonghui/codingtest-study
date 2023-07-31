import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};        // 상,하,좌,우
    static int[] dy = {0, 0, -1, 1};
    static int maxCnt = 5;
    static int max = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,board[i][j]);
            }
        }

        dfs(board, 0);


        bw.write(max + "");
        br.close();
        bw.flush();
        bw.close();

    }

    static void dfs(int[][] board, int cnt) {

        if (cnt == maxCnt) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) tmp = Math.max(tmp,board[i][j]);
            }

            max = Math.max(max,tmp);
            return;
        }


        for (int k = 0; k < 4; k++) {
            int[][] newBoard = game(board,k);
            dfs(newBoard, cnt + 1);
        }


    }




    static int[][] game(int[][] board,int location) {
        int[][] newBoard = new int[n][n];
        if (location == 0) {
            for (int y = 0; y < n; y++) {
                int idx = 0;
                int block = -1;
                for (int x = 0; x < n; x++) {
                    if (board[x][y] == 0) continue;
                    else if (board[x][y] == block) {
                        newBoard[idx - 1][y] = board[x][y] * 2;
                        block = -1;

                    } else {
                        newBoard[idx][y] = board[x][y];
                        idx++;

                        block = board[x][y];
                    }


                }
            }

        } else if (location == 1) {
            for (int y = 0; y < n; y++) {
                int idx = n - 1;
                int block = -1;
                for (int x = n - 1; x >= 0; x--) {
                    if (board[x][y] == 0) continue;
                    else if (board[x][y] == block) {
                        newBoard[idx + 1][y] = board[x][y] * 2;
                        block = -1;

                    } else {
                        newBoard[idx][y] = board[x][y];
                        idx--;
                        block = board[x][y];
                    }


                }
            }
        } else if (location == 2) {
            for (int x = 0; x < n; x++) {
                int idx = n - 1;
                int block = -1;
                for (int y = n - 1; y >= 0; y--) {
                    if (board[x][y] == 0) continue;
                    else if (board[x][y] == block) {
                        newBoard[x][idx + 1] = board[x][y] * 2;
                        block = -1;

                    } else {
                        newBoard[x][idx] = board[x][y];
                        idx--;

                        block = board[x][y];
                    }


                }
            }
        } else {
            for (int x = 0; x < n; x++) {
                int idx = 0;
                int block = -1;
                for (int y = 0; y < n; y++) {
                    if (board[x][y] == 0) continue;
                    else if (board[x][y] == block) {
                        newBoard[x][idx - 1] = board[x][y] * 2;
                        block = -1;

                    } else {
                        newBoard[x][idx] = board[x][y];
                        idx++;
                        block = board[x][y];
                    }


                }
            }
        }

        return newBoard;
    }

}
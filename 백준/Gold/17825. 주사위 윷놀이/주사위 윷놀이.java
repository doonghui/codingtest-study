import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class gragh {
    int vex;
    boolean blue;

    public gragh(int vex, boolean blue) {
        this.vex = vex;
        this.blue = blue;
    }
}

class piece {
    int vex;
    int score;
    boolean isBlue;
    boolean isFinish = false;
    int preVex = 0;

    public piece(int vex, int score, boolean isBlue) {
        this.vex = vex;
        this.score = score;
        this.isBlue = isBlue;
    }
}


public class Main {

    static int[] dice;
    static piece[] pieces;
    static boolean[] ch;
    static int[] pm;
    static ArrayList<ArrayList<gragh>> board;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        dice = new int[10];
        pieces = new piece[4];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 4; i++) {
            pieces[i] = new piece(0, 0, false);
        }


        board = new ArrayList<>();
        for (int j = 0; j < 42; j++) board.add(new ArrayList<>());

        // 0 : 시작 , 42 : 도착
        for (int k = 0; k <= 40; k += 2) {
            board.get(k).add(new gragh(k + 2, false));
        }


        board.get(10).add(new gragh(13, true));
        board.get(13).add(new gragh(16, true));
        board.get(16).add(new gragh(19, true));
        board.get(19).add(new gragh(25, true));

        board.get(20).add(new gragh(22, true));
        board.get(22).add(new gragh(24, true));
        board.get(24).add(new gragh(25, true));


        board.get(30).add(new gragh(28, true));
        board.get(28).add(new gragh(27, true));
        board.get(27).add(new gragh(26, true));
        board.get(26).add(new gragh(25, true));

        board.get(25).add(new gragh(30, true));
        board.get(30).add(new gragh(35, true));
        board.get(35).add(new gragh(40, true));
        board.get(40).add(new gragh(42, true));


        ch = new boolean[4];
        pm = new int[10];
        dfs(0, 10);

//        dfs(0);


        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();


    }

    static void dfs(int dept, int m) {
        if (dept == m) {
            move();
            for (int i = 0; i < 4; i++) {
                pieces[i].vex = 0;
                pieces[i].score = 0;
                pieces[i].isBlue = false;
                pieces[i].isFinish = false;
                pieces[i].preVex = 0;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            pm[dept] = i;
            dfs(dept + 1, m);
        }


    }

    static void move() {
        for (int i = 0; i < 10; i++) {
            int idx = pm[i];                        // 말 선택
            int nx = pieces[idx].vex;               // 지금 말이 위치한 칸
            boolean isBlue = pieces[idx].isBlue;        // 지금 지름길인지 아닌지 확인

            if (pieces[idx].isFinish) {                          // 이미 도착 칸이면 continue
                continue;
            }


            int roll = dice[i];
            while (roll-- > 0) {
                for (gragh gr : board.get(nx)) {
                    if (isBlue == gr.blue) {

                        if (pieces[idx].preVex == 25) {
                            pieces[idx].preVex = nx;
                            nx = 35;       // 말이 한 칸 움직인 후의 위치
                        } else {
                            pieces[idx].preVex = nx;
                            nx = gr.vex;          // 말이 한 칸 움직인 후의 위치
                        }
                        break;
                    }
                }


                if (nx == 42) {            // 종료조건
                    pieces[idx].isFinish = true;
                    break;
                }
            }

            if (pieces[idx].isFinish) {            // 종료조건
                continue;
            }

            pieces[idx].vex = nx;                                                                   // 말이 다이스 굴린 후 최종 도착한 칸의 정보 최신화
            pieces[idx].score += nx;
            if (nx == 10 || nx == 20 || nx == 30 || nx == 40) pieces[idx].isBlue = true;

            for (int j = 0; j < 4; j++) {
                if (idx == j) continue;
                if (pieces[j].isFinish) continue;                // 같은게 도착지점일 때
                if (pieces[idx].vex == pieces[j].vex && (nx == 40 || nx == 25)) return;             // 무효판 처리
                if (pieces[idx].vex == pieces[j].vex && pieces[idx].preVex == pieces[j].preVex && pieces[idx].isBlue == pieces[j].isBlue) {            // 38퍼에서 틀린 이유 : 22
                    return;
                }
            }


        }

        int num = 0;
        for (piece p : pieces) {
            num += p.score;
        }

        max = Math.max(max, num);

    }

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int N;
    static int max = 0;
    static boolean flag;
    static boolean[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        xxo;
//        oox;
//        xox;
//
//        xo.;
//        ox.;
//        ..x;
        ArrayList<String> ans = new ArrayList<>();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;
            char[][] map = new char[3][3];
            int x = 0;
            int o = 0;
            int dot = 0;
            int n = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = str.charAt(n);
                    map[i][j] = c;
                    if (c == 'X') x++;
                    else if (c == 'O') o++;
                    else
                        dot++;
                    n++;
                }
            }

            // 10% 에서 자꾸 틀리네..
            // x가 먼저 시작이라 무조건 x = o or x = o + 1 인 상태여야함.
            // 종료조건 1. 가로,세로,대각선으로 3칸이으면 바로 종료, 게임판 가득차면 종료.
            if (x == o || x == o + 1) {
                if (solution(map, 'X') && solution(map, 'O')) ans.add("invalid");
                else if (solution(map, 'X') && x == o + 1) ans.add("valid");
                else if (solution(map, 'O') && x == o) ans.add("valid");
                else if (!solution(map, 'X') && !solution(map, 'O')) {
                    if (x + o== 9) ans.add("valid");
                    else
                        ans.add("invalid");
                } else
                    ans.add("invalid");

            } else {
                ans.add("invalid");
            }
        }

        for (String s : ans) {
            bw.write(s + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }


    public static boolean solution(char[][] map, char c) {
        int cnt = 0;
        int bingo = 0;
        for (int i = 0; i < 3; i++) {                   // 왼 -> 오
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == c) cnt++;
            }
            if (cnt == 3) bingo++;

            cnt = 0;
        }

        for (int i = 0; i < 3; i++) {                   // 위 -> 아래
            for (int j = 0; j < 3; j++) {
                if (map[j][i] == c) cnt++;
            }
            if (cnt == 3) bingo++;

            cnt = 0;
        }

        int crossBingo = 0;
        for (int i = 0; i < 3; i++) {                   // 대각선
            if (map[i][i] == c) cnt++;
        }
        if (cnt == 3) crossBingo++;

        cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][2 - i] == c) cnt++;
        }
        if (cnt == 3) crossBingo++;


        if (bingo >= 1) return true;
        if (crossBingo >= 1) return true;

        return false;
    }


}


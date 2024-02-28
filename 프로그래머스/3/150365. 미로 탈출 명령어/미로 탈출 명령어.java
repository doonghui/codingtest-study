import java.util.*;

class Solution {

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] map;
    static char[] arr;
    static boolean flag = false;


    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        map = new int[n + 1][m + 1];
        int sub = Math.abs(x - r) + Math.abs(y - c);
        arr = new char[k];
        if (sub > k || Math.abs(sub - k) % 2 == 1) answer = "impossible";           // 테스트3 틀린이유
        else {
            sol(0, n, m, x, y, r, c, k);
            answer = new String(arr);
        }


        return answer;
    }

    static void sol(int dept, int n, int m, int x, int y, int r, int c, int k) {
        if (k < dept + Math.abs(x - r) + Math.abs(y - c)) return;                 // 시간초과나 런타임 이유

        if (dept == k && x == r && y == c) {
            flag = true;
            return;
        }

        if (dept == k) {
            return;
        };


        for (int i = 0; i < 4; i++) {
            if (flag) return;
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > n || nx < 1 || ny > m || ny < 1) continue;

            char tmp = '0';
            if (i == 0) tmp = 'd';
            else if (i == 1) tmp = 'l';
            else if (i == 2) tmp = 'r';
            else if (i == 3) tmp = 'u';

            arr[dept] = tmp;

            sol(dept + 1, n, m, nx, ny, r, c, k);
        }


    }
}
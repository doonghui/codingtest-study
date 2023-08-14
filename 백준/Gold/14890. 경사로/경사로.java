import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int n, l;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        row();
        column();

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();

    }

    static void row() {
        visited = new boolean[n][n];  //  겹치지 않게 하기 위해 ex) 21112
        for (int i = 0; i < n; i++) {
            int num = map[i][0];
            boolean flag = false;
            for (int j = 1; j < n; j++) {
                if (map[i][j] == num) {
                    continue;
                }
                if (map[i][j] == num + 1) {
                    if (!isPossibleUpSlope(i, j - 1, 0)) {
                        flag = true;
                        break;
                    }
                    num = map[i][j];
                } else if (map[i][j] == num - 1) {
                    if (!isPossibleDownSlope(i, j, 0)) {
                        flag = true;
                        break;
                    }
                    num = map[i][j];
                }
                if (map[i][j] < num - 1 || map[i][j] > num + 1) {         // 지나갈 수 없는 경우
                    flag = true;
                    break;
                }

            }
            if (!flag) {
                count++;
            }
        }
    }

    static void column() {
        visited = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            int num = map[0][j];
            boolean flag = false;
            for (int i = 1; i < n; i++) {
                if (map[i][j] == num) {
                    continue;
                }
                if (map[i][j] == num + 1) {
                    if (!isPossibleUpSlopeColumn(i - 1, j, 0)) {
                        flag = true;
                        break;
                    }
                    num = map[i][j];
                } else if (map[i][j] == num - 1) {
                    if (!isPossibleDownSlopeColumn(i, j, 0)) {
                        flag = true;
                        break;
                    }
                    num = map[i][j];
                }
                if (map[i][j] < num - 1 || map[i][j] > num + 1) {         // 지나갈 수 없는 경우
                    flag = true;
                    break;
                }

            }
            if (!flag) {
                count++;
            }
        }
    }


    static boolean isPossibleDownSlope(int x, int y, int count) {
        int tmp = map[x][y];
        for (int k = y; k < n; k++) {
            visited[x][k] = true;
            if (map[x][k] == tmp) {
                count++;
                if (count == l) return true;
            } else {
                return false;
            }
        }
        return false;
    }

    static boolean isPossibleUpSlope(int x, int y, int count) {
        int tmp = map[x][y];
        for (int k = y; k >= 0; k--) {
            if (!visited[x][k]) {           // 21112, 2112
                visited[x][k] = true;
                if (map[x][k] == tmp) {
                    count++;
                    if (count == l) return true;

                } else {
                    break;
                }
            } else {
                return false;
            }


        }

        return false;
    }


    static boolean isPossibleDownSlopeColumn(int x, int y, int count) {
        int tmp = map[x][y];
        for (int k = x; k < n; k++) {
            visited[k][y] = true;
            if (map[k][y] == tmp) {
                count++;
                if (count == l) return true;
            } else {
                break;
            }
        }

        return false;
    }

    static boolean isPossibleUpSlopeColumn(int x, int y, int count) {
        int tmp = map[x][y];
        for (int k = x; k >= 0; k--) {
            if (!visited[k][y]) {
                visited[k][y] = true;
                if (map[k][y] == tmp) {
                    count++;
                    if (count == l) return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }


        }

        return false;
    }


}

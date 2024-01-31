import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] belt = new int[N * 2 + 1];
        boolean[] robots = new boolean[N + 1];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < belt.length; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        while (true) {
            // 1. 벨트 && 로봇 같이 회전한다.
            int tmp = belt[belt.length - 1];
            for (int i = belt.length - 1; i > 1; i--) {
                belt[i] = belt[i - 1];
            }
            belt[1] = tmp;

            for (int j = robots.length - 1; j > 1; j--) {
                robots[j] = robots[j - 1];
            }
            robots[1] = false;

            // N 위에 있음 내린다.
            if (robots[N]) robots[N] = false;

            //2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            for (int i = robots.length - 2; i >= 1; i--) {
                if (robots[i] && !robots[i + 1] && belt[i + 1] >= 1) {
                    robots[i + 1] = true;
                    robots[i] = false;
                    belt[i + 1]--;
                }
            }

            // N 위에 있음 내린다.
            if (robots[N]) robots[N] = false;

            // 4. 올리는 위치의 칸이 내구도 0이 아니면 올리는 위치에 로봇을 올린다.

            if (belt[1] >= 1) {
                robots[1] = true;
                belt[1]--;
            }

            // 5. 내구도 0인 칸의 개수가 K개 이상이라면 과정 종료.
            int cnt = 0;
            for (int i = 1; i < belt.length; i++) {
                if (belt[i] == 0) cnt++;
            }

            if (cnt >= K) {
                break;
            }
            answer++;
        }


        bw.write(answer + "");
        br.close();
        bw.flush();
        br.close();
    }


}


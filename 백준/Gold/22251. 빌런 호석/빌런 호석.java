import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, K, P, X;
    // 0 ~ 9
    static int[][] arr = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1},


    };

    // 1~ N 층 에서 층수를 보여주는 K자리의 수가 있다
    // 1~ P개 반전을 시킨다... 실제로 있는 층은 X 층
    // 결국 k개의 자릿수가 있고 X 층에서 P번 반전시켜서 나오게 만들 수 있는 수들의 개수를 구하라는 말인듯 (범위 1~ N층)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int cnt = 0;

        String str = X + "";

        if (str.length() < K) {
            while (str.length() < K) {
                str = "0" + str;
            }
        }

        // str 을 P 번 반전시켜서 ans 가 나오는지 확인
        for (int i = 1; i <= N; i++) {
            String ans = i + "";         // 1층 ~ N층
            while (ans.length() < K) {
                ans = "0" + ans;
            }

            if (check(str, ans)) {
                cnt++;
            }
        }

        bw.write(cnt - 1 + "");       // 나 자신 빼주기
        br.close();
        bw.flush();
        bw.close();
    }

    static boolean check(String before, String after) {
        int count = 0;
        for (int i = 0; i < before.length(); i++) {        // 자릿수
            for (int j = 0; j < 7; j++) {
                if (arr[before.charAt(i) - '0'][j] != arr[after.charAt(i) - '0'][j]) count++;
            }
        }

        if (count <= P) return true;

        return false;

    }


}


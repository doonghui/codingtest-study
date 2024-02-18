import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String tmp = br.readLine();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = s.charAt(i) - '0';
            arr2[i] = s.charAt(i) - '0';
        }
        for (int i = 0; i < N; i++) ans[i] = tmp.charAt(i) - '0';

        // 첫번째 전구 켜져있을 때와 안 켜져있을 때
        int a = sol(arr1, ans, false);
        int b = sol(arr2, ans, true);

        if (a == -1 && b == -1) bw.write("-1");
        else if (a == -1) bw.write(b + "");
        else if (b == -1) bw.write(a + "");
        else
            bw.write(Math.min(a, b) + "");


        br.close();
        bw.flush();
        bw.close();
    }

    static int sol(int[] arr, int[] ans, boolean check) {
        int cnt = 0;
        if (check) {
            cnt++;
            arr[0] = 1- arr[0];
            arr[1] = 1- arr[1];
        }

        for (int i = 1; i < N; i++) {
            if (arr[i - 1] != ans[i - 1]) {
                cnt++;
                arr[i-1] = 1- arr[i-1];
                arr[i] = 1- arr[i];
                if (i == N - 1) continue;
                arr[i+1] = 1- arr[i+1];

            }
        }

        if (arr[N - 1] == ans[N - 1]) return cnt;
        else
            return -1;

    }
}


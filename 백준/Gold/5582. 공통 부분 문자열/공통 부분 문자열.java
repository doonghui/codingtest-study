import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static String s1, s2;
    static char[] c1, c2;
    static int[][] dp;


    static void Solution(int s1Len, int s2Len) {
        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                if (c1[i] == c2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;       // 문자열이 연속으로 같아야 하니 다를 경우 0
                }

            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s1 = br.readLine();
        s2 = br.readLine();

        int s1Len = s1.length();
        int s2Len = s2.length();

        c1 = new char[s1Len + 1];
        c2 = new char[s2Len + 1];

        for (int i = 1; i <= s1Len; i++) c1[i] = s1.charAt(i - 1);
        for (int j = 1; j <= s2Len; j++) c2[j] = s2.charAt(j - 1);

        dp = new int[s1Len + 1][s2Len + 1];
        Solution(s1Len, s2Len);
        int max = 0;

        for (int x = 1; x <= s1Len; x++) {
            for (int y = 1; y <= s2Len; y++) if (dp[x][y] > max) max = dp[x][y];

        }


        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();


    }


}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    static int n, m;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        int cnt = 0;
        String answer = br.readLine();


        for (int i = 1; i < n; i++) {
            String tmp = br.readLine();
            if (solution(answer, tmp)) cnt++;
        }


        br.close();
        bw.write(cnt + "");
        bw.flush();
        bw.close();


    }

    static boolean solution(String answer, String str) {
        int strLen = str.length();
        int answerLen = answer.length();
        int answerCnt = 0;
        boolean[] checked = new boolean[str.length()];

        for (int i = 0; i < answerLen; i++) {
            for (int j = 0; j < strLen; j++) {
                if (answer.charAt(i) == str.charAt(j) && !checked[j]) {
                    answerCnt++;
                    checked[j] = true;
                    break;
                }
            }
        }

        if (strLen - answerCnt >= -1 && strLen - answerCnt <= 1) {
            if(answerLen - answerCnt >= -1 && answerLen - answerCnt  <=1) return true;
        }


        return false;
    }


}
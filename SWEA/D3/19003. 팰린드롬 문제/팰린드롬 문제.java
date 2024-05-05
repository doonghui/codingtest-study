import java.io.*;
import java.util.*;


class Solution {
    static int N, M;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ArrayList<String> nPel = new ArrayList<>();


            // 팰린드롬인 것들 확인
            boolean pelCheck = false;
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                boolean flag = false;
                for (int j = 0; j < M / 2; j++) {
                    if (s.charAt(j) != s.charAt(M - j - 1)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) nPel.add(s);
                else
                    pelCheck = true;
            }


            // 팰린드롬이 아닌 것들 중에서 뒤집었을 때 팰린드롬인 것들 따로 넣어주기
            int pelCnt = 0;
            boolean[] ch = new boolean[nPel.size()];
            for (int x = 0; x < nPel.size(); x++) {
                if (ch[x]) continue;
                StringBuilder sb = new StringBuilder();
                String tmp = nPel.get(x);
                for (int k = 0; k < M; k++) {
                    sb.append(tmp.charAt(M - k - 1));
                }

                String newStr = sb.toString();
                // 같은 게 있는지 확인
                for (int y = x + 1; y < nPel.size(); y++) {
                    if (ch[y]) continue;
                    if (newStr.equals(nPel.get(y))) {
                        ch[x] = true;
                        ch[y] = true;
                        pelCnt += 2;
                        break;


                    }


                }

            }

            int ans = 0;

            if (pelCheck) ans += M;

            ans += pelCnt * M;


            bw.write("#" + t + " " + ans + "\n");

        }


        bw.flush();
        br.close();
        bw.close();

    }


}
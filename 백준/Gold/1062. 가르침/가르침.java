import java.io.*;
import java.util.*;


class Main {

    static int n, k;
    static ArrayList<String> arr;
    static boolean[] alphabet;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr.add(s.substring(4, s.length() - 4));
        }

        if (k < 5) bw.write(0 + "");
        else if (k == 26) bw.write(n + "");
        else {
            k = k - 5;
            alphabet = new boolean[26];
            alphabet['a' - 'a'] = true;
            alphabet['n' - 'a'] = true;
            alphabet['t' - 'a'] = true;
            alphabet['i' - 'a'] = true;
            alphabet['c' - 'a'] = true;
            dfs(0, 0);
            bw.write(max + "");

        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int idx, int count) {
        if (count == k) {
            int cnt = 0;
            for (String str : arr) {
                boolean flag = false;
                for (int i = 0; i < str.length(); i++) {
                    if (!alphabet[str.charAt(i) - 'a']) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) cnt++;
            }

            max = Math.max(max, cnt);
            return;
        }


        for (int j = idx; j < 26; j++) {
            if (!alphabet[j]) {
                alphabet[j] = true;
                dfs(j, count + 1);
                alphabet[j] = false;
            }

        }


    }


}
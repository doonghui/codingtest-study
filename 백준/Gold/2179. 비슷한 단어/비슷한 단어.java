import java.io.*;
import java.util.*;


class Main {

    static int n;
    static String[] arr;
    static int max = Integer.MIN_VALUE;
    static String[] answer;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        answer = new String[2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            arr[i] = str;
        }

        for (int j = 0; j < n; j++) {
            if (arr[j].length() < max) continue;
            check(j, arr[j]);
        }


        bw.write(answer[0] + "\n" + answer[1]);
        bw.flush();
        bw.close();
        br.close();
    }

    static void check(int idx, String str) {
        String[] arr2 = new String[n - idx - 1];
        for (int k = 0; k < arr2.length; k++) {
            arr2[k] = arr[idx + 1 + k];
        }

        for (int i = 0; i < arr2.length; i++) {
            int cnt = 0;
            if (arr2[i].length() < max) continue;
            for (int j = 0; j < arr2[i].length(); j++) {
                if (j > str.length() - 1) break;
                if (arr2[i].charAt(j) == str.charAt(j)) {
                    cnt++;
                } else
                    break;
            }
            if (cnt > max) {
                max = cnt;
                answer[0] = str;
                answer[1] = arr2[i];
            }
        }


    }


}
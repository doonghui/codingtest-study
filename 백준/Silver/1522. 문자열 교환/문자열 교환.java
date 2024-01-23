import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        s = br.readLine();
        String str = s + s;
        int aCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') aCount++;
        }


        int lt = 0;
        int rt = aCount - 1;
        int min = Integer.MAX_VALUE;

        while (true) {
            int count = 0;

            for (int i = lt; i <= rt; i++) {
                if (str.charAt(i) == 'b') count++;
            }

            min = Math.min(min, count);
            lt++;
            rt++;
            if (rt >= str.length()) break;
        }


        bw.write(min + "");
        br.close();
        bw.flush();
        br.close();
    }


}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

    static int T, K;
    static String W;
    static int min, max;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        T = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < T; i++) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            if(K == 1) {
                bw.write("1 1\n");
                continue;
            }
            for (int j = 0; j < W.length(); j++) {
                char c = W.charAt(j);

                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            sol(map);
            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) bw.write("-1\n");
            else
                bw.write(min + " " + max + "\n");
        }


        br.close();
        bw.flush();
        bw.close();

    }


    static void sol(HashMap<Character, Integer> map) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < W.length(); i++) {
            char ch = W.charAt(i);
            if (map.get(ch) < K) continue;

            int cnt = 1;
            for (int j = i + 1; j < W.length(); j++) {
                if (W.charAt(j) == ch) cnt++;

                if (cnt == K) {
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }

            }


        }
    }

}
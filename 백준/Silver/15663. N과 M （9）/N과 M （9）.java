
import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {

    static int n, m;
    static int[] arr;
    static int[] ans;
    static boolean[] check;
    static BufferedWriter bw;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ans = new int[m];
        check = new boolean[n];
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solve(0);


        br.close();
//        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    static void solve(int count) throws IOException {
        if (count == m) {
            String str = Arrays.toString(ans);
            if (set.contains(str)) return;
            set.add(str);
            for (int num : ans) {
                bw.write(num + " ");
            }

            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                ans[count] = arr[i];
                solve(count + 1);
                check[i] = false;


            }
        }

    }


}

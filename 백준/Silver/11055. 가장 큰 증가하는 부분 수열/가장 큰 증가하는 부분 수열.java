import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int[] Sol(int n, int[] arr) {
        int[] dy = new int[n];
        dy[0] = arr[0];

        for (int lt = 1; lt < n; lt++) {
            int max = Integer.MIN_VALUE;
            for (int rt = lt - 1; rt >= 0; rt--) {
                if (arr[lt] > arr[rt]) {
                    if (max < dy[rt] + arr[lt]) {
                        max = dy[rt] + arr[lt];
                        dy[lt] = max;
                    }
                }
            }
            if(dy[lt] == 0)
                dy[lt] = arr[lt];
        }


        return dy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        bw.write(Arrays.stream(Sol(n, arr)).max().getAsInt() + "");

        bw.flush();


    }
}
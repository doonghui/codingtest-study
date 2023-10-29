import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n, k;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        char[] arr = new char[n];
        boolean[] visited = new boolean[n];

        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i);
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] == 'P') {
                int start = j - k;
                int end = j + k;
                if (start < 0) start = 0;
                if (end >= n) end = n - 1;
                for (int l = start; l <= end; l++) {
                    if (arr[l] == 'H' && !visited[l]) {
                        visited[l] = true;
                        ans++;
                        break;
                    }
                }
            }
        }


        bw.write(ans + "");


        br.close();
        bw.flush();
        bw.close();

    }


}
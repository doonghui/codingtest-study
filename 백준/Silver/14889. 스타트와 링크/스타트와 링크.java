import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int min = Integer.MAX_VALUE;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());


        map = new int[n + 1][n + 1];
        int[] check = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        sol(0, check, 1);


        bw.write(min + "");
        br.close();
        bw.flush();
        bw.close();

    }

    public static void sol(int count, int[] check, int start) {
        if (count == n / 2) {
            ArrayList<Integer> sumCheck = new ArrayList<>();
            stats(check);
            return;
        }
        for (int i = start; i <= n; i++) {              // 조합으로 n/2 개의 수를 찾아내야 한다.
            check[i] = 1;
            sol(count + 1, check, i + 1);
            check[i] = 0;
        }

    }

    public static void stats(int[] check) {
       int sum = 0;
       int other = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(check[i] == 1 && check[j] == 1) {
                    sum += map[i][j];
                }
                if(check[i] == 0 && check[j] == 0) {
                    other += map[i][j];
                }

            }
        }
        int sub = Math.abs(sum - other);
        min = Math.min(min, sub);

    }


}


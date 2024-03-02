import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int N;
    static int[] arr;
    static boolean[] check;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        check = new boolean[N + 1];
        ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int j = 1; j <= N; j++) {
            check[j] = true;
            solution(j, j);
            check[j] = false;
        }
        Collections.sort(ans);

        bw.write(ans.size() + "\n");
        for (Integer i : ans) {
            bw.write(i + "\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }


    public static void solution(int n, int end) {
        if (arr[n] == end) {
            ans.add(end);
            return;
        }
        if (!check[arr[n]]) {
            check[arr[n]] = true;
            solution(arr[n], end);
            check[arr[n]] = false;
        }

    }


}


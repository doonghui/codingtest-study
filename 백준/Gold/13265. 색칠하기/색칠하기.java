import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int a, b;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] circle;
    static boolean isPossible = true;


    static void dfs(int now) {
        if(!isPossible)
            return;
        for (Integer next : arr.get(now)) {
            if(circle[next] == 0){
                circle[next] = 3-circle[now];
                dfs(next);
            }
            if(circle[next] == circle[now]){
                isPossible = false;
                return;
            }

        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr = new ArrayList<>();
            circle = new int[a + 1];
            for (int j = 0; j <= a; j++)
                arr.add(new ArrayList<Integer>());

            for (int k = 0; k < b; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr.get(x).add(y);
                arr.get(y).add(x);
            }

            for (int t = 1; t <= a; t++) {
                if (!isPossible) break;
                if (circle[t] == 0) {
                    circle[t] = 1;
                    dfs(t);
                }
            }

            if (isPossible)
                bw.write("possible\n");
            else
                bw.write("impossible\n");

            isPossible = true;

        }


        br.close();
        bw.flush();
        bw.close();


    }
}


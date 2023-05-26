import java.io.*;
import java.util.*;


public class Main {

    static ArrayList<ArrayList<Integer>> gragh;
    static int n;
    static boolean[] visited;
    static int max = 0;
    static int tmp = 0;


    static void dfs(int n) {

        if(n !=1 && gragh.get(n).size() == 1) {
            max += tmp;
            return;
        }

        for (Integer x : gragh.get(n)) {
            if(visited[x] == false){
                tmp +=1;
                visited[x] = true;
                dfs(x);
                tmp -= 1;
            }


        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());

        gragh = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            gragh.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gragh.get(a).add(b);
            gragh.get(b).add(a);
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1);
        if(max % 2 ==0)
            bw.write("No");
        else
            bw.write("Yes");


        br.close();
        bw.flush();
        bw.close();


    }
}


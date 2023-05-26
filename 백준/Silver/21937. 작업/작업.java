import java.io.*;
import java.util.*;


public class Main {

    static ArrayList<ArrayList<Integer>> gragh;
    static int n,m,x;
    static boolean[] visited;
    static int ans = 0;
//    static int cnt = 0;

    static void dfs(int node,int cnt) {


        for(int n : gragh.get(node)){
            if(!visited[n]){
                visited[n] = true;
                dfs(n,cnt+1);
            }
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        gragh = new ArrayList<>();

        for(int k = 0; k<=n;k++) {
            gragh.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gragh.get(b).add(a);
        }
        x = Integer.parseInt(br.readLine());


        visited = new boolean[n+1];
        visited[x] = true;
        dfs(x,0);

        for(boolean k : visited){
            if (k == true)
                ans += 1;
        }
        bw.write((ans-1)+"");

        br.close();
        bw.flush();
        bw.close();


    }
}


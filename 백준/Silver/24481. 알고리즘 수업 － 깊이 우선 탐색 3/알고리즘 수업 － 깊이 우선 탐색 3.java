import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> gragh;
    static boolean[] visited;
    static int[] depth;
    static int n,m,v;

    static void DFS(int v,int num) {
        visited[v] = true;
        depth[v] = num+1;

        if(v > n)
            return;
        else{
            for(int nv : gragh.get(v)) {
               if(visited[nv] == false){
                    DFS(nv,depth[v]);
               }
            }
        }



    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         v = Integer.parseInt(st.nextToken());
        gragh = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            gragh.add(new ArrayList<Integer>());
        }



        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            gragh.get(a).add(b);
            gragh.get(b).add(a);
        }

        for( ArrayList<Integer> gr : gragh){
            gr.sort(Comparator.naturalOrder());
        }
        depth = new int[n+1];
        Arrays.fill(depth,-1);
        DFS(v,-1);

        for (int x=1;x<depth.length;x++){
            System.out.println(depth[x]);
        }

    }
}


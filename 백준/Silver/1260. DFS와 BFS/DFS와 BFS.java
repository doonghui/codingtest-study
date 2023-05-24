import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] gragh;
    static boolean[] visited;
    static int n,m,v;

    static void DFS(int v) {
        visited[v] = true;
        System.out.print(v+" ");
        if(v > gragh.length-1)
            return;
        else{
            for(int i =1; i<gragh.length;i++) {
               if(gragh[v][i] == 1 && visited[i] == false){
                   DFS(i);
               }
            }
        }



    }

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        int tmp = 0;
        q.offer(v);
        visited[v] = true;
        while(!q.isEmpty()){
            tmp = q.poll();
            System.out.print(tmp+" ");
            for(int i =1; i< gragh.length;i++){
                if(gragh[tmp][i] == 1 && visited[i] == false){
                    q.offer(i);
                    visited[i] = true;

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
        gragh = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            gragh[a][b] = 1;
            gragh[b][a] = 1;
        }

        DFS(v);
        System.out.println();
        visited = new boolean[n+1];
        BFS(v);

    }
}


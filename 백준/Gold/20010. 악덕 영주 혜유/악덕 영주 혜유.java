import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int v1, v2;
    int cost;

    public Node(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node no) {
        if (this.cost < no.cost) return -1;
        else
            return 1;
    }
}

class Node2{
    int vex;
    int cost;

    public Node2(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

}

public class Main {
    static int n, m;
    static int[] parent;
    static int sum = 0;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int maxValue;
    static ArrayList<ArrayList<Node2>> arr2;

    static int Find(int x) {
        if (parent[x] == x) return x;
        else
            return parent[x] = Find(parent[x]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa < fb) parent[fa] = fb;
        else parent[fb] = fa;
    }


    static void solution(ArrayList<Node> arr) {

        for (Node nod : arr) {
            if (Find(nod.v1) != Find(nod.v2)) {
                Union(nod.v1, nod.v2);
                sum += nod.cost;
                arr2.get(nod.v1).add((new Node2(nod.v2, nod.cost)));
                arr2.get(nod.v2).add((new Node2(nod.v1, nod.cost)));
            }


        }


    }

    static void dfs(int en,int cost) {
        if (max < cost) {
                max = cost;
                maxValue = en;
        }
        for (Node2 n : arr2.get(en)) {
            if (!visited[n.vex]) {
                visited[n.vex] = true;
                dfs(n.vex,cost+n.cost);
            }
        }


    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int j = 1; j <= n; j++) parent[j] = j;

        ArrayList<Node> arr = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Node(a, b, c));
        }


        Collections.sort(arr);

        arr2 = new ArrayList<ArrayList<Node2>>();

        for (int k = 0; k <= n; k++) arr2.add(new ArrayList<Node2>());

        solution(arr);


        visited = new boolean[n + 1];
        visited[0] = true;
        dfs(0,0);

        max = 0;
        visited = new boolean[n + 1];
        visited[maxValue] = true;
        dfs(maxValue ,0);



        br.close();
        bw.write(sum + " \n"+max);
        bw.flush();
        bw.close();

    }


}
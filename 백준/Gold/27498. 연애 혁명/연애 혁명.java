import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;
    int connected;

    public Edge(int v1, int v2, int cost,int connected) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
        this.connected = connected;
    }
    @Override
    public int compareTo(Edge eo) {
        if(this.cost > eo.cost) return -1;
        else return 1;
    }

}



public class Main {
    static int n,m;
    static int[] parent;
    static int sum = 0;


    static int Find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = Find(parent[x]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa < fb) parent[fa] = fb;
        else parent[fb] = fa;
    }

    static int Sol(ArrayList<Edge> arr) {
        for(Edge e : arr) {
            if(e.connected == 1) {
                Union(e.v1,e.v2);
                sum -= e.cost;  // 37
            }
        }

        for(Edge ed : arr) {
            if(Find(ed.v1) != Find(ed.v2)) {
                sum -= ed.cost;     // 37 -18
                Union(ed.v1,ed.v2);
            }

        }


        return sum;
    }




    public static void main(String[] args ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Edge> arr = new ArrayList<>();
        parent = new int[n+1];

        for(int k=0;k<=n;k++) parent[k] = k;

        for(int i=0; i<m;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            int c =  Integer.parseInt(st.nextToken());
            int d =  Integer.parseInt(st.nextToken());
            arr.add(new Edge(a,b,c,d));
            sum += c;
        }

        Collections.sort(arr);


        bw.write(Sol(arr)+"");
        bw.flush();
        br.close();
        bw.close();






    }




}
import java.io.*;
import java.util.*;



class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    public Edge(int v1,int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge eo) {
        return this.cost - eo.cost;
    }

}


public class Main {
    static int[] unf;

    static int Find(int x) {
        if(unf[x] == x) return x;
        else return unf[x] = Find(unf[x]);
    }

    static void Union(int a,int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa > fb) unf[fb] = fa;
        else unf[fa] = fb;
    }

    static int Sol(ArrayList<Edge> arr) {
        int ans = 0;

        for(Edge ed : arr) {
            if(Find(ed.v1) != Find(ed.v2)) {
                ans += ed.cost;
                Union(ed.v1,ed.v2);
            }

        }




        return ans;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine()," ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<Edge> arr = new ArrayList<>();
        unf = new int[v+1];
        for(int j =1; j<=v;j++) unf[j] = j;


        for(int i =0; i<e;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Edge(a,b,c));
        }

        Collections.sort(arr);



        br.close();
        bw.write( Sol(arr) + "");
        bw.flush();
        bw.close();


    }
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



class Edge implements Comparable<Edge> {
    int vex;
    int cost;

    public Edge(int vex,int cost) {
        this.vex= vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge eo) {
        if(this.cost < eo.cost) return -1;
        else return 1;
    }


}

public class Main {

    static int v,e;
    static int[] ch;
    static  ArrayList<ArrayList<Edge>> arr;



    static int Sol() {
        int ans = 0;

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(1,0));

        while(!pQ.isEmpty()) {
            Edge tmp = pQ.poll();

            if(ch[tmp.vex] == 0) {
                ch[tmp.vex] = 1;
                for(Edge ed: arr.get(tmp.vex)) {
                    if(ch[ed.vex] == 0)pQ.add(new Edge(ed.vex,ed.cost));
                }
                ans += tmp.cost;
            }


        }



        return ans;
    }




    public static void main(String[] args ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine()," ");

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        ch = new int[v+1];


       arr = new ArrayList<>();
        for(int j =0;j<=v;j++) arr.add(new ArrayList<Edge>());

        for(int i =0;i<e;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Edge(b,c));
            arr.get(b).add(new Edge(a,c));
        }


        bw.write(Sol()+"");
        bw.flush();
        bw.close();
        br.close();






    }




}
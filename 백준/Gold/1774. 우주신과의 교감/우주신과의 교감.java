import java.io.*;
import java.util.*;



class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    double cost;

    public Edge(int v1, int v2, double cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ed) {
        if(this.cost < ed.cost)
            return -1;
        return 1;
    }
}





public class Main {
    static int[] unf;
    static double answer;
    static Point[] p;

    static int Find(int x) {
        if(unf[x] == x) return x;
        else return unf[x] = Find(unf[x]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa > fb) unf[fa] = fb;
        else unf[fb] = fa;
    }


    static void Sol(ArrayList<Edge> arr,int n) {
        for(int i =1; i<=n;i++) {
            for(int j=i+1;j<=n;j++) {
                    double d1 = Math.pow(p[i].x-p[j].x,2);
                    double d2 = Math.pow(p[i].y-p[j].y,2);
                    double cost = Math.sqrt(d1+d2);
                    arr.add(new Edge(i,j,cost));

            }
        }

        Collections.sort(arr);
        answer = 0;
        for(Edge e : arr) {
            if(Find(e.v1) != Find(e.v2)) {
                Union(e.v1,e.v2);
                answer += e.cost;
            }
        }



    }





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n+1];
        for(int k = 1; k<=n;k++) unf[k] = k;

        ArrayList<Edge> arr = new ArrayList<>();

        p = new Point[n+1];
        for(int i =1 ;i<=n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            p[i] = new Point(x,y);
        }

        for(int j = n; j<n+m;j++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Union(a,b);
        }

        Sol(arr,n);

        bw.write(String.format("%.2f",answer)+" ");     // Math.round() 는 뒤에 0 절삭..
        bw.flush();


    }
}


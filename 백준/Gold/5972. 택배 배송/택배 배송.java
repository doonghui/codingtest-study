import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Point implements Comparable<Point> {
    int vex;
    int cost;

    public Point(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    public int compareTo(Point po) {
        return this.cost - po.cost;
    }
}

public class Main {

    static int N, M;
    static int[] dis;
    static ArrayList<ArrayList<Point>> gragh;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gragh = new ArrayList<>();
        for (int i = 0; i <= N; i++) gragh.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            gragh.get(a).add(new Point(b, c));
            gragh.get(b).add(new Point(a, c));


        }

        dis = new int[N + 1];

        Arrays.fill(dis, Integer.MAX_VALUE);

        solution();
        bw.write(dis[N] + "");
        br.close();
        bw.flush();
        bw.close();
    }

    static void solution() {
        PriorityQueue<Point> pQ = new PriorityQueue<>();
        pQ.add(new Point(1, 0));
        dis[1] = 0;

        while (!pQ.isEmpty()) {
            Point p = pQ.poll();

            for (Point po : gragh.get(p.vex)) {
                if (dis[po.vex] > p.cost + po.cost) {
                    dis[po.vex] = p.cost + po.cost;
                    pQ.add(new Point(po.vex, dis[po.vex]));
                }

            }

        }


    }
}


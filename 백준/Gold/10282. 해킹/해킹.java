import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Point implements Comparable<Point> {
    int v;
    int cnt;

    public Point(int v, int cnt) {
        this.v = v;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point po) {
        return this.cnt - po.cnt;
    }
}


class Main {
    static int T, N, D, C;
    static ArrayList<ArrayList<Point>> gragh;
    static boolean[] infection;
    static int[] dist;
    static int max;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            gragh = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                gragh.add(new ArrayList<>());
            }

            infection = new boolean[N + 1];
            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            max = 0;
            count = 0;

            for (int k = 0; k < D; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                gragh.get(b).add(new Point(a, cnt));
            }

            infect();


            for (int l : dist) {
                if (l != Integer.MAX_VALUE) {
                    count++;
                    max = Math.max(max, l);
                }
            }


            bw.write(count + " " + max + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }

    // 시간초과를 어떻게 해결하지?
    static void infect() {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(C, 0));
        dist[C] = 0;
        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.cnt > dist[point.v]) continue;

            for (Point p : gragh.get(point.v)) {

                if (p.cnt + dist[point.v] < dist[p.v]) {
                    dist[p.v] = p.cnt + dist[point.v];
                    q.add(new Point(p.v, p.cnt));

                }


            }


        }
    }

}


//1
//4 5 1
//4 1 1
//2 4 10
//3 1 2
//2 3 2
//3 2 2

//1 2 3 4
//0   2 1
//  2
//  10
//    2


// 0 2 2 1 -> 5


//1 -> 4 : 1
//4 -> 2 : 10
//1 -> 3 : 2
//3 -> 2 : 2
//2 -> 3 : 2


//        1->2:2
//        1->3:8
//        2->3:4

// 1 2 3
//   2  8
//      4

//
//        1->2:5
//        2->3:5
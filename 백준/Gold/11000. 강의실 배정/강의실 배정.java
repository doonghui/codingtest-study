
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Point implements Comparable<Point> {
    int a;
    int b;

    public Point(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Point po) {
        if (this.a == po.a) {
            return this.b - po.b;
        }
        return this.a - po.a;
    }

}


public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Point> p = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x < min) min = x;
            if (y > max) max = y;
            p.add(new Point(x, y));
        }

        Collections.sort(p);


        br.close();
        bw.write(sol(p, max, min) + "");
        bw.flush();
        bw.close();
    }


    static int sol(ArrayList<Point> p, int last, int first) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (Point poi : p) {
            if (!pq.isEmpty() && pq.peek() <= poi.a) {
                pq.poll();
            }

            pq.add(poi.b);


        }


        return pq.size();

    }


}




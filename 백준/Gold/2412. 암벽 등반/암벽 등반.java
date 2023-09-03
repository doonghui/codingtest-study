import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Point {
    int x;
    int y;
    boolean visited;
    int cnt;

    public Point(int x, int y, boolean visited, int cnt) {
        this.x = x;
        this.y = y;
        this.visited = visited;
        this.cnt = cnt;
    }


}


class Main {
    static ArrayList<ArrayList<Point>> gragh;
    static int n, t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        gragh = new ArrayList<>();
        for(int k =0;k<=t;k++) gragh.add(new ArrayList<Point>());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gragh.get(b).add(new Point(a, b, false, 0));
        }


        int ans = bfs();

        br.close();
        bw.write(ans + "");
        bw.flush();
        bw.close();

    }


    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, false, 0));

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int j = tmp.y - 2; j <= tmp.y + 2; j++) {
                if(j <0 || j>t)continue;
                for (Point po : gragh.get(j)) {
                    if (po.visited) continue;
                    if (Math.abs(tmp.x - po.x) <= 2) {
                        if (po.y == t) return tmp.cnt + 1;
                        po.visited = true;
                        po.cnt = tmp.cnt + 1;
                        q.add(po);
                    }
                }

            }



        }

        return -1;
    }
}
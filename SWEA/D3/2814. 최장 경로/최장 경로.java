import java.io.*;
import java.util.*;

class Point {
    int v;
    int cost;

    public Point(int v, int cost) {
        this.v = v;
        this.cost = cost;

    }


}

class Solution {
    static ArrayList<ArrayList<Integer>> gragh;
    static int N, M;
    static boolean[] check;
    static int answer;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            gragh = new ArrayList<>();

            for (int j = 0; j <= N; j++) gragh.add(new ArrayList<>());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                gragh.get(a).add(b);        // 무방향 그래프
                gragh.get(b).add(a);
            }


            answer = 0;
            for (int k = 1; k <= N; k++) {
                for (int l = k; l <= N; l++) {
                    check = new boolean[N + 1];
//                    bfs(k, l);
                    dfs(k, l, 0);
                }


            }


            bw.write("#" + t + " " + answer + "\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }

    static void dfs(int v, int end, int count) {

        if (v == end) {
            answer = Math.max(answer, count);
            return;

        }


        // x와 연결된 정점들 확인
        for (Integer i : gragh.get(v)) {
            if (check[i]) continue;            // 이미 한번 방문한 정점

            check[i] = true;
            dfs(i, end, count + 1);
            check[i] = false;

        }


    }

//    static void bfs(int start, int end) {
//
//        Queue<Point> q = new LinkedList<>();
//        q.add(new Point(start, 1));
//        check[start] = true;
//        int count = 1;
//
//        while (!q.isEmpty()) {
//            Point p = q.poll();
//
//            if (p.v == end) {
//                answer = Math.max(answer, p.cost);
//                continue;
//            }
//
//            // x와 연결된 정점들 확인
//            for (Integer i : gragh.get(p.v)) {
//                if (check[i]) continue;            // 이미 한번 방문한 정점
//
//                check[i] = true;
//                q.add(new Point(i, p.cost + 1));
//
//            }
//
//
//        }
//
//
//    }

}
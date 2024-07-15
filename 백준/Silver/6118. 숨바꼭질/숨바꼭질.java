import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {


    static int N, M;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> gragh;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gragh = new ArrayList<>();
        for (int i = 0; i <= N; i++) gragh.add(new ArrayList<>());
        dist = new int[N + 1];

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gragh.get(a).add(b);
            gragh.get(b).add(a);
        }

        bfs(1);


//        for(Integer in : dist) {
//            System.out.print(in+" ");
//        }
//
        int max = 0;
        int count = 0;

        for (int k = 1; k <= N; k++) {
            if (dist[k] > dist[max]) {
                max = k;
                count = 1;
            } else if (dist[k] == dist[max]) {
                count++;
            }
        }

        bw.write(max + " " + dist[max] + " " + count);
        bw.flush();
        bw.close();
        br.close();

    }


    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int num = q.poll();

            for (Integer i : gragh.get(num)) {
                if (dist[i] != 0 || i == 1) continue;

                dist[i] = dist[num] + 1;
                q.add(i);

            }


        }


    }


}


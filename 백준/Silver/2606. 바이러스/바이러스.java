import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Integer>> gragh;
    static int[] ch;
    static int cnt = 0;

    static void Sol() {
        Queue<Integer> q = new LinkedList();
        q.offer(1);
        ch[1] = 1;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int nv : gragh.get(tmp)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    q.offer(nv);
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        ch = new int[n + 1];
        gragh = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++)
            gragh.add(new ArrayList<>());

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gragh.get(a).add(b);
            gragh.get(b).add(a);
        }


        Sol();
        for(int x : ch){
            if( x ==1)
                cnt++;
        }
        br.close();
        bw.write((cnt-1) + "");
        bw.flush();
        bw.close();


    }

}
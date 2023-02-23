import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<ArrayList<Integer>> gragh;
    static int[] ch;
    static int[] dis;

    static void Sol(int s) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        ch[s] =1;
        while(!Q.isEmpty()) {
            int tmp = Q.poll();
            for(int x : gragh.get(tmp)){
                if(ch[x] == 0) {
                    ch[x] =1;
                    Q.offer(x);
                    dis[x] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        ch = new int[n+1];
        dis = new int[n+1];

        gragh = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            gragh.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gragh.get(a).add(b);
            gragh.get(b).add(a);
        }

        Sol(1);

        for(int k =2; k<=n;k++)
            bw.write(dis[k]+"\n");


        br.close();
        bw.flush();
        bw.close();


    }
}

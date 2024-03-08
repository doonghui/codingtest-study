import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Network implements Comparable<Network> {
    int v1;
    int v2;
    int cost;

    public Network(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    public int compareTo(Network o) {
        return this.cost - o.cost;
    }

}

public class Main {

    static int N, M;
    static int[] unf;
    static ArrayList<Network> net;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        net = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            net.add(new Network(a, b, c));
        }

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;

        Collections.sort(net);
        long cost = 0;
        for (Network work : net) {
            if (Find(work.v1) != Find(work.v2)) {
                Union(work.v1, work.v2);
                cost += work.cost;
            }
        }


        bw.write(cost + "");
        br.close();
        bw.flush();
        bw.close();
    }


    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) unf[fa] = unf[fb];
    }

    static int Find(int v) {

        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }


}


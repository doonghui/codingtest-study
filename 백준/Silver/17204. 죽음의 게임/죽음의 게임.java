import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] gragh;
    static int[] ch;

    static int Sol(int m) {
        Queue<Integer> Q = new LinkedList<>();
        int cnt = 0;
        Q.offer(0);
        while (!Q.isEmpty()) {
            int tmp = Q.poll();
            if (tmp == m)
                return cnt;
            if (ch[tmp] == 1)
                return -1;
            Q.offer(gragh[tmp]);
            ch[tmp] = 1;
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[n];
        gragh = new int[n];
        for (int i = 0; i < n; i++) {
            gragh[i] = Integer.parseInt(br.readLine());
        }


        br.close();
        bw.write(Sol(m) + "");
        bw.flush();
        bw.close();


    }
}
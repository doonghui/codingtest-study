import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long n, m;
    static int[] nx = {2, 1};

    static int Sol(long s, long e) {
        Queue<Long> Q = new LinkedList<>();
        Q.offer(s);
        int L = 1;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                long tmp = Q.poll();
                for (int x : nx) {
                    if (x == 2) {
                        s = (long) tmp * x;
                    } else {
                        s = tmp * 10L + x;
                    }
                    if ( s == e) return L + 1;
                    if ( s < e) {
                        Q.offer(s);
                    }
                }
            }
            L++;
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


        br.close();
        bw.write(Sol(n, m) + "");
        bw.flush();
        bw.close();


    }
}

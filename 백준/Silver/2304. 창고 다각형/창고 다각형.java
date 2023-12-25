import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Pillar implements Comparable<Pillar> {
    int x;
    int y;

    public Pillar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pillar pi) {
        return this.x - pi.x;
    }

}


class Main {

    static int N, L, H;
    static ArrayList<Pillar> pillars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        pillars = new ArrayList<>();
        int maxH = Integer.MIN_VALUE;
        int maxLIdx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            pillars.add(new Pillar(L, H));
        }
        Collections.sort(pillars);
        for (int j = 0; j < pillars.size(); j++) {
            if (pillars.get(j).y > maxH) {
                maxH = pillars.get(j).y;
                maxLIdx = j;
            }
        }


        long answer = area(maxH, maxLIdx);


        bw.write(answer + "");
        br.close();
        bw.flush();
        br.close();
    }


    public static long area(int maxH, int maxLIdx) {
        long ans = maxH;
        int x = pillars.get(0).x;
        int y = pillars.get(0).y;
        for (int i = 1; i <= maxLIdx; i++) {
            if (y < pillars.get(i).y) {
                ans += (pillars.get(i).x - x) * y;
                x = pillars.get(i).x;
                y = pillars.get(i).y;
            }
            if (i == maxLIdx && y == pillars.get(i).y) {
                ans += (long) (pillars.get(i).x - x) * y;
            }
        }
        x = pillars.get(pillars.size() - 1).x;
        y = pillars.get(pillars.size() - 1).y;
        for (int j = pillars.size() - 2; j >= maxLIdx; j--) {
            if (y < pillars.get(j).y) {
                ans +=  (x - (pillars.get(j).x)) * y;
                x = pillars.get(j).x;
                y = pillars.get(j).y;
            }
            if (j == maxLIdx && y == pillars.get(j).y) {
                ans += (long) (x - pillars.get(j).x) * y;
            }
        }
        return ans;
    }
}



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Pillar implements Comparable<Pillar> {
    int l;
    int h;

    public Pillar(int l, int h) {
        this.l = l;
        this.h = h;
    }

    @Override
    public int compareTo(Pillar pi) {
        return this.l - pi.l;
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
            if (pillars.get(j).h > maxH) {
                maxH = pillars.get(j).h;
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
        int x = pillars.get(0).l;
        int y = pillars.get(0).h;
        for (int i = 1; i <= maxLIdx; i++) {
            if (y < pillars.get(i).h) {
                ans += (long) (pillars.get(i).l - x) * y;
                x = pillars.get(i).l;
                y = pillars.get(i).h;
            }
            if(i == maxLIdx && y == pillars.get(i).h) {
                ans += (long) (pillars.get(i).l - x) * y;
            }
        }
        y = pillars.get(pillars.size() - 1).h;
        x = pillars.get(pillars.size() - 1).l;
        for (int j = pillars.size() - 2; j >= maxLIdx; j--) {
            if (y < pillars.get(j).h) {
                ans += (long) (x - (pillars.get(j).l)) * y;
                x = pillars.get(j).l;
                y = pillars.get(j).h;
            }
            if(j == maxLIdx && y == pillars.get(j).h) {
                ans += (long) (x-pillars.get(j).l) * y;
            }
        }
        return ans;
    }
}



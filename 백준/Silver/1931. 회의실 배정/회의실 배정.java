import java.io.*;
import java.util.*;


class Point implements Comparable<Point> {
    int s;
    int e;

    public Point(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Point po) {
        if(this.e == po.e) return this.s - po.s;
        return this.e - po.e;
    }

}

class Main {
    static int N;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());


        ArrayList<Point> p = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            p.add(new Point(a, b));
        }

        Collections.sort(p);

        int preTime = 0;
        int count = 0;
        for (int j = 0; j < N; j++) {
            if (preTime <= p.get(j).s) {
                preTime = p.get(j).e;
                count++;
            }
        }


        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();

    }


}
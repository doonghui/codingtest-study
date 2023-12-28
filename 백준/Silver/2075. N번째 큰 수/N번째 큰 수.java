import java.io.*;
import java.util.*;


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

    static int N;
    ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            }
        }

        int count = 0;
        int answer = 0;
        while (true) {
            int tmp = q.poll();
            count++;
            if (count == N) {
                answer = tmp;
                break;
            }


        }

        bw.write(answer + "");
        br.close();
        bw.flush();
        br.close();
    }


}









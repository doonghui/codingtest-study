import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


class Point implements Comparable<Point> {
    int id;
    int num;
    int score;

    public Point(int id, int num, int score) {
        this.id = id;
        this.num = num;
        this.score = score;
    }

    public int compareTo(Point po) {
        return po.score - this.score;
    }
}


class Entry implements Comparable<Entry> {
    int id;
    int point;
    int count;
    int lastSubmit;

    public Entry(int id, int point, int count, int lastSubmit) {
        this.id = id;
        this.point = point;
        this.count = count;
        this.lastSubmit = lastSubmit;
    }

    public int compareTo(Entry en) {
        if (en.point == this.point) {
            if (en.count == this.count) return this.lastSubmit - en.lastSubmit;
            return this.count - en.count;
        }
        return en.point - this.point;
    }
}

class Main {

    static int t;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());                       // 팀의 개수
            int k = Integer.parseInt(st.nextToken());                       // 문제 개수
            int j = Integer.parseInt(st.nextToken());                       // 나의 팀 ID
            int m = Integer.parseInt(st.nextToken());                       // 엔트리의 개수


            int[] submit = new int[n + 1];                                    // 마지막으로 제출한 횟수 알기 위해서
            int[] submitCnt = new int[n + 1];                                    // 팀마다 문제 제출 횟수 알기 위해서
            ArrayList<Point> points = new ArrayList<>();                    // 높은 순서대로 저장하기 위해
            for (int l = 0; l < m; l++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());                   // 팀 ID
                int b = Integer.parseInt(st.nextToken());                   // 문제 번호
                int c = Integer.parseInt(st.nextToken());                   // 흭득한 점수
                points.add(new Point(a, b, c));
                submit[a] = l;
                submitCnt[a] += 1;

            }
            Collections.sort(points);
            bw.write(solution(points, n, k, j, submit, submitCnt) + "\n");
        }


        br.close();
        bw.flush();
        bw.close();


    }

    static int solution(ArrayList<Point> points, int n, int k, int j, int[] submit, int[] submitCnt) {
        ArrayList<Entry> entries = new ArrayList<>();
        int[][] team = new int[n + 1][k + 1];                               // 팀의 문제마다 최고점수 저장 위해서

        for (Point p : points) {
            if (team[p.id][p.num] == 0) {
                team[p.id][p.num] = p.score;
            }
        }
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int y = 1; y <= k; y++) {
                sum += team[i][y];
            }
            entries.add(new Entry(i, sum, submitCnt[i], submit[i]));
        }

        Collections.sort(entries);


        for (int z = 0; z <= entries.size(); z++) {
            if (entries.get(z).id == j) return z + 1;
        }


        return 0;
    }


}
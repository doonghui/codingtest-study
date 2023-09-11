import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Tree implements Comparable<Tree> {
    int age;
    public Tree(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Tree to) {
        return this.age - to.age;
    }
}

class Point {
    int x;
    int y;
    public Point(int x,int y) {
        this.x = x;
        this.y =y;
    }
}

class Main {

    static int n, m, k;
    static int[][] food;
    static int[][] map;
    static PriorityQueue<Tree>[][] treeMap;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        food = new int[n + 1][n + 1];
        treeMap = new PriorityQueue[n + 1][n + 1];

        for (int t = 1; t <= n; t++) {
            for (int l = 1; l <= n; l++) {
                map[t][l] = 5;

            }
        }


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
                treeMap[i][j] = new PriorityQueue<>();

            }
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            treeMap[x][y].add(new Tree(z));
        }

        while (k-- > 0) {
            ArrayList<Point> points = new ArrayList<>();
            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    if (!treeMap[x][y].isEmpty()) {
                        springSummer(x, y);
                        points.add(new Point(x,y));
                    }
                }
            }

            for(Point po : points) {
                fall(po.x,po.y);
            }



            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    map[x][y] += food[x][y];
                }
            }
        }
        int count = 0;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                count += treeMap[x][y].size();
            }
        }


        br.close();
        bw.write(count+"\n");

        bw.flush();
        bw.close();

    }



    static void springSummer(int x, int y) {
        PriorityQueue<Tree> tmpTreeMap = new PriorityQueue<>();

        while (!treeMap[x][y].isEmpty()) {
            Tree tree = treeMap[x][y].poll();
            if (tree.age <= map[x][y]) {
                map[x][y] -= tree.age;
                tree.age++;
                tmpTreeMap.add(tree);
            } else {
                map[x][y] += (tree.age / 2);
               break;
            }
        }
        while (!treeMap[x][y].isEmpty()){
            Tree tre = treeMap[x][y].poll();
            map[x][y] += (tre.age / 2);
        }


        while (!tmpTreeMap.isEmpty()) treeMap[x][y].add(tmpTreeMap.poll());
    }

    static void fall(int x, int y) {
        ArrayList<Point> tmpPoint = new ArrayList<>();

        for (Tree t : treeMap[x][y]) {
            if (t.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
                        tmpPoint.add(new Point(nx,ny));
                    }
                }
            }
        }

        for(Point tr : tmpPoint) {
            treeMap[tr.x][tr.y].add(new Tree(1));
        }
    }

}


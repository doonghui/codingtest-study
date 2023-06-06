import java.awt.*;
import java.io.*;
import java.util.*;
//
//class Point {
//    int x;
//    int y;
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}


public class Main {
    static int n;
    static int a, b;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] circle;


    static String bfs(int p) {
        Queue<Integer> q = new LinkedList<>();
        q.add(p);
        circle[p] = 1;
        while(!q.isEmpty()) {
            Integer tmp = q.poll();
            for(Integer in : arr.get(tmp)) {
                if(circle[in] == 0) {
                    circle[in] = 3-circle[tmp];
                    q.add(in);
                }
                if(circle[in] == circle[tmp])
                    return "impossible";
            }
        }

        return "possible";


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr = new ArrayList<>();
            circle = new int[a + 1];
            for (int j = 0; j <= a; j++)
                arr.add(new ArrayList<Integer>());

            for (int k = 0; k < b; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr.get(x).add(y);
                arr.get(y).add(x);
            }

            for (int t = 1; t <= a; t++) {
                if (arr.get(t).size() != 0) {
                    bw.write(bfs(t)+"\n");
                    break;
                }
            }


        }



        br.close();
//        bw.write( " ");
        bw.flush();
        bw.close();


    }
}


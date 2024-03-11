import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point o) {
        return this.x - o.x;
    }

}

public class Main {

    static int N;
    static ArrayList<Point> gragh;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        gragh = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gragh.add(new Point(x, y));
        }

        Collections.sort(gragh);

        Stack<Point> stack = new Stack<>();
        stack.push(gragh.get(0));
        int count = 0;
        for (int j = 1; j < N; j++) {
            while (gragh.get(j).y < stack.peek().y) {
                count++;
                stack.pop();
                if (stack.size() == 0) break;
            }
            if (stack.size() == 0 || gragh.get(j).y > stack.peek().y) stack.add(gragh.get(j));
        }

        if (stack.size() == 1) {
            if (stack.peek().y != 0) count++;
        } else if (stack.size() > 1) {
            while (!stack.isEmpty() && stack.pop().y > 0) {
                count++;

            }
        }


        bw.write(count + "");
        br.close();
        bw.flush();
        bw.close();
    }


}

//4
//1 4
//2 3
//3 5
//4 4
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int vex;
    int cost;

    public Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
}

public class Main {

    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] ch;
    static int max_vex;

    static void solution(ArrayList<ArrayList<Node>> arr,int v,int cost) {
        if(cost > max) {
            max = cost;
            max_vex = v;
        }
        ch[v] = 1;

                for(Node n : arr.get(v)){
                    if(ch[n.vex] == 0) {
                        ch[n.vex] = 1;
                        solution(arr,n.vex,cost+n.cost);
                    }
                }

            }





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        ch = new int[n+1];

        ArrayList<ArrayList<Node>> arr = new ArrayList<>();

        for (int j = 0; j <= n; j++) arr.add(new ArrayList<Node>());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int c = Integer.parseInt(st.nextToken());
                arr.get(a).add(new Node(v, c));
            }
        }



            solution(arr,1,0);

            ch = new int[n+1];

            solution(arr,max_vex,0);



        br.close();
        bw.write(max+" ");
        bw.flush();
        bw.close();

    }


}
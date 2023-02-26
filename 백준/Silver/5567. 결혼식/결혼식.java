import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] ch;

    static void Sol() {
        ch = new int[n + 1];
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int x : arr.get(1)) {
            q.offer(x);
            cnt++;
            ch[x] =1;
        }

        while (cnt -->0) {
            int tmp = q.poll();
            for (int x : arr.get(tmp)) {
                if(ch[x] == 1)
                    continue;
                else
                    ch[x] =1;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }


        Sol();
        int ans =0;
        for(int k = 2;k<=n;k++){
            if(ch[k] == 1)
                ans++;
        }
        br.close();
        bw.write(ans + "");
        bw.flush();
        bw.close();


    }
}

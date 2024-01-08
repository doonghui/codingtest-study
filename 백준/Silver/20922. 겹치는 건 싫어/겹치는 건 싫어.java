import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], 0);
        }

        int lt = 0;
        int rt = 0;
        int max = 1;
        map.put(arr[lt], 1);
        while (true) {
            rt++;
            if(rt >= N) break;
            map.put(arr[rt], map.get(arr[rt]) + 1);
            if (map.get(arr[rt]) > K) {
                while(map.get(arr[rt]) >K) {
                    map.put(arr[lt], map.get(arr[lt]) - 1);
                    lt++;
                }
            }
            max = Math.max(rt - lt+1, max);

        }


        bw.write(max+"");
        br.close();
        bw.flush();
        br.close();
    }


}

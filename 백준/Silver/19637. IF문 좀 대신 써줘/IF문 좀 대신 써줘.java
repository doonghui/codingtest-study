import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Power {
    String name;
    int num;

    public Power(String name, int num) {
        this.name = name;
        this.num = num;
    }


}

class Main {

    static int n, m;
    static ArrayList<Power> arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        int tmp = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            if (tmp == b) continue;
            tmp = b;
            arr.add(new Power(a, b));
        }

        for (int j = 0; j < m; j++) {
            int c = Integer.parseInt(br.readLine());
            int idx = binarySearch(0, arr.size() - 1, c);
            bw.write(arr.get(idx).name + "\n");
        }


        br.close();
        bw.flush();
        bw.close();


    }

    static int binarySearch(int lt, int rt, int answer) {

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (answer < arr.get(mid).num) {
                rt = mid - 1;
            } else if (answer > arr.get(mid).num) {
                lt = mid + 1;
            } else {
                return mid;
            }
        }

        if (lt >= arr.size()) lt = arr.size() - 1;
        return lt;


    }


}
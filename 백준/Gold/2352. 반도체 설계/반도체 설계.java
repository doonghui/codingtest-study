import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;



class Main {

    static int n;
    static int[] arr;
    static ArrayList<Integer> dist;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dist = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis();



        br.close();
        bw.write(dist.size()-1 + "");
        bw.flush();
        bw.close();

    }

    static void lis() {
        dist.add(0);            // 임의의 아무값
        dist.add(arr[1]);

        for (int i = 2; i <= n; i++) {
            if (dist.get(dist.size()-1) < arr[i]) {
                dist.add(arr[i]);
            }
            else {
                int idx = binarySearch(1,dist.size()-1, i);
                dist.set(idx,arr[i]);

            }

        }


    }

    static int binarySearch(int left, int right, int idx) {
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (dist.get(mid) < arr[idx]) left = mid + 1;
            else if (dist.get(mid) > arr[idx]) right = mid-1;
            else return mid;

        }

        return left;
    }


}


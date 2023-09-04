import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[] arr;
    static ArrayList<Integer> list;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sol();



        bw.write(list.size()-1 + "");
        bw.flush();
        br.close();
        bw.close();
    }


    static void sol() {
        list.add(-1_000_000_001);

        for (int i = 0; i < n; i++) {
            if(arr[i] > list.get(list.size()-1)) list.add(arr[i]);
            else
                binarySearch(i);
        }

    }




    static void binarySearch(int idx) {
        int left = 0;
        int right = list.size()-1;
        int mid;
        while(left < right) {
            mid = (left + right)/2;
            if(list.get(mid) < arr[idx]) {
                left = mid+1;
            } else if(list.get(mid) >= arr[idx]) {
                right = mid;
            }
        }

        list.set(right,arr[idx]);

    }

}




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        binarySearch(arr);


        bw.write(max + "");


        br.close();
        bw.flush();
        bw.close();

    }

    static void binarySearch(int[] arr) {
        int lt = 1;
        int rt = arr[arr.length - 1];

        while (lt <= rt) {
            int sum = 0;
            int mid = (lt + rt) / 2;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= mid) sum += arr[i];
                else
                    sum += mid;
            }

            if (sum > m) {
                rt = mid - 1;
            } else if (sum < m) {
                lt = mid + 1;
                max = Math.max(max, mid);
            } else {
                max = mid;
                return;
            }
        }


    }


}

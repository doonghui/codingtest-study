import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main {
    static ArrayList<Long> arr;
    static long[] ans;
    static int n;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());
            arr.add(a);
        }

        Collections.sort(arr);

        ans = new long[3];
        for (int i = 0; i < n - 2; i++) {
            boolean check = twoPointer(i, i + 1, n - 1);
            if (check) break;

        }

        br.close();
        bw.write(ans[0] + " " + ans[1] + " " + ans[2] + "");
        bw.flush();
        bw.close();

    }


    static boolean twoPointer(int idx, int left, int right) {
        while (left < right) {
            long sum = arr.get(idx) + arr.get(left) + arr.get(right);
            if (Math.abs(sum) < min) {
                ans[0] = arr.get(idx);
                ans[1] = arr.get(left);
                ans[2] = arr.get(right);
                min = Math.abs(sum);
            }
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
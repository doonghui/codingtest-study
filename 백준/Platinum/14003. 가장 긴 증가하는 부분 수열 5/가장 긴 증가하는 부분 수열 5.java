import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main {

    static int n;
    static int[] arr;
    static ArrayList<Integer> dist;
    static ArrayList<Integer>  distIdx;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        distIdx = new ArrayList<>();
        dist = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis();
        ArrayList<Integer> ans = new ArrayList<>();
        int temp = dist.size()-1;
        for(int x = distIdx.size()-1; x >=0;x--) {
            if(temp == distIdx.get(x)) {
                ans.add(arr[x]);
                temp--;
            }
        }



        br.close();
        bw.write(dist.size() + "\n");
       for(int k = ans.size()-1;k>=0;k--) {
           bw.write(ans.get(k)+" ");
       }
        bw.flush();
        bw.close();

    }

    static void lis() {
        dist.add(arr[0]);
        distIdx.add(0);
        int tmp = 0;
        for (int i = 1; i < n; i++) {
            if (dist.get(dist.size() - 1) < arr[i]) {
                tmp++;
                distIdx.add(tmp);
                dist.add(arr[i]);
            } else {
                int idx = binarySearch(0, dist.size() - 1, i);
                distIdx.add(idx);
                dist.set(idx, arr[i]);

            }

        }


    }

    static int binarySearch(int left, int right, int idx) {
        int mid = 0;
        if (dist.get(0) > arr[idx]) return 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (dist.get(mid) < arr[idx]) left = mid + 1;
            else if (dist.get(mid) > arr[idx]) right = mid - 1;
            else
                return mid;
        }


        return left;
    }


}

